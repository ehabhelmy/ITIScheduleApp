package com.jets.mad.itischeduleapp.UI.Adapter.DayDetailsAdapter;

import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.datalayer.Models.User;

/**
 * Created by lenovo on 6/5/2017.
 */

public class DayDetailAdapter {

    private Events event;

    public DayDetailAdapter(Events event) {
        this.event = event;

    }

    public void setDataView(View rootView) {

        TextView name = (TextView) rootView.findViewById(R.id.day_details_name);
        TextView startTime = (TextView) rootView.findViewById(R.id.day_details_start_time);
        TextView endTime = (TextView) rootView.findViewById(R.id.day_details_end_time);
        TextView description = (TextView) rootView.findViewById(R.id.day_details_description);

        if (event != null) {
            name.setText(event.getEventName());
            startTime.setText(event.getStartTime());
            endTime.setText(event.getEndTime());
            description.setText(event.getDescription());
        } else {
            //TODO: throw exception
        }

    }
}
