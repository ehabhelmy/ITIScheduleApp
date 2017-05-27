package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;

import java.util.ArrayList;

public class DayMarkerRecyclerAdapter<Date> extends BaseRecyclerViewAdapter {


    private int cellId;

    public DayMarkerRecyclerAdapter(ArrayList<Date> data, int cellId) {
        super(data);
        this.cellId = cellId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        DayMarkerHolder dayMarkerHolder = new DayMarkerHolder(v);
        return dayMarkerHolder;
    }
}
