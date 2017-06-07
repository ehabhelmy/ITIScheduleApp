package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Adapter.MonthAdapter.CalendarAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ICalendar;
import com.jets.mad.itischeduleapp.datalayer.Managers.CalendarManager;

import hirondelle.date4j.DateTime;

/**
 * Created by lenovo on 6/7/2017.
 */

public class CalendarPresenter implements ICalendar.ICalendarPresenter {

    private ICalendar.ICalendarView view;
    private ICalendar.ICalendarModel model;

    public CalendarPresenter(ICalendar.ICalendarView view){
        this.view = view;
        model = new CalendarManager(this);

    }

    /*================================== ICalendarPresenter Interface =================================*/
    @Override
    public void prepareUI(CalendarAdapter calendarAdapter) {
        DateTime dateTime = calendarAdapter.getDateTime();
        calendarAdapter.setData(model.getDataByMonth(dateTime));
    }
}
