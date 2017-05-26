package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

public interface ILogin {

    /***
     * interface used to communication with activity
     ***/
    interface ILoginFragment{
        public void loginSucceded();
        public void loginFailed(String title, String msg);
    }

    /***
     * interface used to communicate with login activity (UI functionality only)
     ***/
    interface ILoginActivity{
        public void goToNextActivity();
    }

    /***
     * interface used to communication with presenter
     ***/
    interface ILoginPresenter{
        public void login(String username, String password);
    }

}
