package com.jets.mad.itischeduleapp.utils;

import java.util.TimeZone;

import hirondelle.date4j.DateTime;

/**
 * Created by lenovo on 6/7/2017.
 */

public class DateTimeConverter {

    public static long dateTimeToMilliseconds(DateTime dateTime, int day){
        DateTime dateTime1 = DateTime.forDateOnly(dateTime.getYear(), dateTime.getMonth(), day);
        return dateTime1.getMilliseconds(TimeZone.getDefault());

        }

    public static int millisecondsToDay(long time){
        DateTime dateTime = DateTime.forInstant(time, TimeZone.getDefault());
        return dateTime.getMonth();
    }

    public static int millisecondsToMonth(long time){
        DateTime dateTime = DateTime.forInstant(time, TimeZone.getDefault());
        return dateTime.getYear();
    }
}
