package com.jets.mad.itischeduleapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ehabm on 5/13/2017.
 */

public class ValidationUtils {
    private static ValidationUtils validationUtils;

    public ValidationUtils() {
    }
    public static synchronized ValidationUtils getInstance(){
        if (validationUtils == null){
            validationUtils = new ValidationUtils();
        }
        return validationUtils;
    }

    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
