package com.example.remotfiy;

public class getcom {
    String sender,action,date,time;

    public getcom(String sender, String action, String date, String time) {
        this.sender = sender;
        this.action = action;
        this.date = date;
        this.time = time;
    }
    public getcom(){

    }
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }


}
