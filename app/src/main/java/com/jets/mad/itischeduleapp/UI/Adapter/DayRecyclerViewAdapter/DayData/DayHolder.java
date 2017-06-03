package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayData;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;


public class DayHolder extends BaseViewHolder<Events> {

    private CardView cardView;
    private TextView id;
    public TextView startTime;
    public TextView endTime;
    public TextView eventName;
    private View cardColor;

    public DayHolder(View itemView) {
        super(itemView);

        cardView = (CardView)itemView.findViewById(R.id.day_card);
        cardView.setTag(this);
        id = (TextView) itemView.findViewById(R.id.day_event_id);
        startTime = (TextView)itemView.findViewById(R.id.day_start_time);
        endTime = (TextView)itemView.findViewById(R.id.day_end_time);
        eventName = (TextView)itemView.findViewById(R.id.day_event_name);
        cardColor =  itemView.findViewById(R.id.day_card_color);
    }


    @Override
    public void configure(Events event) {

        id.setText(String.valueOf(event.getId()));
        startTime.setText(event.getStartTime());
        endTime.setText(event.getEndTime());
        eventName.setText(event.getEventName());
        cardColor.setBackgroundColor(event.getColor());
    }

    public int getId(){
        return Integer.parseInt(id.getText().toString());
    }
}
