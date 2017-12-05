package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 05/12/17.
 */

public class listOfNotice {
    private String notice;
    private String date;

    public listOfNotice(String notice, String date) {
        this.notice = notice;
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public String getDate() {
        return date;
    }
}
