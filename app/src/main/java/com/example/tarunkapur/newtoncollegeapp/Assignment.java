package com.example.tarunkapur.newtoncollegeapp;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Assignment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<AssignmentTestModel> assignmentTestModels;
    private DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_assignment);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        assignmentTestModels=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.assignment_recyler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mRef= FirebaseDatabase.getInstance().getReference().child("assignmments");


        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                AssignmentTestModel assignmentTestModel1=dataSnapshot.getValue(AssignmentTestModel.class);
                assignmentTestModels.add(assignmentTestModel1);
                AssignmentTestAdapter assignmentTestAdapter=new AssignmentTestAdapter(assignmentTestModels,getApplicationContext());
                recyclerView.setAdapter(assignmentTestAdapter);


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
