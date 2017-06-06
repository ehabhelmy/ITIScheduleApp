package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jets.mad.itischeduleapp.UI.Activity.MainActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.CalendarAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.OnDayClickListener;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import hirondelle.date4j.DateTime;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends CaldroidFragment {

    private IHome.IHomeActivityUI homeActivity;

    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {

        getLeftArrowButton().setVisibility(View.GONE);
        getRightArrowButton().setVisibility(View.GONE);

        return new CalendarAdapter(getActivity(), month, year,
                getCaldroidData(), extraData, new OnDayClickListener() {
            @Override
            public void onDayClick(DateTime dateTime) {
                homeActivity.monthToDayCommunicate(dateTime);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (MainActivity) context;
    }


}
