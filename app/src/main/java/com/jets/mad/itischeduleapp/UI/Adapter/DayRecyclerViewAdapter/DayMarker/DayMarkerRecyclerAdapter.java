package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;

import java.util.ArrayList;

public class DayMarkerRecyclerAdapter<String> extends BaseRecyclerViewAdapter {

    private int cellId;
    private onItemClick listener;

    public DayMarkerRecyclerAdapter(int cellId) {
        super();
        this.cellId = cellId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        final DayMarkerHolder dayMarkerHolder = new DayMarkerHolder(v);
        if(listener != null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(data, dayMarkerHolder.getAdapterPosition());
                }
            });
        }
        return dayMarkerHolder;
    }


    public void setListener(onItemClick listener) {
        this.listener = listener;
    }
}
