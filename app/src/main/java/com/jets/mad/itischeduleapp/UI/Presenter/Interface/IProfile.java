package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileDataAdapter;
import com.jets.mad.itischeduleapp.datalayer.Models.User;

/**
 * Created by lenovo on 6/1/2017.
 */

public interface IProfile {

    interface IProfileModel{
        public void getUser();
    }

    interface IProfilePresenter{
        public void setUser(User user);
        public void userFailed();

    }

    /***
     * interface which will be used by the view to communicate with the pre  */
    interface IProfilePresenterUI{
        public void setProfileData();
    }


    interface IProfileView{
        public void fillProfileData(ProfileDataAdapter profileDataAdapter);
        public void showError();
    }

    interface IProfileToDataCommunicator {
        public void setProfile(IDataToProfileCommunicator dataToProfileCommunicator);
    }

    interface IDataToProfileCommunicator{
        public void setName(String username);
    }
}
