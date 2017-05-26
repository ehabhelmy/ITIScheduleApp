package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Activity.SplashScreen;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ISplash;
import com.jets.mad.itischeduleapp.datalayer.Caching.Files.InternalFile;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.ActivityName;

public class SplashScreenPresenter implements ISplash.ISplashPresenter {

    ISplash.ISplashActivity splashActivity;

    public SplashScreenPresenter(ISplash.ISplashActivity iSplashActivity) {
        splashActivity = iSplashActivity;
    }
    /*=============================== ISplash.ISplashPresenter Interface Methods =====================================*/
    @Override
    public void authenticateUser(SplashScreen splashScreen) {

        /***
         * check if there is token saved for user
         ***/

        InternalFile internalFile = new InternalFile();
        if(internalFile.readFromFile() == null){
            splashActivity.goToNextActivity(ActivityName.LOGIN);
        }else{
            splashActivity.goToNextActivity(ActivityName.HOME);
        }
    }


}
