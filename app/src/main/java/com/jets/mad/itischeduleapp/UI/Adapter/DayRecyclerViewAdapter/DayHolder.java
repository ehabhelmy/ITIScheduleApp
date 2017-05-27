package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;


public class DayHolder extends BaseViewHolder<Events> {

    private CardView cardView;
    private TextView startTime;
    private TextView endTime;
    private TextView eventName;
    private View cardColor;

    public DayHolder(View itemView) {
        super(itemView);

        cardView = (CardView)itemView.findViewById(R.id.day_card);
        startTime = (TextView)itemView.findViewById(R.id.day_start_time);
        endTime = (TextView)itemView.findViewById(R.id.day_end_time);
        eventName = (TextView)itemView.findViewById(R.id.day_event_name);
        cardColor =  itemView.findViewById(R.id.day_card_color);
    }


    @Override
    public void configure(Events event) {
        startTime.setText(event.getStartTime());
        endTime.setText(event.getEndTime());
        eventName.setText(event.getEventName());
        cardColor.setBackgroundColor(event.getColor());
    }
}
