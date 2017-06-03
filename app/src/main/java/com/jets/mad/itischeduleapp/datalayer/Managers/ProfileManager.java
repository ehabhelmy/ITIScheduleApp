package com.jets.mad.itischeduleapp.datalayer.Managers;

import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfile;
import com.jets.mad.itischeduleapp.datalayer.Caching.SharedPref;
import com.jets.mad.itischeduleapp.datalayer.Models.User;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Constants;
import com.jets.mad.itischeduleapp.utils.Network.URLS;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethods;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 6/1/2017.
 */

public class ProfileManager implements IProfile.IProfileModel{

    private IProfile.IProfilePresenter profilePresenter;

    public ProfileManager(IProfile.IProfilePresenter profilePresenter){
        this.profilePresenter = profilePresenter;
    }

    private void saveUser(User user){
        SharedPref.saveObject(Constants.PREF_USER_KEY, user);
    }

    /*======================== IProfileModel Interface ========================*/
    @Override
    public void getUser() {

        final Gson gson = new Gson();

        String userPref = SharedPref.retreiveString(Constants.PREF_USER_KEY);
        if(userPref != null){

            User user = gson.fromJson(userPref, User.class);
            profilePresenter.setUser(user);

        }else{  //no data saved for user in SharedPref

            //get From Network
            Map<String, String> param = new HashMap<>();
            param.put("id", "1");  //TODO : change id
            NetworkHandler.callWebService(URLS.PROFILE_URL, NetworkMethods.GET, param, new NetworkCallback() {
                @Override
                public void onSuccess(String response) {
                    User user = gson.fromJson(response, User.class);
                    saveUser(user);
                    profilePresenter.setUser(user);
                    Log.i("TAG", "ProfileManager: onSuccess: "+ response.toString());
                }

                @Override
                public void onError(VolleyError volleyError) {
                    Log.i("TAG", "ProfileManager: onError: "+ volleyError.toString());
                    profilePresenter.userFailed();
                }
            });
        }


    }
}
