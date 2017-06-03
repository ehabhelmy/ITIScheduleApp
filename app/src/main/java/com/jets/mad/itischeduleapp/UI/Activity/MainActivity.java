package com.jets.mad.itischeduleapp.UI.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.SwipeDetector.OnFlingGestureListener;
import com.jets.mad.itischeduleapp.UI.Fragment.DayFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.WeekFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.HomePresenter;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;
import com.jets.mad.itischeduleapp.utils.UI.FragmentsFactory;

import hirondelle.date4j.DateTime;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IHome.IHomeActivity, IHome.IHomeActivityUI {


    //UI Reference
    private IHome.IHomePresenter homePresenter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MonthFragment monthFragment;
    private WeekFragment weekFragment;
    private DayFragment dayFragment;
    private ProfileFragment profileFragment;
    private LinearLayout linearLayout;
    private ImageView view;
    private FragmentsFactory fragmentsFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();

        monthFragment = new MonthFragment();

        linearLayout = (LinearLayout) findViewById(R.id.lout);

        fragmentsFactory = new FragmentsFactory(fragmentManager);
        fragmentsFactory.getFragment(HomeFragments.MONTH);

        prepareSpinner();
        prepareSlidingView();
        homePresenter = new HomePresenter(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //remove app name from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_schedule) {

            fragmentsFactory.getFragment(HomeFragments.MONTH);

        } else if (id == R.id.nav_profile) {
            fragmentsFactory.getFragment(HomeFragments.PROFILE);

        } else if (id == R.id.nav_events) {
            fragmentsFactory.getFragment(HomeFragments.EVENT);

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*====================================== HELPFUL METHODS =============================================*/
    private void prepareSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.calendar_options);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fragmentsFactory.getFragment(HomeFragments.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /****/
    private void prepareSlidingView(){
        view = (ImageView) findViewById(R.id.draggable);
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
                fragmentsFactory.getFragment(HomeFragments.WEEK);
                view.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_keyboard_arrow_down_black_24dp));;


            }

            @Override
            public void onTopToBottom() {
                fragmentsFactory.getFragment(HomeFragments.MONTH);
                view.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_keyboard_arrow_up_black_24dp));;
            }
        });
    }

    /*======================================  IHomeActivityUI Interface======================================*/

    @Override
    public void setAdapterData(int flag, DateTime dateTime, BaseRecyclerViewAdapter adapter) {
        Log.i("TAG", "MainActivity: setAdapterData: dateTime= " + dateTime);
        homePresenter.setAdapterData(flag, dateTime, adapter);
    }

    @Override
    public void replaceFragment(HomeFragments homeFragments) {
        fragmentsFactory.getFragment(homeFragments);
    }


    @Override
    public void monthToDayCommunicate(DateTime dateTime) {
        fragmentsFactory.getFragment(HomeFragments.DAY);
        dayFragment = fragmentsFactory.getDayFragment();
        dayFragment.setDateTime(dateTime);
    }
}
