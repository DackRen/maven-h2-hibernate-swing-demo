package com.zsq.view.referential.bar;

import javax.swing.*;
import java.io.Serializable;

/**
 * This JavaBean is the bar that is on each frame. It has the 6 following buttons :<BR>
 * Find   : When clicking on the button a FindEvent is sent to the listening frame
 * Create : When clicking on the button a CreateEvent is sent to the listening frame
 * Delete : When clicking on the button a DeleteEvent is sent to the listening frame
 * Update : When clicking on the button a UpdateEvent is sent to the listening frame
 * Reset  : When clicking on the button a ResetEvent is sent to the listening frame
 * Close  : When clicking on the button a CloseEvent is sent to the listening frame
 */
public final class ManageBar extends JPanel implements Serializable {

    // Variables declaration
    private final JButton buttonFind = new JButton();
    private final JButton buttonCreate = new JButton();
    private final JButton buttonDelete = new JButton();
    private final JButton buttonUpdate = new JButton();
    private final JButton buttonReset = new JButton();
    private final JButton buttonClose = new JButton();

    private BarEventListener listener;

    /**
     * Creates new panel ManageOBar
     */
    public ManageBar() {
        initComponents();
    }

    public void setManageListener(final BarEventListener listener) {
        this.listener = listener;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {
        buttonFind.setText("Find");
        buttonFind.addActionListener(evt -> buttonViewActionPerformed());
        add(buttonFind);

        buttonCreate.setText("Create");
        buttonCreate.addActionListener(evt -> buttonSaveActionPerformed());
        add(buttonCreate);

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(evt -> buttonDeleteActionPerformed());
        add(buttonDelete);

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(evt -> buttonUpdateActionPerformed());
        add(buttonUpdate);

        buttonReset.setText("Reset");
        buttonReset.addActionListener(evt -> buttonResetActionPerformed());
        add(buttonReset);

        buttonClose.setText("Close");
        buttonClose.addActionListener(evt -> buttonCloseActionPerformed());
        add(buttonClose);

    }

    private void buttonResetActionPerformed() {
        listener.reset(new ResetEvent(this));
    }

    private void buttonUpdateActionPerformed() {
        listener.update(new UpdateEvent(this));
    }

    private void buttonDeleteActionPerformed() {
        listener.delete(new DeleteEvent(this));
    }

    private void buttonSaveActionPerformed() {
        listener.create(new CreateEvent(this));
    }

    private void buttonViewActionPerformed() {
        listener.find(new FindEvent(this));
    }

    private void buttonCloseActionPerformed() {
        listener.close(new CloseEvent(this));
    }
}