package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

import android.support.annotation.IntDef;

@IntDef({ActivityName.LOGIN, ActivityName.HOME})
public @interface ActivityName {
    int LOGIN = 0;
    int HOME = 1;
}
