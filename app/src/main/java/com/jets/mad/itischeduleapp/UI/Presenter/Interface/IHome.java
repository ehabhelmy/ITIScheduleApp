package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.onItemClick;
import com.jets.mad.itischeduleapp.UI.Adapter.OnDayClickListener;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;

import java.util.ArrayList;

import hirondelle.date4j.DateTime;

public interface IHome {

    interface IHomePresenter{

        public ArrayList<Events> prepareDayAdapter(ArrayList<Events> events, DateTime dateTime);
        public void setAdapterData(int flag, DateTime dateTime, BaseRecyclerViewAdapter adapter);

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
    interface IHomeActivityUI {
        public void setAdapterData(int flag, DateTime dateTime, BaseRecyclerViewAdapter adapter);
        public void replaceFragment(HomeFragments homeFragments);
        public void monthToDayCommunicate(DateTime dateTime);
    }


}
