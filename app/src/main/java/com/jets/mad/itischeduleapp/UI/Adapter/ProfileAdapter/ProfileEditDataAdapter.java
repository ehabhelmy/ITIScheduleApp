package com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter;

import android.view.View;
import android.widget.EditText;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Models.User;

/**
 * Created by lenovo on 6/1/2017.
 */

public class ProfileEditDataAdapter {

    private User user;
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText phone;

    public ProfileEditDataAdapter(User user){
        this.user = user;
    }

    public void setDataView(View rootView){

        firstName = (EditText) rootView.findViewById(R.id.profile_edit_firstname);
        lastName = (EditText) rootView.findViewById(R.id.profile_edit_lastname);
        phone = (EditText) rootView.findViewById(R.id.profile_edit_phone);
        email = (EditText) rootView.findViewById(R.id.profile_edit_email);

        if(user !=null) {
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
        }else{
            //TODO: throw exception
        }

    }

    public User getUser(){

        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());

        return user;
    }

    public void setUser(User user){
        this.user = user;
    }


}
