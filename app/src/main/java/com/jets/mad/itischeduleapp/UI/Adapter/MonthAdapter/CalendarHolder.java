package com.jets.mad.itischeduleapp.UI.Adapter.MonthAdapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;
import com.roomorama.caldroid.CaldroidFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/7/2017.
 */

public class CalendarHolder {

    private TextView day;
    private TextView session1;
    private TextView session2;
    private TextView session3;

    private boolean disabledFlag;

    public CalendarHolder(View rootView){

        day = (TextView) rootView.findViewById(R.id.day);
        session1 = (TextView) rootView.findViewById(R.id.session1);
        session2 = (TextView) rootView.findViewById(R.id.session2);
        session3 = (TextView) rootView.findViewById(R.id.session3);
    }

    public void configure(String dayData, ArrayList<Session> sessions){

        if(disabledFlag){
            day.setTextColor(CaldroidFragment.disabledTextColor);

        }
        day.setText(dayData);
        Log.i("TAG", "CalendarHolder configure: " + String.valueOf(sessions.size()));
        for (int i= 0; i< 3 && i<sessions.size(); i++){
            switch (i){
                case 0:
                    session1.setText(sessions.get(0).getName());
                    session1.setBackgroundColor(sessions.get(0).getColor());
                    break;
                case 1:
                    session2.setText(sessions.get(1).getName());
                    session2.setBackgroundColor(sessions.get(1).getColor());
                    break;
                case 2:
                    session3.setText(sessions.get(2).getName());
                    session3.setBackgroundColor(sessions.get(2).getColor());
                    break;
                default:
            }
        }

    }

    public void setDisabledFlag(boolean disabledFlag){
        this.disabledFlag = disabledFlag;
    }

}
