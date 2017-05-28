package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;

import java.util.ArrayList;

public class DayRecyclerAdapter<Events> extends BaseRecyclerViewAdapter {

    private int cellId;

    public DayRecyclerAdapter(ArrayList data, int cellId) {
        super(data);
        this.cellId = cellId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        DayHolder dayViewHolder = new DayHolder(v);
        return dayViewHolder;
    }
}
