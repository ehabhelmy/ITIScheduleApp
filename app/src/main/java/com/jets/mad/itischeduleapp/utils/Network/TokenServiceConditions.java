package com.jets.mad.itischeduleapp.utils.Network;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.jets.mad.itischeduleapp.AppController;
import com.jets.mad.itischeduleapp.datalayer.Services.Token.TokenService;


public class TokenServiceConditions {

    private final int JOB_ID = 1;
    public static final int PERIODIC_TIME = 1440000;    //24 hours

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public JobInfo getJobInfo(){
        ComponentName serviceName = new ComponentName(AppController.getInstance(), TokenService.class);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, serviceName)
                .setPeriodic(PERIODIC_TIME)
                .setOverrideDeadline(0) //set deadline which is the maximum scheduling latency.
                .setPersisted(true) //true to indicate that the job will be written to disk and loaded at boot.
                .build();

        return jobInfo;
    }


}
