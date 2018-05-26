package com.example.tarunkapur.newtoncollegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NewtonGallery extends AppCompatActivity {
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_gallery);
        Toolbar galleryTool=(Toolbar) findViewById(R.id.gallery_tool);
        setSupportActionBar(galleryTool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final List<MyImage> list=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        mRef= FirebaseDatabase.getInstance().getReference().child("galleryImages");
        MyImage myImage=new MyImage("https://scontent.fdel9-1.fna.fbcdn.net/v/t1.0-9/23517544_2005589803053338_8571067420085961527_n.jpg?oh=130d3250e75725db42cdb12161610f14&oe=5AB809A0","newYear");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MyImage myImage=dataSnapshot.getValue(MyImage.class);
                list.add(myImage);
                GalleryAdapter adapter=new GalleryAdapter(list,getApplicationContext());

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









    }


    }

