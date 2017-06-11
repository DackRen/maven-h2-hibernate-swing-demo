package com.zsq.view.list;

import com.zsq.view.AbstractFrame;

import javax.swing.*;
import java.awt.*;


/**
 * This abstract class helps concrete classes to display lists of data in a JTable.
 */
public abstract class AbstractListFrame extends AbstractFrame {

    private JTable table;

    public AbstractListFrame() {
        super();
        initComponents();
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // This method is called from within the constructor to display all the graphical components
    private void initComponents() {
        try {
            table = new JTable(getData(), getColumnNames());
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));

            final JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot display the list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected abstract String[] getColumnNames();

    // This method returns all the data to fill the table
    protected abstract String[][] getData();
}
