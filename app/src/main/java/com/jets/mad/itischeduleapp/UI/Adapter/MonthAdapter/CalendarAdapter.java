package com.jets.mad.itischeduleapp.UI.Adapter.MonthAdapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.Collections2;
import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.OnDayClickListener;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;
import com.jets.mad.itischeduleapp.utils.Predicate.DayPredicate;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import java.util.ArrayList;
import java.util.Map;

import hirondelle.date4j.DateTime;

/**
 * Created by ehabm on 5/26/2017.
 */

public class CalendarAdapter extends CaldroidGridAdapter {
    /**
     * Constructor
     *
     * @param context
     * @param month
     * @param year
     * @param caldroidData
     * @param extraData
     */

    private OnDayClickListener onDayClickListener;
    private ArrayList<Session> sessions;
    private DateTime dateTime;

    public CalendarAdapter(Context context, int month, int year, Map<String, Object> caldroidData, Map<String, Object> extraData, OnDayClickListener onDayClickListener) {
        super(context, month, year, caldroidData, extraData);
        this.onDayClickListener = onDayClickListener;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cellView = convertView;

        // For reuse
        if (convertView == null) {
            cellView = inflater.inflate(R.layout.cell_month, null);

        }


        int topPadding = cellView.getPaddingTop();
        int leftPadding = cellView.getPaddingLeft();
        int bottomPadding = cellView.getPaddingBottom();
        int rightPadding = cellView.getPaddingRight();


        // Get dateTime of this cell
        dateTime = this.datetimeList.get(position);
        Resources resources = context.getResources();

        cellView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "day "+ dateTime.getDay()+ " clicked", Toast.LENGTH_SHORT).show();
                onDayClickListener.onDayClick(dateTime);
            }
        });

//        // Set color of the dates in previous / next month
//        if (dateTime.getMonth() != month) {
//            tv1.setTextColor(resources
//                    .getColor(com.caldroid.R.color.caldroid_darker_gray));
//        }


        CalendarHolder calendarHolder = new CalendarHolder(cellView);


        boolean shouldResetDiabledView = false;
        boolean shouldResetSelectedView = false;

        // Customize for disabled dates and date outside min/max dates
        if ((minDateTime != null && dateTime.lt(minDateTime))
                || (maxDateTime != null && dateTime.gt(maxDateTime))
                || (disableDates != null && disableDates.indexOf(dateTime) != -1)) {

//            tv1.setTextColor(CaldroidFragment.disabledTextColor);

            calendarHolder.setDisabledFlag(true);

            if (CaldroidFragment.disabledBackgroundDrawable == -1) {
                cellView.setBackgroundResource(com.caldroid.R.drawable.disable_cell);
            } else {
                cellView.setBackgroundResource(CaldroidFragment.disabledBackgroundDrawable);
            }

            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(com.caldroid.R.drawable.red_border_gray_bg);
            }

        } else {
            shouldResetDiabledView = true;
        }

        // Customize for selected dates
        if (selectedDates != null && selectedDates.indexOf(dateTime) != -1) {
            cellView.setBackgroundColor(resources
                    .getColor(com.caldroid.R.color.caldroid_sky_blue));

//            tv1.setTextColor(Color.BLACK);

        } else {
            shouldResetSelectedView = true;
        }

        if (shouldResetDiabledView && shouldResetSelectedView) {
            // Customize for today
            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(R.drawable.month_cell);
            } else {
                cellView.setBackgroundResource(com.caldroid.R.drawable.cell_bg);
            }
        }

        //set Data into view
//        ArrayList<Session> filteredSessions = (ArrayList<Session>) Collections2.filter(sessions, new DayPredicate(dateTime));
        calendarHolder.configure(dateTime.getDay().toString(), sessions);

        // Somehow after setBackgroundResource, the padding collapse.
        // This is to recover the padding
        cellView.setPadding(leftPadding, topPadding, rightPadding,
                bottomPadding);

        // Set custom color if required
//        setCustomResources(dateTime, cellView, tv1);

        return cellView;
    }

    public void setData(ArrayList<Session> sessions){
        this.sessions = sessions;
    }

    public DateTime getDateTime(){
        return dateTime;
    }
}
