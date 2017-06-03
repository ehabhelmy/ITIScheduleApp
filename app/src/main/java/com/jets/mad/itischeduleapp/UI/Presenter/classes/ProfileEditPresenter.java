package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileEditDataAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfileEdit;
import com.jets.mad.itischeduleapp.datalayer.Exception.UserException;
import com.jets.mad.itischeduleapp.datalayer.Managers.ProfileEditManager;


public class ProfileEditPresenter implements IProfileEdit.IProfilePresenter{

    private IProfileEdit.IProfileModel manager;
    private IProfileEdit.IProfileView view;

    public ProfileEditPresenter(IProfileEdit.IProfileView view){
        manager = new ProfileEditManager(this);
        this.view = view;
    }


    /*=================================== IProfilePresenter Interface ===============================*/
    @Override
    public ProfileEditDataAdapter getDataAdapter() throws UserException {

        ProfileEditDataAdapter profileEditDataAdapter = new ProfileEditDataAdapter(manager.getUser());
        return profileEditDataAdapter;
    }

    @Override
    public void saveUser(ProfileEditDataAdapter profileEditDataAdapter) {
        manager.saveUser(profileEditDataAdapter.getUser());
    }

    @Override
    public void saveError() {
        view.saveError();
    }

    @Override
    public void saveSuccess() {
        view.saveSuccess();
    }
}
