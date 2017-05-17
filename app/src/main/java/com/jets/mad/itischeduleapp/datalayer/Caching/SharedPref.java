package com.jets.mad.itischeduleapp.datalayer.Caching;

import android.content.Context;
import android.content.SharedPreferences;

import com.jets.mad.itischeduleapp.AppController;
import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;

import java.util.Map;

/**
 * Created by lenovo on 5/17/2017.
 */

public class SharedPref {

    private static final String PREF_NAME = "com.jets.mad.itischecheduleapp.PREF_File";
    private static final Context context = AppController.getInstance();
    private static SharedPreferences prefs = context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);

    public static void saveString(String key, String value){

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public static String retreiveString(String key){
        return prefs.getString(key, "no val");
    }

}
