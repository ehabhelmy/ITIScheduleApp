package com.jets.mad.itischeduleapp.utils.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.StringDef;

import com.jets.mad.itischeduleapp.AppController;

/**
 * Created by ehabm on 5/13/2017.
 */

public class NetworkUtils {

    private static ConnectivityManager connectivityManager;

    public static boolean isConnected(){
        connectivityManager = (ConnectivityManager) AppController.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo.isConnectedOrConnecting() && networkInfo != null;
    }

    public static String connectionType(){
        connectivityManager = (ConnectivityManager) AppController.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
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
