package com.jets.mad.itischeduleapp.datalayer.Network;

import com.android.volley.VolleyError;


public interface NetworkCallback {

    public void onSuccess(String response);
    public void onError(VolleyError volleyError);
}
