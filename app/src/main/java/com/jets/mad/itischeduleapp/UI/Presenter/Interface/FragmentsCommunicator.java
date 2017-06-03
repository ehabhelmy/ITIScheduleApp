package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import hirondelle.date4j.DateTime;

/**
 * Created by lenovo on 5/29/2017.
 */

public interface FragmentsCommunicator {

    /***
     * interface used to communicate with day fragment
     ***/
    interface MonthToDayCommunicator{
        public void setDateTime(DateTime dateTime);
    }

}
