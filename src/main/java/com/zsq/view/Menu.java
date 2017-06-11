package com.zsq.view;

import com.zsq.view.list.ListCourseFrame;
import com.zsq.view.list.ListStudentFrame;
import com.zsq.view.referential.ManageCourseFrame;
import com.zsq.view.referential.ManageStudentFrame;
import com.zsq.view.register.ManageRegisterCourseFrame;

import javax.swing.*;

/**
 * Created by renjunzhou on 2017/6/10.
 */

/**
 * This class represents the main user interface that displays a menu from which the
 * employee can do some actions on the system.
 */
public class Menu extends AbstractFrame {

    // Variables declaration
    private final JMenuBar menuBar = new JMenuBar();

    private final JMenu menuFile = new JMenu();
    private final JMenuItem menuItemExit = new JMenuItem();

    private final JMenu menuRegister = new JMenu();
    private final JMenuItem menuItemRegisterCourse = new JMenuItem();

    private final JMenu menuReferential = new JMenu();
    private final JMenuItem menuItemManageStudent = new JMenuItem();
    private final JMenuItem menuItemManageCourse = new JMenuItem();

    private final JMenu menuList = new JMenu();
    private final JMenuItem menuListStudent = new JMenuItem();
    private final JMenuItem menuListCourse = new JMenuItem();

    /**
     * Creates new form Menu.
     */
    public Menu() {
        initComponents();
        setSize(400, 300);
        setTitle("Student System");
        setJMenuBar(menuBar);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // This method is called from within the constructor to display all the graphical components
    private void initComponents() {

        // Menu File
        menuFile.setText("File");

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(evt -> menuItemExitActionPerformed());

        menuFile.add(menuItemExit);
        menuBar.add(menuFile);

        // Menu Order
        menuRegister.setText("Register");

        menuItemRegisterCourse.setText("Register Courses");
        menuItemRegisterCourse.addActionListener(evt -> menuItemRegisterCourseActionPerformed());
        menuRegister.add(menuItemRegisterCourse);

        menuBar.add(menuRegister);

        // Menu Referential
        menuReferential.setText("Manage");

        menuItemManageCourse.setText("Manage Course");
        menuItemManageCourse.addActionListener(evt -> menuItemManageCourseActionPerformed());
        menuReferential.add(menuItemManageCourse);

        menuItemManageStudent.setText("Manage Student");
        menuItemManageStudent.addActionListener(evt -> menuItemManageStudentActionPerformed());
        menuReferential.add(menuItemManageStudent);

        menuBar.add(menuReferential);

        // Menu List
        menuList.setText("Lists");

        menuListStudent.setText("List students");
        menuListStudent.addActionListener(evt -> menuListStudentActionPerformed());
        menuList.add(menuListStudent);

        menuListCourse.setText("List courses");
        menuListCourse.addActionListener(evt -> menuListCourseActionPerformed());
        menuList.add(menuListCourse);

        menuBar.add(menuList);

    }

    // This method opens the Manage Order frame
    private void menuItemRegisterCourseActionPerformed() {
        new ManageRegisterCourseFrame().show();
    }


    // This method opens the Manage Customer frame
    private void menuItemManageCourseActionPerformed() {
        new ManageCourseFrame().show();
    }

    // This method opens the Manage Category frame
    private void menuItemManageStudentActionPerformed() {
        new ManageStudentFrame().show();
    }

    // This method opens the Customer List frame
    private void menuListStudentActionPerformed() {
        new ListStudentFrame().show();
    }

    // This method opens the Category List frame
    private void menuListCourseActionPerformed() {
        new ListCourseFrame().show();
    }

    // This method exits the application
    private void menuItemExitActionPerformed() {
        dispose();
    }

    public static void main(final String[] args) {
        new Menu().show();
    }
}

