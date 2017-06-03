package com.jets.mad.itischeduleapp.utils.UI;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Fragment.DayDetailFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.DayFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.EventFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileEditFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.WeekFragment;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;


public class FragmentsFactory {

    private FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    private MonthFragment monthFragment;
    private WeekFragment weekFragment;
    private DayFragment dayFragment;
    private ProfileFragment profileFragment;
    private ProfileEditFragment profileEditFragment;
    private EventFragment eventFragment;

    public FragmentsFactory(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;

    }

    public void getFragment(HomeFragments homeFragment){

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.open_center, R.anim.open_center_exit);

        //replace fragments according to input
        switch (homeFragment){

            case DAY:
                //prepare transaction
                dayFragment = (DayFragment) fragmentManager.findFragmentByTag("DAY");
                if (dayFragment == null){
                    dayFragment = new DayFragment();
                }
                fragmentTransaction.replace(R.id.lout,dayFragment,"DAY");
                break;
            case WEEK:
                weekFragment = (WeekFragment) fragmentManager.findFragmentByTag("WEEK");
                if (weekFragment == null){
                    weekFragment = new WeekFragment();
                }
                fragmentTransaction.replace(R.id.lout,weekFragment,"WEEK");
                break;
            case MONTH:
                monthFragment = (MonthFragment) fragmentManager.findFragmentByTag("MONTH");
                if (monthFragment == null){
                    monthFragment = new MonthFragment();
                }
                fragmentTransaction.replace(R.id.lout,monthFragment);
                break;
            case PROFILE:
                profileFragment = (ProfileFragment) fragmentManager.findFragmentByTag("PROFILE");
                if (profileFragment == null){
                    profileFragment = new ProfileFragment();
                }
                fragmentTransaction.replace(R.id.lout,profileFragment);
                break;
            case EVENT:
                eventFragment = (EventFragment) fragmentManager.findFragmentByTag("EVENT");
                if (eventFragment == null){
                    eventFragment = new EventFragment();
                }
                fragmentTransaction.replace(R.id.lout,eventFragment,"EVENT");
                fragmentTransaction.addToBackStack("Event");
                break;
            case PROFILE_EDIT:
                profileEditFragment = (ProfileEditFragment) fragmentManager.findFragmentByTag("PROFILE_EDIT");
                if (profileEditFragment == null){
                    profileEditFragment = new ProfileEditFragment();
                }
                fragmentTransaction.replace(R.id.lout,profileEditFragment);
                break;
            default:
                fragmentTransaction.replace(R.id.lout, new DayDetailFragment());
        }

        //commit transaction
        fragmentTransaction.commit();
    }

    public MonthFragment getMonthFragment() {
        return monthFragment;
    }

    public WeekFragment getWeekFragment() {
        return weekFragment;
    }

    public DayFragment getDayFragment() {
        return dayFragment;
    }
}
