package com.jets.mad.itischeduleapp.UI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Adapter.SwipeDetector.OnFlingGestureListener;
import com.jets.mad.itischeduleapp.UI.Fragment.DayFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.WeekFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IEvent;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.EventPresenter;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.HomePresenter;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventsTable;
import com.jets.mad.itischeduleapp.datalayer.Models.Events;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;
import com.jets.mad.itischeduleapp.utils.UI.FragmentsFactory;

import hirondelle.date4j.DateTime;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IHome.IHomeActivity, IHome.IHomeActivityUI,IEvent.IEventActivity {


    //UI Reference
    Spinner spinner;
    private LinearLayout linearLayout;
    private ImageView view;
    private ImageButton notificationBtn;
    private FloatingActionButton fab;
    private TextView notificationNum;

    private IHome.IHomePresenter homePresenter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MonthFragment monthFragment;
    private WeekFragment weekFragment;
    private DayFragment dayFragment;
    private ProfileFragment profileFragment;
    private FragmentsFactory fragmentsFactory;
    private EventPresenter eventPresenter;
    private EventsTable eventsTable;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //////////////////////////// insert dummy data into data base ///////////////////////
        eventsTable = new EventsTable();
        eventsTable.insert(new Events("5/5/2017","15/5/2017", "dddddd", "MDW",2,"EVENT",1,Events.REGISTERED));
        eventsTable.insert(new Events("5/4/2017","15/4/2017", "dddddd","GAME JAM",2,"EVENT",2,Events.REGISTERED));
        eventsTable.insert(new Events("5/3/2017","15/3/2017", "dddddd","NASA",2,"EVENT",3,Events.NOTREGISTERED));
        eventsTable.insert(new Events("5/2/2017","15/2/2017", "dddddd","PATROL",2,"EVENT",4,Events.NOTREGISTERED));
        eventsTable.insert(new Events("5/1/2017","15/1/2017", "dddddd","FUN DAY",2,"EVENT",5,Events.REGISTERED));
        /////////////////////////////////////////////////////////////////////////////////////

        homePresenter = new HomePresenter(this);
        eventPresenter = new EventPresenter(this);

        fragmentManager = getSupportFragmentManager();

        monthFragment = new MonthFragment();

        linearLayout = (LinearLayout) findViewById(R.id.lout);

        fragmentsFactory = new FragmentsFactory(fragmentManager);
        fragmentsFactory.getFragment(HomeFragments.MONTH);

        prepareSpinner();
        prepareSlidingView();

        /////NOTIFICATION
        notificationNum = (TextView) findViewById(R.id.notification_number);
        notificationBtn = (ImageButton) findViewById(R.id.notification_btn);
        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: go to notifications view
            }
        });

        /////TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //remove app name from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /////FLOATING Button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        /////NAV DRAWER
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_schedule) {

            replaceFragment(HomeFragments.MONTH);

        } else if (id == R.id.nav_profile) {
            replaceFragment(HomeFragments.PROFILE);

        } else if (id == R.id.nav_events) {
            replaceFragment(HomeFragments.EVENT);

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*====================================== HELPFUL METHODS =============================================*/
    private void prepareSpinner(){
        spinner = (Spinner) findViewById(R.id.calendar_options);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                replaceFragment(HomeFragments.values()[position]);
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
                replaceFragment(HomeFragments.WEEK);
                view.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_keyboard_arrow_down_black_24dp));;


            }

            @Override
            public void onTopToBottom() {
                replaceFragment(HomeFragments.MONTH);
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

        Log.i("TAG", "MainActivity replaceFragment:");
        //setting visibility of spinner
        switch (homeFragments){
            case MONTH:
            case WEEK:
            case DAY:
                Log.i("TAG", "MainActivity replaceFragment: spinner visibility : visible");
                spinner.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                break;
            default:
                Log.i("TAG", "MainActivity replaceFragment: spinner visibility : invisible");
                spinner.setVisibility(View.INVISIBLE);
                fab.setVisibility(View.INVISIBLE);
        }

        fragmentsFactory.getFragment(homeFragments);
    }


    @Override
    public void monthToDayCommunicate(DateTime dateTime) {
        replaceFragment(HomeFragments.DAY);
        dayFragment = fragmentsFactory.getDayFragment();
        dayFragment.setDateTime(dateTime);
    }

    @Override
    public IEvent.IEventPresenter getEventPresenter() {
        return eventPresenter;
    }

    @Override
    public void setEventAdapterData(int flag, BaseRecyclerViewAdapter adapter) {
        eventPresenter.setAdapterData(flag,adapter);
    }

}
