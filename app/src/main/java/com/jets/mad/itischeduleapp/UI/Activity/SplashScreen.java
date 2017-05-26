package com.jets.mad.itischeduleapp.UI.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ISplash;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.SplashScreenPresenter;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.ActivityNamee;

public class SplashScreen extends AppCompatActivity implements ISplash.ISplashActivity {

    private ISplash.ISplashPresenter splashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreenPresenter = new SplashScreenPresenter(this);
        splashScreenPresenter.authenticateUser(this);


    }
    /*============================== ISplash.ISplashActivity Interface Methods =====================================*/
    @Override
    public void goToNextActivity(ActivityNamee nextActivityName) {
        Intent intent;
        switch (nextActivityName) {
            case HOME:
                intent = new Intent(SplashScreen.this, HomeActivity.class);
                Log.i("TAG", "SplashScreen.java goToNextActivity: HomeActivity");
                startActivity(intent);
                break;
            default:
                intent = new Intent(SplashScreen.this, LoginActivity.class);
                Log.i("TAG", "SplashScreen.java goToNextActivity: LoginActivity");
                startActivity(intent);

        }

        //close splashscreen
        finish();

    }

}
