package com.jets.mad.itischeduleapp.utils.Network;

/**
 * Created by lenovo on 5/16/2017.
 */

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import com.android.volley.Request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({NetworkType.Three_G, NetworkType.Wifi})
public @interface NetworkType {
    String Three_G ="3G";
    String Wifi = "wifi";

}
