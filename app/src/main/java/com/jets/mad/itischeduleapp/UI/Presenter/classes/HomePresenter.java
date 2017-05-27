package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import android.graphics.Color;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.DayRecyclerViewAdapter.DayRecyclerAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;


public class HomePresenter implements IHome.IHomePresenter {

    private IHome.IHomeActivity homeActivity;

    private BaseRecyclerViewAdapter baseRecyclerViewAdapter;


    public HomePresenter(IHome.IHomeActivity homeActivity){
        this.homeActivity = homeActivity;
        prepareDayAdapter(new ArrayList<Events>());
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

        baseRecyclerViewAdapter = new DayRecyclerAdapter(events, R.layout.cell_day);

    }

    @Override
    public BaseRecyclerViewAdapter getAdapter() {
        return baseRecyclerViewAdapter;
    }
}
