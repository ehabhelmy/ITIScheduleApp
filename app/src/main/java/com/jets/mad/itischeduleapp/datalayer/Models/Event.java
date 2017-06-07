package com.jets.mad.itischeduleapp.datalayer.Models;

/**
 * Created by lenovo on 6/7/2017.
 */

public class Event extends BaseModel{

    private int id;
    private String name;
    private String description;
    private int register;

    public static final int REGISTERED = 0;
    public static final int NOT_REGISTERED = 1;

    public Event() {
    }

    public Event(int id, String name, String description, int register) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.register = register;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }
}
