package com.jets.mad.itischeduleapp.UI.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jets.mad.itischeduleapp.UI.Fragment.DayFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.WeekFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ehabm on 5/26/2017.
 */

/*********************** Implementing 3 scrolling screens vertically ******************/

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private Bundle saved;
    private MonthFragment monthFragment;
    private Context context;

    public ScreenSlidePagerAdapter(FragmentManager fm, Bundle save,Context context) {
        super(fm);
        this.saved = save;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0 ){
            if (saved==null){
                monthFragment = new MonthFragment();
                Bundle args = new Bundle();
                Calendar cal = Calendar.getInstance();
                args.putInt(monthFragment.MONTH, cal.get(Calendar.MONTH) + 1);
                args.putInt(monthFragment.YEAR, cal.get(Calendar.YEAR));
                args.putBoolean(monthFragment.ENABLE_SWIPE, true);
                args.putBoolean(monthFragment.SIX_WEEKS_IN_CALENDAR, false);
                monthFragment.setArguments(args);
                monthFragment.setCaldroidListener(new CaldroidListener() {
                    @Override
                    public void onSelectDate(Date date, View view) {
                        Toast.makeText(context,date.toLocaleString(),Toast.LENGTH_SHORT).show();
                    }
                });
                return monthFragment;
            }
            else{
                monthFragment.restoreStatesFromKey(saved,
                        "CALDROID_SAVED_STATE");
                return monthFragment;
            }

        }else if (position == 1){
            return new WeekFragment();
        }else{
            return new DayFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }







}
