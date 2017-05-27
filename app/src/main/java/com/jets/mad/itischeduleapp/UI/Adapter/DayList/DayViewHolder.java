package com.jets.mad.itischeduleapp.UI.Adapter.DayList;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;


public class DayViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView startTime;
    TextView endTime;
    TextView eventName;
    View cardColor;

    DayViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView)itemView.findViewById(R.id.day_card);
        startTime = (TextView)itemView.findViewById(R.id.day_start_time);
        endTime = (TextView)itemView.findViewById(R.id.day_end_time);
        eventName = (TextView)itemView.findViewById(R.id.day_event_name);
        cardColor =  itemView.findViewById(R.id.day_card_color);
    }
}

