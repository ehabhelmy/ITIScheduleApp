package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.SwipeDetector.OnFlingGestureListener;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.WeekFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.HomePresenter;

public class HomeActivity extends AppCompatActivity implements IHome.IHomeActivity, IHome.IHomeActivityUI{

    //UI Reference
    private IHome.IHomePresenter homePresenter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MonthFragment monthFragment;
    private WeekFragment weekFragment;
    private LinearLayout linearLayout;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        monthFragment = new MonthFragment();
        linearLayout = (LinearLayout) findViewById(R.id.lout);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.lout,monthFragment,"MONTH");
        fragmentTransaction.addToBackStack("MONTH");
        fragmentTransaction.commit();
        view = (View) findViewById(R.id.draggable);
        view.setOnTouchListener(new OnFlingGestureListener() {
            @Override
            public void onRightToLeft() {

            }

            @Override
            public void onLeftToRight() {

            }

            @Override
            public void onBottomToTop() {
                System.out.println("swiped");
                fragmentTransaction = fragmentManager.beginTransaction();
                weekFragment = (WeekFragment) fragmentManager.findFragmentByTag("WEEK");
                if (weekFragment == null){
                    weekFragment = new WeekFragment();
                }
                fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.popenter,R.anim.popexit);
                fragmentTransaction.replace(R.id.lout,weekFragment,"WEEK");
//                view.setVisibility(View.GONE);
//                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        8.0f
//                );
//                linearLayout.setLayoutParams(param);
                fragmentTransaction.commit();
            }

            @Override
            public void onTopToBottom() {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.popenter,R.anim.popexit);
                monthFragment = (MonthFragment) fragmentManager.findFragmentByTag("MONTH");
                fragmentTransaction.replace(R.id.lout,monthFragment);
                fragmentTransaction.commit();
            }
        });
        homePresenter = new HomePresenter(this);
    }

    @Override
    public BaseRecyclerViewAdapter getAdapter() {
        //TODO: get the data of the three fragments from network then distribute the data
        return homePresenter.getAdapter();
    }


}
