package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.DayList.DayRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.ScreenSlidePagerAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.VerticalViewPager;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.HomePresenter;

public class HomeActivity extends AppCompatActivity implements IHome.IHomeActivity, IHome.IHomeActivityUI{

    //UI Reference
    private VerticalViewPager viewPager;

    private ScreenSlidePagerAdapter screenSlidePagerAdapter;


    IHome.IHomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = (VerticalViewPager) findViewById(R.id.pager);
        screenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(),savedInstanceState);
        viewPager.setAdapter(screenSlidePagerAdapter);

        homePresenter = new HomePresenter(this);

    }


    @Override
    public DayRecyclerViewAdapter getDayAdapter() {
        //TODO: get the data of the three fragments from network then distribute the data
        return homePresenter.getDayAdapter();
    }


}
