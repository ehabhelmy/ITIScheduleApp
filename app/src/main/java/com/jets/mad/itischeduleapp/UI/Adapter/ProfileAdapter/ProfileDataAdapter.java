package com.jets.mad.itischeduleapp.UI.Adapter.ProfileAdapter;

import android.view.View;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.datalayer.Models.User;

/**
 * Created by lenovo on 6/2/2017.
 */

public class ProfileDataAdapter {

    private User user;

    public ProfileDataAdapter(User user){
        this.user = user;

    }

    public void setDataView(View rootView){

        TextView name = (TextView) rootView.findViewById(R.id.profile_edit_firstname);
        TextView lastname = (TextView) rootView.findViewById(R.id.profile_edit_lastname);
        TextView email = (TextView) rootView.findViewById(R.id.profile_edit_email);
        TextView phone = (TextView) rootView.findViewById(R.id.profile_edit_phone);

        if(user !=null) {
            name.setText(user.getFirstName());
            lastname.setText(user.getLastName());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
        }else{
            //TODO: throw exception
        }


    }

    public void setUser(User user){
        this.user = user;
    }

    public String getUserName(){
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }

}
