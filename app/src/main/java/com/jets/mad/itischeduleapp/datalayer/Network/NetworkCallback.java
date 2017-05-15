package com.jets.mad.itischeduleapp.datalayer.Network;

import com.android.volley.VolleyError;

/**
 * Created by ahmed-basyouni on 5/15/17.
 */

public interface NetworkCallback {

    public void onSuccess(String response);
    public void onError(VolleyError volleyError);
}
