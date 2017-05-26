package com.jets.mad.itischeduleapp.UI.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;
import com.jets.mad.itischeduleapp.UI.Presenter.classes.LoginPresenter;
import com.jets.mad.itischeduleapp.utils.UI.Alert;


public class LoginFragment extends Fragment implements ILogin.ILoginFragment {

    private ILogin.ILoginActivity iLoginActivity;
    private ILogin.ILoginPresenter iLoginPresenter;

    //UI References
    private View rootView;
    private EditText userID;
    private EditText password;
    private Button loginBtn;
    private ProgressDialog progressDialog;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //link activity with presenter
        iLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        userID = (EditText) rootView.findViewById(R.id.email);
        password = (EditText) rootView.findViewById(R.id.password);
        progressDialog= new ProgressDialog(getActivity(),
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");


        loginBtn = (Button) rootView.findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                sendDataToPresenter();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iLoginActivity = (ILogin.ILoginActivity) context;

    }

    /*========================= HELPFUL METHODS =========================*/

    public void sendDataToPresenter() {
        String username = userID.getText().toString();
        String userPass = password.getText().toString();

        //pass these params to presenter
        iLoginPresenter.login(username, userPass);

    }
    /*========================= ILoginFragment Contract =========================*/
    @Override
    public void loginSucceded() {

        iLoginActivity.goToNextActivity();
        progressDialog.dismiss();
    }

    @Override
    public void loginFailed(String title, String msg) {

        progressDialog.dismiss();
        Alert.showErrorMsg(title, msg, getContext());

    }

}
