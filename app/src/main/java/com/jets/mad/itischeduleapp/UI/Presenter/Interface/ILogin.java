package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

/**
 * Created by lenovo on 5/16/2017.
 */


/***
 * inter*/
public interface ILogin {

    /***
     * interface used to communication with activity ()
     ***/
    interface ILoginActivity{
        public void loginSucceded();
        public void loginFailed();
    }

    /***
     * interface used to communicate with login activity (UI functionality only)
     ***/
    interface ILoginUIActivity{
        public void login();
    }

    /***
     * interface used to communication with presenter
     ***/
    interface ILoginPresenter{
        public void login(String username, String password);
    }

}
