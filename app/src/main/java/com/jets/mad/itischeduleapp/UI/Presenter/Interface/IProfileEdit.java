package com.jets.mad.itischeduleapp.UI.Presenter.Interface;

import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileEditDataAdapter;
import com.jets.mad.itischeduleapp.datalayer.Exception.UserException;
import com.jets.mad.itischeduleapp.datalayer.Models.User;


public interface IProfileEdit {


    interface IProfileView{
        public void saveError();
        public void saveSuccess();
    }

    interface IProfileFragment{
        public void save();
        public void cancel();

    }

    interface IProfilePresenter{
        public ProfileEditDataAdapter getDataAdapter() throws UserException;
        public void saveUser(ProfileEditDataAdapter profileEditDataAdapter);
        public void saveError();
        public void saveSuccess();
    }


    interface IProfileModel{
        public User getUser() throws UserException;
        public void saveUser(User user);
    }

}
