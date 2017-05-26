package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

/**
 * Created by lenovo on 5/26/2017.
 */

public enum NetworkTypes {

    Three_G ("3G"),
    Wifi ("wifi"),
    NotConnected ("not_connected");

    String type;
    private NetworkTypes(String nwType){
        type = nwType;
    }

    public String getType(){
        return type;
    }
}
