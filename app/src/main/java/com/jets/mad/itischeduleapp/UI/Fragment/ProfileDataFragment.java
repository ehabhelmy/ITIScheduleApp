package com.jets.mad.itischeduleapp.UI.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileDataAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfile;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.ProfilePresenter;

public class ProfileDataFragment extends Fragment implements IProfile.IProfileView, IProfile.IProfileToDataCommunicator{

    private IProfile.IProfilePresenterUI presenter;
    private IProfile.IDataToProfileCommunicator profileToDataCommunicator;
    private View rootView;

    public ProfileDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_profile_data, container, false);

        Log.i("TAG", "ProfileDataFragment onCreateView: ");

        presenter = new ProfilePresenter(this);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setProfileData();
        //TODO: try to do it by using startActivityForResult
    }

    /*=================================== IProfileView Interface =========================================*/
    @Override
    public void fillProfileData(ProfileDataAdapter profileDataAdapter) {
        profileDataAdapter.setDataView(rootView);
        profileToDataCommunicator.setName(profileDataAdapter.getUserName());


    }

    @Override
    public void showError() {
        //TODO : show error msg
    }

    /*========================================= IProfileToDataCommunicator =========================== */
    @Override
    public void setProfile(IProfile.IDataToProfileCommunicator dataToProfileCommunicator) {
        this.profileToDataCommunicator = dataToProfileCommunicator;
    }
}
