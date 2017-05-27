package com.jets.mad.itischeduleapp.UI.Adapter.DayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 5/26/2017.
 */

public class DayRecyclerViewAdapter extends RecyclerView.Adapter<DayViewHolder>{

    ArrayList<Events> data;

    public DayRecyclerViewAdapter(ArrayList<Events> data){
        this.data = data;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_day, parent, false);
        DayViewHolder dayViewHolder = new DayViewHolder(v);
        return dayViewHolder;

    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        holder.startTime.setText(data.get(position).getStartTime());
        holder.endTime.setText(data.get(position).getEndTime());
        holder.eventName.setText(data.get(position).getEventName());
        holder.cardColor.setBackgroundColor(data.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
