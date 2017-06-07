package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Presenter.Interface.INotification;
import com.jets.mad.itischeduleapp.datalayer.Managers.NotificationManagar;

public class NotificationPresenter implements INotification.INotificationPresenter {

    private INotification.INotificationView view;
    private INotification.INotificationModel manager;

    public NotificationPresenter(INotification.INotificationView view){
        this.view = view;
        manager = new NotificationManagar(this);
    }
}
