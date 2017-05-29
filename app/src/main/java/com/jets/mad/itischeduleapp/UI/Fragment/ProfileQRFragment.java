package com.jets.mad.itischeduleapp.UI.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jets.mad.itischeduleapp.R;

/**
 * Created by lenovo on 5/28/2017.
 */

public class ProfileQRFragment extends Fragment {

    public ProfileQRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile_qr, container, false);
        return rootView;
    }
}
