package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 08/01/18.
 */
public class MyImage {
    private String photoUrl;
    private String photoName;

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }


    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public MyImage(String photoUrl, String photoName) {
        this.photoUrl = photoUrl;
        this.photoName = photoName;
    }

    public MyImage() {


    }
}


