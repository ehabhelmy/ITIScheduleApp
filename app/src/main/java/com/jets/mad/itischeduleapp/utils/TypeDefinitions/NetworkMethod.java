package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

import android.support.annotation.IntDef;

import com.android.volley.Request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@IntDef({NetworkMethod.POST, NetworkMethod.GET})
@Retention(RetentionPolicy.SOURCE)
public@interface NetworkMethod{
    int POST = Request.Method.POST;
    int GET = Request.Method.GET;
}