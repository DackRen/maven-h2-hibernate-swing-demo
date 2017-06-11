package com.zsq.view.register;

import com.zsq.exception.EntityException;
import com.zsq.repository.CourseRepository;
import com.zsq.service.CourseService;
import com.zsq.view.AbstractFrame;

import javax.swing.*;
import java.awt.*;

public final class ManageRegisterCourseFrame extends AbstractFrame {

    private final JLabel labelTitle = new JLabel();

    private final JPanel panelCenter = new JPanel();
    private final JPanel panelCenterNorth = new JPanel();
    private final JPanel panelCenterSouth = new JPanel();
    private final JPanel panelSouth = new JPanel();

    private final JTextField textStudentId = new JTextField();
    private final JComboBox comboName = new JComboBox();

    private final JButton buttonRegisterCourses = new JButton();
    private final JButton buttonUpdateCourses = new JButton();


    public ManageRegisterCourseFrame() {
        initComponents();
        setTitle("Student Information manage - Register Course");
        setSize(500, 610);
    }

    // This method is called from within the constructor to display all the graphical components
    private void initComponents() {
        panelCenter.setLayout(new GridLayout(2, 1));

        // Panel North
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font("Dialog", 1, 18));

        getContentPane().add(labelTitle, BorderLayout.NORTH);

        // Panel Center North
        panelCenterNorth.setLayout(new GridLayout(14, 2));

        panelCenterNorth.add(new JLabel("Student ID"));
        textStudentId.setEnabled(true);
        panelCenterNorth.add(textStudentId);

        panelCenterNorth.add(new JLabel("Course Name"));
        comboName.setEnabled(true);
        panelCenterNorth.add(comboName);

        panelCenter.add(panelCenterNorth);
        panelCenter.add(panelCenterSouth);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        // Panel North
        labelTitle.setText("Register Course");

        // Panel South
        panelSouth.setLayout(new GridLayout(1, 2));

        buttonUpdateCourses.setText("Update Course");
        buttonUpdateCourses.addActionListener(evt -> buttonUpdateActionPerformed());

        buttonRegisterCourses.setText("Register");
        buttonRegisterCourses.addActionListener(evt -> buttonRegisterActionPerformed());
        panelSouth.add(buttonRegisterCourses);
        panelSouth.add(buttonUpdateCourses);

        getContentPane().add(panelSouth, BorderLayout.SOUTH);
    }

    private void buttonUpdateActionPerformed() {
        for (String name : new CourseRepository().findAllName()){
            comboName.addItem(name);
        }
    }

    private void buttonRegisterActionPerformed() {
        final String mname = "buttonRegisterActionPerformed";

        String studentId = textStudentId.getText();
        String courseId = new CourseRepository().findIdByName(comboName.getSelectedItem().toString());

        try {
            new CourseService().registerCourse(courseId, studentId);
        } catch (EntityException e) {
            System.out.println(e + mname);
        }
    }
}
