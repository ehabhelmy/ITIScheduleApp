package com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jets.mad.itischeduleapp.UI.Fragment.ProfileDataFragment;
import com.jets.mad.itischeduleapp.UI.Fragment.ProfileQRFragment;


public class TabsAdapter extends FragmentPagerAdapter {

    public String [] tabNames = {"Profile","QR Code"};
    private ProfileDataFragment profileDataFragment;
    private ProfileQRFragment profileQRFragment;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
        profileDataFragment = new ProfileDataFragment();
        profileQRFragment = new ProfileQRFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return profileDataFragment;

            case 1:
                return profileQRFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];

    }
}
