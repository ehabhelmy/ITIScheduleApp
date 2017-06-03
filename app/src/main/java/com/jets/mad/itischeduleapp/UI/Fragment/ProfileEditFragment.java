package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.ProfileEditDataAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfileEdit;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.ProfileEditPresenter;
import com.jets.mad.itischeduleapp.datalayer.Exception.UserException;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileEditFragment extends Fragment implements IProfileEdit.IProfileView, IProfileEdit.IProfileFragment {

    private ProfileEditPresenter presenter;
    ProfileEditDataAdapter profileEditDataAdapter;

    public ProfileEditFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ProfileEditPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_profile_edit, container, false);

        Log.i("TAG", "ProfileEditFragment onCreateView: ");

        try {
            profileEditDataAdapter = presenter.getDataAdapter();
        } catch (UserException e) {
            Log.i("TAG", "onCreateView: " + e.toString());
        }
        profileEditDataAdapter.setDataView(rootView);

        return rootView;
    }


    /*======================================== IProfileView Interface ========================================*/

    @Override
    public void saveError() {
        //TODO: show error msg
    }

    @Override
    public void saveSuccess() {
        getActivity().finish();
    }

    /*======================================== IProfileFragment Interface ========================================*/
    @Override
    public void save() {
        presenter.saveUser(profileEditDataAdapter);
    }

    @Override
    public void cancel() {

    }
}
