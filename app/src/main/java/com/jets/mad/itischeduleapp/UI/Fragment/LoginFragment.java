package com.jets.mad.itischeduleapp.UI.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Presenter.Interface.ILogin;
import com.jets.mad.itischeduleapp.UI.UIContracts.ILoginFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements ILoginFragment.ILoginUIFragment {

    private ILogin.ILoginUIActivity iLoginActivity;
    //UI References
    private View rootView;
    EditText userID;
    EditText password;
    Button loginBtn;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        userID = (EditText) rootView.findViewById(R.id.email);
        password = (EditText) rootView.findViewById(R.id.password);
        loginBtn = (Button) rootView.findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginActivity.login();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iLoginActivity = (ILogin.ILoginUIActivity) context;

    }
    /*============================= ILoginFragment Methods ==============================*/
    @Override
    public String getUsername() { return userID.getText().toString();  }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showError(String error) {

    }
}
