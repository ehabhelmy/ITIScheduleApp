package com.jets.mad.itischeduleapp.UI.Presenter.classes;

import android.util.Log;

import com.android.volley.VolleyError;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;
import com.jets.mad.itischeduleapp.datalayer.Caching.Files.InternalFile;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkCallback;
import com.jets.mad.itischeduleapp.datalayer.Network.NetworkHandler;
import com.jets.mad.itischeduleapp.datalayer.Services.Token.TokenServiceHandler;
import com.jets.mad.itischeduleapp.utils.TypeDefinitions.NetworkMethod;
import com.jets.mad.itischeduleapp.utils.Network.NetworkUtils;
import com.jets.mad.itischeduleapp.utils.Network.URLS;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenter implements ILogin.ILoginPresenter, NetworkCallback{

    private ILogin.ILoginFragment loginFragment;

    public LoginPresenter(ILogin.ILoginFragment loginFragment){
        this.loginFragment = loginFragment;
    }
    /*============================= ILogin Interface ====================*/
    @Override
    public void login(String username, String password) {

        //1. client validation
        if(NetworkUtils.isConnected()){
            Map<String, String> params = new HashMap<>();
            params.put("j_username", username);
            params.put("j_password", password);
            NetworkHandler.callWebService(URLS.LOGIN_URL, NetworkMethod.POST, params, this);
        }else{
            loginFragment.loginFailed("Login Error", "Connection Error. Please check your network connection.");
        }

    }
    /*============================= NetworkCallBack Interface ====================*/
    @Override
    public void onSuccess(String response) {
        //TODO : get token from response

        //1. Save token into private file
        InternalFile internalFile = new InternalFile();
        internalFile.saveIntoFile(response);

        //2. schedule
        TokenServiceHandler tokenServiceHandler = new TokenServiceHandler();
        tokenServiceHandler.scheduleTokenService();

        //3.complete ui operations
        loginFragment.loginSucceded();


    }

    @Override
    public void onError(VolleyError volleyError) {
        Log.i("TAG", "LoginPresenter.java: onError: "+ volleyError.toString());
        loginFragment.loginFailed("Login Error", "Connection Error. Please Try Again.");
    }


}
