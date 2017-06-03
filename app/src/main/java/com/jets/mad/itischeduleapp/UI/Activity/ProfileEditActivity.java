package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileEditFragment;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfileEdit;

public class ProfileEditActivity extends AppCompatActivity {


    IProfileEdit.IProfileFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        fragment = (ProfileEditFragment) getSupportFragmentManager().findFragmentById(R.id.profile_fragment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(getApplication()).inflate(R.menu.profile_save_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                fragment.save();
                break;
            case R.id.home:
                finish();
                break;

            default:
                break;
        }

        return true;
    }

}

