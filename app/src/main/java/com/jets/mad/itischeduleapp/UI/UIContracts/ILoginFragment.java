package com.jets.mad.itischeduleapp.UI.UIContracts;

/**
 * Created by lenovo on 5/16/2017.
 */

public interface ILoginFragment {



    /***
     * interface used to communicate with login fragment
     ***/
    interface  ILoginUIFragment{
        public String getUsername();
        public String getPassword();
        public void showError(String error);
    }

}
