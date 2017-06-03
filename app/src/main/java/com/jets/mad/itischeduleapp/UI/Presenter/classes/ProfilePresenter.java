package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileDataAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfile;
import com.jets.mad.itischeduleapp.datalayer.Managers.ProfileManager;
import com.jets.mad.itischeduleapp.datalayer.Models.User;

public class ProfilePresenter implements IProfile.IProfilePresenter, IProfile.IProfilePresenterUI{

    private IProfile.IProfileView iProfileView;
    private IProfile.IProfileModel iProfileModel;

    public ProfilePresenter(IProfile.IProfileView iProfileView){
        this.iProfileView = iProfileView;
        iProfileModel = new ProfileManager(this);

    }

    /*================================= IProfilePresenter Interface =========================================*/
    @Override
    public void setUser(User user) {
        ProfileDataAdapter profileDataAdapter = new ProfileDataAdapter(user);
        iProfileView.fillProfileData(profileDataAdapter);
    }

    @Override
    public void userFailed() {
        iProfileView.showError();
    }

    /*================================= IProfilePresenterUI Interface =========================================*/
    @Override
    public void setProfileData() {
        iProfileModel.getUser();
    }
}
