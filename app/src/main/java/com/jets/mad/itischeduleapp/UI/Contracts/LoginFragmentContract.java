package com.jets.mad.itischeduleapp.UI.Contracts;

/**
 * Created by lenovo on 5/16/2017.
 */

public interface LoginFragmentContract {

    public String getUsername();
    public String getPassword();
    public void showError(String error);
}
