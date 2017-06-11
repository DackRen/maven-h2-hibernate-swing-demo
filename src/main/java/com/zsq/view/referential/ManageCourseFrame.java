package com.zsq.view.referential;

import com.zsq.domain.Course;
import com.zsq.domain.Student;
import com.zsq.exception.EntityException;
import com.zsq.repository.CourseRepository;
import com.zsq.view.AbstractFrame;
import com.zsq.view.referential.bar.*;
import org.hibernate.ObjectNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public final class ManageCourseFrame extends AbstractFrame implements BarEventListener {

    // Variables declaration
    private final JLabel labelTitle = new JLabel();
    private final JPanel panelCenter = new JPanel();
    private final JTextField textId = new JTextField();
    private final JTextField textName = new JTextField();
    private final JTextField textStudents = new JTextField();

    private final ManageBar manageBar = new ManageBar();

    /**
     * Creates new form
     */
    public ManageCourseFrame() {
        initComponents();
        pack();
        manageBar.setManageListener(this);
    }

    // This method is called from within the constructor to display all the graphical components
    private void initComponents() {
        // Panel North
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font("Dialog", 1, 18));
        labelTitle.setText("Course");

        getContentPane().add(labelTitle, BorderLayout.NORTH);

        // Panel Center
        panelCenter.setLayout(new GridLayout(3, 2));

        panelCenter.add(new JLabel("ID"));
        panelCenter.add(textId);

        panelCenter.add(new JLabel("Name"));
        panelCenter.add(textName);

        panelCenter.add(new JLabel("Students"));
        panelCenter.add(textStudents);

        getContentPane().add(panelCenter, BorderLayout.CENTER);

        // Panel South
        getContentPane().add(manageBar, BorderLayout.SOUTH);
    }

    public void create(final CreateEvent evt) {
        final String mname = "create";

        // Sets all the Category data
        final Course course = new Course(textId.getText() ,textName.getText(), new ArrayList<>());
        new CourseRepository().save(course);
    }

    public void delete(final DeleteEvent evt) {
        final String mname = "delete";

        try {
            // Deletes the category
            new CourseRepository().delete(textId.getText());
            reset(new ResetEvent(this));
        } catch (EntityException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot delete the course", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(getCname() + mname + e);
        }
    }

    public void find(final FindEvent evt) {
        final String mname = "find";
        Course course = null;
        try {
            course = new CourseRepository().findOne(textId.getText());

            // Displays the data
            textId.setText(course.getId());
            textName.setText(course.getName());
        } catch (ObjectNotFoundException e) {
            JOptionPane.showMessageDialog(this, "This course has not been found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot find the course", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(getCname() + mname + e);
        }

        StringBuilder studentLists = new StringBuilder();
        for (Student student : course.getStudents()) {
            studentLists.append(student.getName()).append(", ");
        }

        textStudents.setText(studentLists.toString());
    }

    public void update(final UpdateEvent evt) {
        final String mname = "update";

        // Sets all the Category data
        final Course course = new Course(textId.getText() ,textName.getText(), new ArrayList<>());

        new CourseRepository().save(course);
    }

    public void reset(final ResetEvent evt) {
        textStudents.setText("");
        textId.setText("");
        textName.setText("");
    }

    public void close(final CloseEvent evt) {
        dispose();
    }
}
