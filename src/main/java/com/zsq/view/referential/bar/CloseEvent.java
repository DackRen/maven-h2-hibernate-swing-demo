package com.zsq.view.referential.bar;

/**
 * This event is sent to the listening frame when the Close button of the ManageBar is pressed.
 */
public final class CloseEvent extends AbstractBarEvent {

    public CloseEvent(final Object source) {
        super(source);
    }
}
