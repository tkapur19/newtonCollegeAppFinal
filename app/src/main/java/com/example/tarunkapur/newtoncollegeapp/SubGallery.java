package com.example.tarunkapur.newtoncollegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SubGallery extends AppCompatActivity {

    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_gallery);

        final List<SubMyImage> list=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.s_gallery_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Bundle bundle=getIntent().getExtras();
        String myMessage=bundle.getString("myMessage");


        mRef= FirebaseDatabase.getInstance().getReference().child("subGalleryImage").child(myMessage);
        SubMyImage myImage=new SubMyImage("https://scontent.fdel9-1.fna.fbcdn.net/v/t1.0-9/23517544_2005589803053338_8571067420085961527_n.jpg?oh=130d3250e75725db42cdb12161610f14&oe=5AB809A0");




        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SubMyImage myImage=dataSnapshot.getValue(SubMyImage.class);
                list.add(myImage);
                SubGalleryAdapter adapter=new SubGalleryAdapter(list,getApplicationContext());

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

