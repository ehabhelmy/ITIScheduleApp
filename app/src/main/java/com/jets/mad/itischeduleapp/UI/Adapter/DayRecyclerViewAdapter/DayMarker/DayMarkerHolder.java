package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;

import java.util.Date;

public class DayMarkerHolder extends BaseViewHolder<Date> {

    private TextView day;

    public DayMarkerHolder(View itemView) {
        super(itemView);

        day = (TextView) itemView.findViewById(R.id.day_marker);
    }

    @Override
    public void configure(Date baseModel) {
        Log.i("TAG", "DayMarkerHolder : configure: " + String.valueOf(baseModel.getDay()));
        day.setText(String.valueOf(baseModel.getDay()));
    }


}
