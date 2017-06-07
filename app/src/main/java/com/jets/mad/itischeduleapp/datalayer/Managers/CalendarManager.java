package com.jets.mad.itischeduleapp.datalayer.Managers;

import android.graphics.Color;

import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ICalendar;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventTable;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.SessionTable;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;
import com.jets.mad.itischeduleapp.utils.DateTimeConverter;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

import hirondelle.date4j.DateTime;

/**
 * Created by lenovo on 6/7/2017.
 */

public class CalendarManager implements ICalendar.ICalendarModel{

    private ICalendar.ICalendarPresenter presenter;

    public CalendarManager(ICalendar.ICalendarPresenter presenter){
        this.presenter = presenter;
    }


    /*============================== ICalendarModel Interface ======================================*/
    @Override
    public ArrayList<Session> getDataByMonth(DateTime dateTime) {

        SessionTable sessionTable = new SessionTable(); //TODO: get session table from manager

        Session session = new Session(1, 1, 1, "Android", "session", 5, 4, "sdfg", System.currentTimeMillis(), System.currentTimeMillis()+1000, Color.BLUE);
        ArrayList <Session> sessions = new ArrayList<>();
        sessions.add(session);
        return sessions;
        //return (ArrayList<Session>) sessionTable
//                                        .getBySelection(SessionTable.START_DATE + "Between ? And ?"
//                                                , new String[]{String.valueOf(DateTimeConverter.dateTimeToMilliseconds(dateTime, 1))
//                                                        ,String.valueOf(DateTimeConverter.dateTimeToMilliseconds(dateTime, 31)) });
    }






}
