package com.jets.mad.itischeduleapp.utils.Predicate;

import com.google.common.base.Predicate;
import com.jets.mad.itischeduleapp.datalayer.Models.Session;
import com.jets.mad.itischeduleapp.utils.DateTimeConverter;

import hirondelle.date4j.DateTime;

public class DayPredicate implements Predicate<Session> {

    private DateTime dateTime;

    public DayPredicate(DateTime dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public boolean apply(Session input) {
        return DateTimeConverter.millisecondsToDay(input.getStartDate()) == dateTime.getDay()
                &&  DateTimeConverter.millisecondsToMonth(input.getStartDate()) == dateTime.getMonth();
    }
}
