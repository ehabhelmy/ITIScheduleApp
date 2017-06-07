package com.jets.mad.itischeduleapp.datalayer.Models;

/**
 * Created by lenovo on 6/6/2017.
 */

public class Notification extends BaseModel {

    private int id;
    private String msg;
    private String sender;
    private long sendingTime;

    public Notification(int id, String msg, String sender, long sendingTime) {
        this.id = id;
        this.msg = msg;
        this.sender = sender;
        this.sendingTime = sendingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(long sendingTime) {
        this.sendingTime = sendingTime;
    }
}
