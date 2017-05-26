package com.jets.mad.itischeduleapp.utils.UI;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class Alert {

        public static void showErrorMsg(String title, String msg, Context context) {

            final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(msg);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
}
