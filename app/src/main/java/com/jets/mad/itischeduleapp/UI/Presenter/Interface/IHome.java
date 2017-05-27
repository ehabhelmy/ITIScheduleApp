package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.DayList.DayRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;

public interface IHome {

    interface IHomePresenter{

        public void prepareDayAdapter(ArrayList<Events> events);
        public DayRecyclerViewAdapter getDayAdapter();

    }


    /***
     * this interface contains functions that will be called by presenter
     * these functions contains business functionalities only
     ***/
    interface IHomeActivity{

    }

    /***
     * this interface contains functions that will be called by DayFragment
     * its functions are UI related
     ***/
    interface IHomeActivityUI{
        public DayRecyclerViewAdapter getDayAdapter();
    }

}
