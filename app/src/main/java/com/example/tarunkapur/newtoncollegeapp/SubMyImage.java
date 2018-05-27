package com.example.tarunkapur.newtoncollegeapp;

/**
 * Created by tarunkapur on 09/01/18.
 */
/*
modal class for Images for loading image in subGallery.
 */
public class SubMyImage {
    private String photoUrl;

    public SubMyImage(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public SubMyImage() {

    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
