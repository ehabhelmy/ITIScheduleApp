package com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker;

import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseViewHolder;

public class DayMarkerHolder extends BaseViewHolder<String> {

    private TextView day;

    public DayMarkerHolder(View itemView) {
        super(itemView);

        day = (TextView) itemView.findViewById(R.id.day_marker);
    }

    @Override
    public void configure(String baseModel) {
        day.setText(baseModel);


    }
}
