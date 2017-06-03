package com.jets.mad.itischeduleapp.datalayer.Models;

public class Events extends BaseModel {

    private int id;
    private String startTime;
    private String endTime;
    private String eventName;
    private int color;

    public Events(int id, String startTime, String endTime, String eventName, int color){
        this.id = id;
        this.endTime = endTime;
        this.startTime = startTime;
        this.eventName = eventName;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
