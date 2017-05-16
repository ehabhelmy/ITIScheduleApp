package com.jets.mad.itischeduleapp.datalayer.Network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by lenovo on 5/15/2017.
 */

public class NetworkHandler {

    public static void callWebService(String url, int method, final Map<String, String> params, final NetworkCallback networkCallback) {
        switch (method) {

            case Request.Method.POST:
                callWebServiceUsingPOST(url, params, networkCallback);
                break;

            default:
                callWebServiceUsingGET(url, params, networkCallback);
                break;
        }
    }

    /*========================================== HELPFUL METHODS ===============================================*/

    /***
     * Method for GET requests
     ***/
    private static void callWebServiceUsingGET(String url, final Map<String, String> params, final NetworkCallback networkCallback) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url+"?");
        for(String key : params.keySet()){
            stringBuilder.append(key+"="+params.get(key)+"&");
        }

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, stringBuilder.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        networkCallback.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkCallback.onError(error);
            }

        });

        // Add the request to the RequestQueue.
        VolleyRequestSingleton.getInstance().addToRequestQueue(stringRequest);
    }

    /***
     * Method for POST requests
     ***/
    private static void callWebServiceUsingPOST(String url, final Map<String, String> params, final NetworkCallback networkCallback) {

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        networkCallback.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkCallback.onError(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        // Add the request to the RequestQueue.
        VolleyRequestSingleton.getInstance().addToRequestQueue(stringRequest);
    }



}
