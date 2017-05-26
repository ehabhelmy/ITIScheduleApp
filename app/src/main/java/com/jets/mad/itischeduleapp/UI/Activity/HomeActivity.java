package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.ScreenSlidePagerAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.VerticalViewPager;

public class HomeActivity extends AppCompatActivity {

    VerticalViewPager viewPager;

    ScreenSlidePagerAdapter screenSlidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = (VerticalViewPager) findViewById(R.id.pager);
        screenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(),savedInstanceState);
        viewPager.setAdapter(screenSlidePagerAdapter);
    }
}
