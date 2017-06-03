package com.jets.mad.itischeduleapp.datalayer.Network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.jets.mad.itischeduleapp.datalayer.Models.BaseModel;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethods;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class NetworkHandler {


    public static void callWebService(String url, NetworkMethods method, final Map<String, String> params, final NetworkCallback networkCallback) {
        switch (method
                .getValue()) {
            case Request.Method.POST:
                callWebServiceUsingPOST(url, params, networkCallback);
                break;

            default:
                callWebServiceUsingGET(url, params, networkCallback);
                break;
        }
    }


    public static void callWebServiceUsingPostWithObjectParam(String url, final BaseModel object, final NetworkCallback networkCallback){

        Gson gson = new Gson();
        final String body = gson.toJson(object);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("TAG", "NetworkHandler.java callWebServiceUsingPostWithObjectParam : onResponse: " + response);
                        networkCallback.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "NetworkHandler.java callWebServiceUsingPostWithObjectParam : onErrorResponse: " + error.toString());
                networkCallback.onError(error);
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return body.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        // Add the request to the RequestQueue.
        VolleyRequestSingleton.getInstance().addToRequestQueue(stringRequest);

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
                        Log.i("TAG", "NetworkHandler.java callWebServiceUsingPOST : onResponse: " + response);
                        networkCallback.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "NetworkHandler.java callWebServiceUsingPOST : onErrorResponse: " + error.toString());
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
