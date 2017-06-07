package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.MonthAdapter.CalendarAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;

import java.util.ArrayList;

import hirondelle.date4j.DateTime;

/**
 * Created by lenovo on 6/7/2017.
 */

public interface ICalendar {

    public interface ICalendarModel{
        public ArrayList<Session> getDataByMonth(DateTime dateTime);
    }

    public interface ICalendarPresenter{
        public void prepareUI(CalendarAdapter calendarAdapter);
    }

    public interface ICalendarView{}
}
