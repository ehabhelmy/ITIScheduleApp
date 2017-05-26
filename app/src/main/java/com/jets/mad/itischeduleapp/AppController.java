package com.jets.mad.itischeduleapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;


public class AppController extends Application {

    private static AppController appInstance;
    private Handler handler;


    public static AppController getInstance(){
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appInstance = this;
        handler = new Handler(Looper.getMainLooper());
    }


    public void runOnUI(Runnable runnable){
        handler.post(runnable);
    }


}
