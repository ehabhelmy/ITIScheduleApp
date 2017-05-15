package com.jets.mad.itischeduleapp.Test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;

import java.util.HashMap;
import java.util.Map;

public class TestActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activtiy);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Map<String, String> params= new HashMap<>();
        params.put("name", "Toky");
        NetworkHandler.callWebServiceUsingPOST("http://putsreq.com/J54KcEXYY1eeoK9jcs8K", params, new NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.i("Tag", response);
            }

            @Override
            public void onError(VolleyError volleyError) {
                Log.i("Tag", "post " + volleyError.toString());
            }
        });

        NetworkHandler.callWebServiceUsingGET("http://httpbin.org/get", new NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.i("Tag", response);
            }

            @Override
            public void onError(VolleyError volleyError) {
                Log.i("Tag", "get " + volleyError.toString());
            }
        });
    }

}
