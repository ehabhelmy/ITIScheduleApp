package com.jets.mad.itischeduleapp.datalayer.Models;

/**
 * Created by lenovo on 6/7/2017.
 */

public class Session extends BaseModel{

    private int id;
    private int room;
    private int eventID;
    private String name;
    private String sessionType;
    private int totalNumOfSession;
    private int sessionNum;
    private String Description;
    private Long startDate;
    private Long endDate;
    private int color;

    public Session() {
    }

    public Session(int id, int room, int eventID, String name, String sessionType, int totalNumOfSession, int sessionNum, String description, Long startDate, Long endDate, int color) {
        this.id = id;
        this.room = room;
        this.eventID = eventID;
        this.name = name;
        this.sessionType = sessionType;
        this.totalNumOfSession = totalNumOfSession;
        this.sessionNum = sessionNum;
        Description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public int getTotalNumOfSession() {
        return totalNumOfSession;
    }

    public void setTotalNumOfSession(int totalNumOfSession) {
        this.totalNumOfSession = totalNumOfSession;
    }

    public int getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(int sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
