package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import android.graphics.Color;
import android.util.Log;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker.DayMarkerRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayData.DayRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;


public class HomePresenter implements IHome.IHomePresenter {

    public static final int DAY_MARKER = 0;
    public static final int DAY_Data = 1;


    private IHome.IHomeActivity homeActivity;

    private BaseRecyclerViewAdapter dayRecyclerAdapter;
    private BaseRecyclerViewAdapter dayMarkerAdapter;


    public HomePresenter(IHome.IHomeActivity homeActivity){
        this.homeActivity = homeActivity;
        prepareDayAdapter(new ArrayList<Events>());
        prepareDayMarker(new ArrayList<String>());
    }

    /*================================  IHome.IHomePresenter Interface ===================================*/

    /***
     * This function is called by the network when it gets data fom backend
     ***/
    @Override
    public void prepareDayAdapter(ArrayList<Events> events) {

        //testing data
        events.add(new Events("9 A.M.", "10 A.M.", "Study IOS", Color.parseColor("#f1534a")));
        events.add(new Events("11 A.M.", "12 A.M.", "Study Android", Color.parseColor("#a9534a")));
        events.add(new Events("1 A.M.", "2 A.M.", "Study Design Pattern", Color.parseColor("#4bce12")));
        events.add(new Events("9 A.M.", "10 A.M.", "Study IOS", Color.parseColor("#f1534a")));
        events.add(new Events("11 A.M.", "12 A.M.", "Study Android", Color.parseColor("#a9534a")));
        events.add(new Events("1 A.M.", "2 A.M.", "Study Design Pattern", Color.parseColor("#4bce12")));

        dayRecyclerAdapter = new DayRecyclerAdapter(events, R.layout.cell_day);

    }

    public void prepareDayMarker(ArrayList<String> dateArrayList){
        dateArrayList.add("Tues 29");
        dateArrayList.add("Wed 30");
        dateArrayList.add("Thur 31");
        dateArrayList.add("Fri 1");
        dateArrayList.add("Sat 2");
        dateArrayList.add("Sun 3");
        dateArrayList.add("Mon 4");

        dayMarkerAdapter = new DayMarkerRecyclerAdapter(
                        dateArrayList,
                        R.layout.cell_day_marker,
                        new onItemClick() {
                            @Override
                            public void onItemClick(ArrayList data, int position) {
                                Log.i("TAG", "HomePreseneter : onItemClick: " + data.get(position));
                            }
                        }
        );
    }
    @Override
    public BaseRecyclerViewAdapter getAdapter(int flag) {

        switch (flag){
            case DAY_MARKER :
                return dayMarkerAdapter;
            default:
                return dayRecyclerAdapter;
        }
    }
}
