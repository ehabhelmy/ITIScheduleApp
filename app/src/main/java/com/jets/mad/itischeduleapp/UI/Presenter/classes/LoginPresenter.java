package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import android.util.Log;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.utils.Network.NetworkMethod;
import com.jets.mad.itischeduleapp.utils.Network.NetworkUtils;
import com.jets.mad.itischeduleapp.utils.Network.URLS;
import com.jets.mad.itischeduleapp.utils.SharedPref;
import com.jets.mad.itischeduleapp.utils.ValidationUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 5/16/2017.
 */

public class LoginPresenter implements ILogin.ILoginPresenter, NetworkCallback{


    private ILogin.ILoginActivity loginActivity;

    public LoginPresenter(ILogin.ILoginActivity loginActivity){
        this.loginActivity = loginActivity;
    }
    /*============================= ILogin Interface ====================*/
    @Override
    public void login(String username, String password) {
        Log.i("TAG", "login");
        //1. client validation
        //if(!ValidationUtils.validateEmail(username)){
            if(NetworkUtils.isConnected()){
                Log.i("TAG", "login: connected");
                Map<String, String> params = new HashMap<>();
//                params.put("username", username);
//                params.put("password", password);
                params.put("name", username);
                NetworkHandler.callWebService(URLS.LOGIN_URL, NetworkMethod.POST, params, this);
            }else{
                Log.i("TAG", "login: notconnected");
            }

//        }else{
//            Log.i("TAG", "login: notvalid");
//        }

    }
    /*============================= NetworkCallBack Interface ====================*/
    @Override
    public void onSuccess(String response) {
        //1. save into shared pref
        //SharedPref.saveString("userToken", response);    //TODO: add user token from response
        Log.i("TAG", "onSuccess: "+response);
        //2. call activity to go to next activtiy
        loginActivity.loginSucceded();
    }

    @Override
    public void onError(VolleyError volleyError) {
        Log.i("TAG", "onError: "+ volleyError.toString());

        loginActivity.loginFailed();
    }
}
