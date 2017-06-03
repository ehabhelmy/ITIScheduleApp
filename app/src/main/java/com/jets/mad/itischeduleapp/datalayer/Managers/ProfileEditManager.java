package com.jets.mad.itischeduleapp.datalayer.Managers;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.IProfileEdit;
import com.jets.mad.itischeduleapp.datalayer.Caching.SharedPref;
import com.jets.mad.itischeduleapp.datalayer.Exception.UserException;
import com.jets.mad.itischeduleapp.datalayer.Models.User;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Constants;
import com.jets.mad.itischeduleapp.utils.Network.URLS;


public class ProfileEditManager implements IProfileEdit.IProfileModel{

    private IProfileEdit.IProfilePresenter profilePresenter;

    public ProfileEditManager(IProfileEdit.IProfilePresenter profilePresenter){
        this.profilePresenter = profilePresenter;
    }



    /*========================== IProfileModel Interface ================================*/
    @Override
    public User getUser() throws UserException {

        String userJson = SharedPref.retreiveString(Constants.PREF_USER_KEY);
        Gson gson = new Gson();
        if(userJson != null){

            return gson.fromJson(userJson, User.class);

        }else{  //no data saved for user in SharedPref
            //TODO: throw exception
            throw new UserException("Error, Please try again", UserException.ExceptionType.Connection);
        }

    }

    @Override
    public void saveUser(final User user){
        //save Network

        NetworkHandler.callWebServiceUsingPostWithObjectParam(URLS.PROFILE_EDIT_URL, user, new NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                //save shared pref
                SharedPref.saveObject(Constants.PREF_USER_KEY, user);
                profilePresenter.saveSuccess();
            }

            @Override
            public void onError(VolleyError volleyError) {
                profilePresenter.saveError();
            }
        });

    }

}
