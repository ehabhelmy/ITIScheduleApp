package com.jets.mad.itischeduleapp.UI.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.INotification;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.NotificationPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements INotification.INotificationView{

    private INotification.INotificationPresenter presenter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        presenter = new NotificationPresenter(this);
        return rootView;
    }

}
