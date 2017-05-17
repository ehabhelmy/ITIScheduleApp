package com.jets.mad.itischeduleapp.UI.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.UIContracts.ILoginFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.LoginFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILogin.ILoginActivity, ILogin.ILoginUIActivity {

    private ILoginFragment.ILoginUIFragment iLoginUIFragment;
    private ILogin.ILoginPresenter iLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //link activity with presenter
        iLoginPresenter = new LoginPresenter(this);

        iLoginUIFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_fragment);

    }


    /*========================= ILoginUIActivity Contract =========================*/
    @Override
    public void login() {
        String username = iLoginUIFragment.getUsername();
        String password = iLoginUIFragment.getPassword();

        Log.i("TAG", "login: "+username +" "+password);

        //pass these params to presenter
        iLoginPresenter.login(username, password);

    }
    /*========================= ILoginActivity Contract =========================*/
    @Override
    public void loginSucceded() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public void loginFailed() {

    }
}
