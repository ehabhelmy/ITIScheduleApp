package com.jets.mad.itischeduleapp.datalayer.Network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.jets.mad.itischeduleapp.AppController;

public class VolleyRequestSingleton {

    private static VolleyRequestSingleton volleyRequestInstance;
    private RequestQueue requestQueue;

    private VolleyRequestSingleton(){
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyRequestSingleton getInstance() {
        if (volleyRequestInstance == null) {
            volleyRequestInstance = new VolleyRequestSingleton();
        }
        return volleyRequestInstance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null){

                /*applicationContext : to ensure that the RequestQueue will last for the lifetime of the app
                                         instead of being recreated every time the activity is recreated*/
            requestQueue = Volley.newRequestQueue(AppController.getInstance());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void cancelRequestFromQueue(String tag){
        if(requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
