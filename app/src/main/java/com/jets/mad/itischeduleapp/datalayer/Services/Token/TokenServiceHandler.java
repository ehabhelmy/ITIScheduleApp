package com.jets.mad.itischeduleapp.datalayer.Services.Token;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.jets.mad.itischeduleapp.AppController;
import com.jets.mad.itischeduleapp.utils.Network.TokenServiceConditions;

public class TokenServiceHandler {

    //TODO : remove schedulers when logout

    public void scheduleTokenService(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            JobScheduler jobScheduler = (JobScheduler) AppController.getInstance().getSystemService(Context.JOB_SCHEDULER_SERVICE);
            TokenServiceConditions conditions = new TokenServiceConditions();
            jobScheduler.schedule(conditions.getJobInfo());
        }else{
            scheduleTokenServiceSupport(AppController.getInstance());
        }

    }

    /*================================== HELPFUL METHODS ===============================*/

    /***
     * Method used for scheduling jobs using Alarm Manager
     * used to support SDKs versions before Lollipop
     ***/

    private void scheduleTokenServiceSupport(Context context){

        final int requestCode = 1;

        Intent alarmIntent = new Intent(context, TokenServiceSupport.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                AppController.getInstance(), requestCode, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, TokenServiceConditions.PERIODIC_TIME, pendingIntent);
    }
}
