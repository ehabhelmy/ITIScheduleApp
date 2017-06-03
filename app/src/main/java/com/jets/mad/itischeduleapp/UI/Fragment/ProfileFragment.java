package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.MainActivity;
import com.jets.mad.itischeduleapp.UI.Activity.ProfileEditActivity;
import com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter.TabsAdapter;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IHome;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfile;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfileEdit;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.ProfilePresenter;
import com.jets.mad.itischeduleapp.utils.Constants;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.HomeFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements IProfile.IDataToProfileCommunicator {

    //UI References
    private ViewPager viewPager;
    private FloatingActionButton editBtn;
    private TextView username;

    private IProfile.IProfileToDataCommunicator dataCommunicator;
    private IHome.IHomeActivityUI homeActivity;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        username = (TextView) rootView.findViewById(R.id.profile_name);

        viewPager = (ViewPager) rootView.findViewById(R.id.profile_pager);
        TabsAdapter tabsAdapter = new TabsAdapter(getChildFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.profile_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        dataCommunicator = (IProfile.IProfileToDataCommunicator) tabsAdapter.getProfileDataFragment();
        dataCommunicator.setProfile(this);

        editBtn = (FloatingActionButton) rootView.findViewById(R.id.profile_edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent = new Intent(getActivity(), ProfileEditActivity.class);
            startActivity(intent);

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (MainActivity) context;
    }

    /*======================================== IDataToProfileCommunicator =============================================*/
    @Override
    public void setName(String name) {
        username.setText(name);
    }
}
