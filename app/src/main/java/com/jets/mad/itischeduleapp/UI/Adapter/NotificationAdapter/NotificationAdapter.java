package com.jets.mad.itischeduleapp.UI.Adapter.NotificationAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;

public class NotificationAdapter<Notification> extends BaseRecyclerViewAdapter {

    private int cellId;
    private onItemClick listener;

    public NotificationAdapter(int cellId) {
        super();
        this.cellId = cellId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        final NotificationHolder notificationHolder = new NotificationHolder(v);
        return notificationHolder;
    }

}