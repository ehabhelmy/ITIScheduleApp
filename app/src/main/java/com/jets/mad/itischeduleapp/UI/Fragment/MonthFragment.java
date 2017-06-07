package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jets.mad.itischeduleapp.UI.Activity.MainActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.MonthAdapter.CalendarAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.OnDayClickListener;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ICalendar;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.CalendarPresenter;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import hirondelle.date4j.DateTime;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends CaldroidFragment implements ICalendar.ICalendarView {

    private IHome.IHomeActivityUI homeActivity;
    private ICalendar.ICalendarPresenter presenter;
    private CalendarAdapter calendarAdapter;


    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {

        ////remove month arrows
        getLeftArrowButton().setVisibility(View.GONE);
        getRightArrowButton().setVisibility(View.GONE);

        presenter = new CalendarPresenter(this);
        calendarAdapter = new CalendarAdapter(getActivity(), month, year,
                getCaldroidData(), extraData, new OnDayClickListener() {
            @Override
            public void onDayClick(DateTime dateTime) {
                homeActivity.monthToDayCommunicate(dateTime);
            }
        });

        presenter.prepareUI(calendarAdapter);

        return calendarAdapter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (MainActivity) context;
    }

    /*================================== ICalendarView Interface ================================*/


}
