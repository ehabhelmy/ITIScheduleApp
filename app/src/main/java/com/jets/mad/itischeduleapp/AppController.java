package com.jets.mad.itischeduleapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.jets.mad.itischeduleapp.datalayer.Caching.DB.DataBaseManager;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventTable;
import com.jets.mad.itischeduleapp.datalayer.Caching.DB.EventsTable;


public class AppController extends Application {

    private static AppController appInstance;
    private Handler handler;
    private DataBaseManager dataBaseManager;

    public static AppController getInstance(){
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appInstance = this;
        handler = new Handler(Looper.getMainLooper());
        dataBaseManager = DataBaseManager.getInstance();
        dataBaseManager.addTable(new EventTable());

    }


    public void runOnUI(Runnable runnable){
        handler.post(runnable);
    }


}
