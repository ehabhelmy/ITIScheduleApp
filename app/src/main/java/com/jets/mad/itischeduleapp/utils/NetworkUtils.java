package com.jets.mad.itischeduleapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jets.mad.itischeduleapp.UI.Application.MyApplication;

/**
 * Created by ehabm on 5/13/2017.
 */

public class NetworkUtils {

    private ConnectivityManager connectivityManager;
    private MyApplication myApplication;
    private static NetworkUtils networkUtils;
    public static synchronized NetworkUtils getInstance(){
        if (networkUtils == null){
            networkUtils = new NetworkUtils();
        }
        return networkUtils;
    }

    public NetworkUtils() {
        myApplication = new MyApplication();
    }

    public boolean isConnected(){
        connectivityManager = (ConnectivityManager) myApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo.isConnectedOrConnecting() && networkInfo != null;
    }

    public String connectionType(){
        connectivityManager = (ConnectivityManager) myApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            return "wifi";
        }
        else if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
            return "3G";
        }
        else{
            return "not connected";
        }
    }
}
