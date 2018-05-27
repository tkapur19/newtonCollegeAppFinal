package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 05/12/17.
 */

/*
Modal CLass for Notices
 */
public class listOfNotice {
    private String notice;
    private String date;

    public listOfNotice() {

    }

    public listOfNotice(String notice, String date) {
        this.notice = notice;
        this.date = date;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public String getDate() {
        return date;
    }
}
