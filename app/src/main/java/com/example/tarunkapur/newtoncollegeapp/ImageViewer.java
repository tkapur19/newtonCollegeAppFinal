package com.example.tarunkapur.newtoncollegeapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
/*
This Activity is for the final Image Viewer corresponding to Newton Gallery
 */
public class ImageViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        ImageView imageView=(ImageView) findViewById(R.id.image_view);
        Bundle bundle=getIntent().getExtras();
        String imageUrl=bundle.getString("photoUrl");
        Picasso.with(this).load(imageUrl).into(imageView);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
