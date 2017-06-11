package com.zsq.view;

import javax.swing.*;

public class AbstractFrame extends JFrame {

    private final transient String _cname = this.getClass().getName();

    protected String getCname() {
        return _cname;
    }
}
