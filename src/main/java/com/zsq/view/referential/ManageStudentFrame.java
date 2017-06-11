package com.zsq.view.referential;

import com.zsq.domain.Student;
import com.zsq.exception.EntityException;
import com.zsq.repository.StudentRepository;
import com.zsq.view.AbstractFrame;
import com.zsq.view.referential.bar.*;
import org.hibernate.ObjectNotFoundException;

import javax.swing.*;
import java.awt.*;

public final class ManageStudentFrame extends AbstractFrame implements BarEventListener {
    // Variables declaration
    private final JLabel labelTitle = new JLabel();
    private final JPanel panelCenter = new JPanel();
    private final JTextField textId = new JTextField();
    private final JTextField textName = new JTextField();

    private final ManageBar manageBar = new ManageBar();

    /**
     * Creates new form
     */
    public ManageStudentFrame() {
        initComponents();
        pack();
        manageBar.setManageListener(this);
    }

    // This method is called from within the constructor to display all the graphical components
    private void initComponents() {
        // Panel North
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font("Dialog", 1, 18));
        labelTitle.setText("Student");

        getContentPane().add(labelTitle, BorderLayout.NORTH);

        // Panel Center
        panelCenter.setLayout(new GridLayout(14, 2));

        panelCenter.add(new JLabel("ID"));
        panelCenter.add(textId);

        panelCenter.add(new JLabel("Name"));
        panelCenter.add(textName);

        getContentPane().add(panelCenter, BorderLayout.CENTER);

        // Panel South
        getContentPane().add(manageBar, BorderLayout.SOUTH);
    }

    public void create(final CreateEvent evt) {
        final String mname = "create";

        // Sets all the Customer data
        final Student student = new Student(textId.getText() ,textName.getText());

        new StudentRepository().save(student);
    }

    public void delete(final DeleteEvent evt) {
        final String mname = "delete";

        try {
            // Deletes the customer
            new StudentRepository().delete(textId.getText());
            reset(new ResetEvent(this));

        } catch (EntityException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot delete the student", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(getCname() + mname + e);
        }
    }

    public void find(final FindEvent evt) {
        final String mname = "find";

        try {
            // Finds the student
            final Student student = new StudentRepository().findOne(textId.getText());

            // Displays the data
            textId.setText(student.getId());
            textName.setText(student.getName());

        } catch (ObjectNotFoundException e) {
            JOptionPane.showMessageDialog(this, "This student has not been found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot find the student", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(getCname() + mname + e);
        }
    }

    public void update(final UpdateEvent evt) {
        final String mname = "update";

        // Sets all the Customer data
        try {
            final Student student = new StudentRepository().findOne(textId.getText());
            new StudentRepository().save(student);
        } catch (EntityException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot update the student", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(getCname() + mname + e);
        }
    }

    public void reset(final ResetEvent evt) {
        textId.setText("");
        textName.setText("");
    }

    public void close(final CloseEvent evt) {
        dispose();
    }
}
