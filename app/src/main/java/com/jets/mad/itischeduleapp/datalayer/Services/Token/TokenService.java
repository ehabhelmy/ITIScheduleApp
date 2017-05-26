package com.jets.mad.itischeduleapp.datalayer.Services.Token;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.datalayer.Caching.Files.InternalFile;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Network.URLS;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethods;

import java.util.HashMap;
import java.util.Map;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TokenService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {


        Map<String, String> bodyParams = new HashMap<>();   //TODO: know what's required to be sent to backend
        /*bodyParams.put("j_username", username);
        bodyParams.put("j_password", password);
        */
        NetworkHandler.callWebService(URLS.LOGIN_URL, NetworkMethods.POST, bodyParams, new NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                //TODO : get token from response

                InternalFile internalFile = new InternalFile();
                internalFile.saveIntoFile(response);
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });

        //returning true : let the system know that you have a thread still running
        return true;
    }

    /***
     * Called by the system if the job is cancelled before being finished
     * This generally happens when job conditions are no longer being met
     ***/
    @Override
    public boolean onStopJob(JobParameters params) {

        //return true : if you’d like the system to reschedule the job
        return true;
    }
}
