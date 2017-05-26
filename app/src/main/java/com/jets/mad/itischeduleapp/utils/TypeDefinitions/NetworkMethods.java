package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

import com.android.volley.Request;

public enum NetworkMethods {

    GET(Request.Method.GET),
    POST(Request.Method.POST);

    private int value;
    private NetworkMethods(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
