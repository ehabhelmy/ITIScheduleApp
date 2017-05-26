package com.jets.mad.itischeduleapp.datalayer.Services.Token;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.datalayer.Caching.Files.InternalFile;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Network.URLS;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethod;

import java.util.HashMap;
import java.util.Map;

public class TokenServiceSupport extends Service{

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {

        Map<String, String> bodyParams = new HashMap<>();   //TODO: know what's required to be sent to backend
        /*bodyParams.put("j_username", username);
        bodyParams.put("j_password", password);
        */
        NetworkHandler.callWebService(URLS.LOGIN_URL, NetworkMethod.POST, bodyParams, new NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                //TODO : get token from response

                //1.save token into file
                InternalFile internalFile = new InternalFile();
                internalFile.saveIntoFile(response);

                //2.stop service
                stopSelf(startId);
            }

            @Override
            public void onError(VolleyError volleyError) {
                stopSelf(startId);
            }
        });
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
