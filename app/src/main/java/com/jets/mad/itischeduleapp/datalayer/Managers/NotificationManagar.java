package com.jets.mad.itischeduleapp.datalayer.Managers;

import com.jets.mad.itischeduleapp.UI.Presenter.Interface.INotification;

/**
 * Created by lenovo on 6/6/2017.
 */

public class NotificationManagar implements INotification.INotificationModel {

    private INotification.INotificationPresenter presenter;

    public NotificationManagar(INotification.INotificationPresenter presenter){
        this.presenter = presenter;
    }
}
