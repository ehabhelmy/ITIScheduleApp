package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;

import java.util.ArrayList;

public interface IHome {

    interface IHomePresenter{

        public void prepareDayAdapter(ArrayList<Events> events);
        public BaseRecyclerViewAdapter getAdapter();

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
        public BaseRecyclerViewAdapter getAdapter();
    }

}
