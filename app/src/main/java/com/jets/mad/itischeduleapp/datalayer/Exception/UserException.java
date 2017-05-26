package com.jets.mad.itischeduleapp.datalayer.Exception;

import android.support.annotation.StringDef;

import static com.jets.mad.itischeduleapp.datalayer.Exception.UserException.ExceptionType.Connection;
import static com.jets.mad.itischeduleapp.datalayer.Exception.UserException.ExceptionType.Login;

/**
 * Created by ehabm on 5/13/2017.
 */

public class UserException extends Exception {

    @ExceptionType String ExcepType;

    public UserException(String msg, @ExceptionType String ExcepType){
        super(msg);
        this.ExcepType = ExcepType;
    }

    @StringDef({Connection, Login})
    public @interface ExceptionType {
        String Connection ="Connection Error";
        String Login = "Login Error";

    }
}
