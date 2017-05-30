package com.jets.mad.itischeduleapp.UI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Fragment.LoginFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;

public class LoginActivity extends AppCompatActivity implements ILogin.ILoginActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_fragment);

    }

    /*========================= ILoginActivity Contract =========================*/
    @Override
    public void goToNextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        //close login activity
        finish();
    }
}