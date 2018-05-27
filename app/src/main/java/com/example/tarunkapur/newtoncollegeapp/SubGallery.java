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

/*
This Activity is used for showing all the images corresponding to the a particular Event in newton gallery
 */

public class SubGallery extends AppCompatActivity {

    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_gallery);

        // RecyclerView Initialisation for showing images corresponding to a particular categaory(like children's day Event, newYear celebration).
        final List<SubMyImage> list=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.s_gallery_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        // Obtaining the event category from the message from the previous activity using intent.
        Bundle bundle=getIntent().getExtras();
        String myMessage=bundle.getString("myMessage");

/*
          getting Firebase instance and loading images from database corresponding to the selected category of the event.
 */
        mRef= FirebaseDatabase.getInstance().getReference().child("subGalleryImage").child(myMessage);
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

