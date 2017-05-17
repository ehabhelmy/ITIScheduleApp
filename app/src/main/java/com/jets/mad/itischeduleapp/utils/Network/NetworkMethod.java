package com.jets.mad.itischeduleapp.utils.Network;

import android.support.annotation.IntDef;

import com.android.volley.Request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lenovo on 5/17/2017.
 */

@IntDef({NetworkMethod.POST, NetworkMethod.GET})
@Retention(RetentionPolicy.SOURCE)
public@interface NetworkMethod{
    int POST = Request.Method.POST;
    int GET = Request.Method.GET;
}