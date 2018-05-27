package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 07/01/18.
 */

/*
Modal class for Assignment and result activity.
 */

public class AssignmentTestModel {
    private String heading;
    private String date;
    private String Url;

    public AssignmentTestModel(String heading, String date, String url) {
        this.heading = heading;
        this.date = date;
        Url = url;
    }

    public AssignmentTestModel() {

    }

    public String getHeading() {

        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
