package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import android.graphics.Color;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayMarker.DayMarkerRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;
import java.util.HashMap;

import hirondelle.date4j.DateTime;


public class HomePresenter implements IHome.IHomePresenter {

    public static final int DAY_MARKER = 0;
    public static final int DAY_Data = 1;

    HashMap<DateTime, ArrayList<Events>> calenderEvents;

    private IHome.IHomeActivity homeActivity;

    private BaseRecyclerViewAdapter dayRecyclerAdapter;
    private BaseRecyclerViewAdapter dayMarkerAdapter;


    public HomePresenter(IHome.IHomeActivity homeActivity){
        this.homeActivity = homeActivity;
//        prepareDayAdapter(new ArrayList<Events>(), null);
//        prepareDayMarker(new ArrayList<String>(), null);
    }

    /*================================  IHome.IHomePresenter Interface ===================================*/

    /***
     * This function is called by the network when it gets data fom backend
     ***/
    @Override
    public ArrayList<Events> prepareDayAdapter(ArrayList<Events> events, DateTime dateTime) {

        //testing data
        events.add(new Events(1, "9 A.M.", "10 A.M.", "Application life cycle", "Study IOS", Color.parseColor("#f1534a")));
        events.add(new Events(2, "11 A.M.", "12 A.M.", "Fragment Life Cycle", "Study Android", Color.parseColor("#a9534a")));
        events.add(new Events(3, "1 A.M.", "2 A.M.", "Singleton", "Study Design Pattern", Color.parseColor("#4bce12")));
        events.add(new Events(4, "9 A.M.", "10 A.M.", "Application life cycle", "Study IOS", Color.parseColor("#f1534a")));
        events.add(new Events(5, "11 A.M.", "12 A.M.", "Fragment Life Cycle", "Study Android", Color.parseColor("#a9534a")));
        events.add(new Events(6, "1 A.M.", "2 A.M.", "Singleton", "Study Design Pattern", Color.parseColor("#4bce12")));

        return events;

    }

    public ArrayList<String> prepareDayMarker(ArrayList<String> dateArrayList, DateTime dateTime){
        dateArrayList.add("Tues 29");
        dateArrayList.add("Wed 30");
        dateArrayList.add("Thur 31");
        dateArrayList.add("Fri 1");
        dateArrayList.add("Sat 2");
        dateArrayList.add("Sun 3");
        dateArrayList.add("Mon 4");

        return dateArrayList;
    }


    @Override
    public void setAdapterData(int flag, DateTime dateTime, BaseRecyclerViewAdapter adapter) {
        switch (flag){
            case DAY_MARKER :
                adapter.setData(prepareDayMarker(new ArrayList<String>(), dateTime));
                break;
            default:
                adapter.setData(prepareDayAdapter(new ArrayList<Events>(), dateTime));
        }
    }
}
