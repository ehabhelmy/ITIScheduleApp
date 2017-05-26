package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Activity.SplashScreen;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.ActivityNamee;

public interface ISplash {

    /***
     * interface used to communication with splash activity
     ***/
    public interface ISplashActivity {
        public void goToNextActivity(ActivityNamee nextActivityName);
    }


    /***
     * interface used to communication with presenter
     ***/
    interface ISplashPresenter{
        public void authenticateUser(SplashScreen splashScreen);
    }

}
