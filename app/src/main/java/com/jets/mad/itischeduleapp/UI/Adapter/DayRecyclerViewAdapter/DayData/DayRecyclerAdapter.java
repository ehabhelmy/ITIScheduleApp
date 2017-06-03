package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jets.mad.itischeduleapp.AppController;
import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;

import java.util.ArrayList;

public class DayRecyclerAdapter<Events> extends BaseRecyclerViewAdapter {

    private int cellId;
    private onItemClick listener;

    public DayRecyclerAdapter(int cellId) {
        super();
        this.cellId = cellId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        final DayHolder dayViewHolder = new DayHolder(v);
        final Animation a = AnimationUtils.loadAnimation(AppController.getInstance(), R.anim.open_center);
        v.setAnimation(a);
        if(listener != null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onItemClick(data, dayViewHolder.getAdapterPosition());
                }
            });
        }
        return dayViewHolder;
    }

    public void setListener(onItemClick listener) {
        this.listener = listener;
    }
}
