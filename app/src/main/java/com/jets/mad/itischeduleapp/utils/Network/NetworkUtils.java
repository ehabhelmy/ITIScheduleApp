package com.jets.mad.itischeduleapp.utils.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.StringDef;

import com.jets.mad.itischeduleapp.AppController;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkTypes;


public class NetworkUtils {

    private static ConnectivityManager connectivityManager;

    public static boolean isConnected(){
        connectivityManager = (ConnectivityManager) AppController.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo.isConnectedOrConnecting() && networkInfo != null;
    }

    public static NetworkTypes connectionType(){
        connectivityManager = (ConnectivityManager) AppController.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            return NetworkTypes.Wifi;
        }
        else if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
            return NetworkTypes.Three_G;
        }
        else{
            return NetworkTypes.NotConnected;
        }
    }
}
