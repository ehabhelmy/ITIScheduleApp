package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.AbstractRecyclerViewAdapter.BaseRecyclerViewAdapter;
import com.jets.mad.itischeduleapp.UI.Fragment.MonthFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.HomePresenter;

public class HomeActivity extends AppCompatActivity implements IHome.IHomeActivity, IHome.IHomeActivityUI{

    //UI Reference
    private IHome.IHomePresenter homePresenter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MonthFragment monthFragment;
    private RelativeLayout relativeLayout;
    private GestureDetector gestureDetector;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private final int SWIPE_MIN_DISTANCE = 120;
        private final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                // handling swipe top gesture
                Toast.makeText(HomeActivity.this,"swiped top",Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        gestureDetector = new GestureDetector(this,new GestureListener());
//        fragmentManager = getSupportFragmentManager();
//        monthFragment = (MonthFragment) fragmentManager.findFragmentById(R.id.month);
//        relativeLayout = (RelativeLayout) findViewById(R.id.draggable);
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                System.out.println("ana edst");
//                Log.i("SW","touched");
//                //return gestureDetector.onTouchEvent(event);
//                return true;
//            }
//        });
        homePresenter = new HomePresenter(this);
    }

    @Override
    public BaseRecyclerViewAdapter getAdapter(int flag) {
        //TODO: get the data of the three fragments from network then distribute the data
        return homePresenter.getAdapter(flag);
    }


}
