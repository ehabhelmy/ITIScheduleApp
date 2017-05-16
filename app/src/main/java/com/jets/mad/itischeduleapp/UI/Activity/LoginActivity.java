package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Contracts.LoginActivityContract;
import com.jets.mad.itischeduleapp.UI.Contracts.LoginFragmentContract;
import com.jets.mad.itischeduleapp.UI.Fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract {

    private Fragment loginFragment;
    private FragmentManager fragmentManager;
    private LoginFragmentContract fragmentContract;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(savedInstanceState == null){
            loginFragment = new LoginFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentContract = (LoginFragmentContract) loginFragment;
            fragmentManager.beginTransaction().add(loginFragment, "loginFragment");

        }else{
            fragmentContract = (LoginFragmentContract) fragmentManager.findFragmentByTag("loginFragment");
        }


    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }



    /*========================= LoginActivityContract Interface =========================*/
    @Override
    public void login() {
        String username = fragmentContract.getUsername();
        String password = fragmentContract.getPassword();

        //pass these params to presenter

    }
}
