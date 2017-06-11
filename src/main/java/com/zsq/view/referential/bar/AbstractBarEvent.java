package com.zsq.view.referential.bar;

import java.util.EventObject;

/**
 * Super class of all the Events sent by the ManageBar.
 */
public abstract class AbstractBarEvent extends EventObject {

    AbstractBarEvent(final Object source) {
        super(source);
    }
}
