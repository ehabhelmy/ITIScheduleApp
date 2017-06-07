package com.jets.mad.itischeduleapp.UI.Adapter.MyEventsAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

/**
 * Created by ehabm on 6/5/2017.
 */

public class MyEventsAdapter extends BaseRecyclerViewAdapter<Events> {

    private int cellId;

    public MyEventsAdapter(int cellId) {
        this.cellId = cellId;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(cellId,parent,false);
        MyEventHolder myEventHolder = new MyEventHolder(view);
        return myEventHolder;
    }
}
