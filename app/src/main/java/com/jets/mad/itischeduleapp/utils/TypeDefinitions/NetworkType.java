package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

import android.support.annotation.StringDef;

@StringDef({NetworkType.Three_G, NetworkType.Wifi})
public @interface NetworkType {
    String Three_G ="3G";
    String Wifi = "wifi";

}
