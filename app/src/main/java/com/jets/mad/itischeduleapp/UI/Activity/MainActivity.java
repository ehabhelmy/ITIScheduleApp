package com.jets.mad.itischeduleapp.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> params = new HashMap<>();
        params.put("name", "Toky");


//        NetworkHandler.callWebService("http://httpbin.org/get",Request.Method.GET,  params, new NetworkCallback() {
//            @Override
//            public void onSuccess(String response) {
//                Log.i("Tag", response);
//            }
//
//            @Override
//            public void onError(VolleyError volleyError) {
//                Log.i("Tag", "get " + volleyError.toString());
//            }
//        });
        NetworkHandler.callWebService("http://putsreq.com/J54KcEXYY1eeoK9jcs8K",Request.Method.POST,  params, new NetworkCallback() {
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



