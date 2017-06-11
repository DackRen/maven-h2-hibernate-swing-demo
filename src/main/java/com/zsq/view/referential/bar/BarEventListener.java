package com.zsq.view.referential.bar;

import java.util.EventListener;

/**
 * Frames that implements this listener would be able to responde when the followig events occur :<BR>
 * CreateEvent : the create button of the ManageBar has been pressed<BR>
 * DeleteEvent : the delete button of the ManageBar has been pressed<BR>
 * FindEvent   : the find button of the ManageBar has been pressed<BR>
 * UpdateEvent : the modify button of the ManageBar has been pressed<BR>
 * ResetEvent  : the reset button of the ManageBar has been pressed<BR>
 * CloseEvent  : the close button of the ManageBar has been pressed<BR>
 */
public interface BarEventListener extends EventListener {

    void create(CreateEvent evt);

    void delete(DeleteEvent evt);

    void find(FindEvent evt);

    void update(UpdateEvent evt);

    void reset(ResetEvent evt);

    void close(CloseEvent evt);

}
