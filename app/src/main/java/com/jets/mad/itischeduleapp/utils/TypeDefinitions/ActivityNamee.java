package com.jets.mad.itischeduleapp.utils.TypeDefinitions;

/**
 * Created by lenovo on 5/26/2017.
 */

public enum ActivityNamee {

    LOGIN("login"),
    HOME("home");

    private String name;
    private ActivityNamee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
