package com.example.tarunkapur.newtoncollegeapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudrail.si.CloudRail;
import com.cloudrail.si.interfaces.SMS;
import com.cloudrail.si.services.Twilio;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private FirebaseDatabase mDataBase;
    private DatabaseReference mRef;
    private ChildEventListener childEventListener;
    private List<StudentDetails> absenteeList=new ArrayList<>();
    final List<StudentDetails> detailsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main3);



        TextView textView=(TextView) findViewById(R.id.text);
        Bundle receivedMessage=getIntent().getExtras();
        String myMessage=receivedMessage.getString("mymessage");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final StudentAdapter studentAdapter=new StudentAdapter(detailsList,this);

        mDataBase=FirebaseDatabase.getInstance();


        if(myMessage.equals("3:30-4:30")){


            textView.setText("NEWTON COLLEGE\nXI-Maths\nMWF-3:00-4:00");

            mRef=mDataBase.getReference().child("studentList").child("3:30-4:30");

            
           
            // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("5:45-6:45")){
            textView.setText("NEWTON COLLEGE\nXII-Accounts\nMWF-5:45-6:45");

            mRef=mDataBase.getReference().child("studentList").child("5:45-6:45");


                // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("6:45-7:45")){
            textView.setText("NEWTON COLLEGE\nXII-Maths\nMWF-6:45-7:45");

            mRef=mDataBase.getReference().child("studentList").child("6:45-7:45");


            // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("3:50-4:50")){
            textView.setText("NEWTON COLLEGE\nXI-Maths\nTTS-3:50-4:50");

            mRef=mDataBase.getReference().child("studentList").child("3:50-4:50");


               // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("4:50-5:50")){
            textView.setText("NEWTON COLLEGE\nXI-Accounts\nTTS-4:50-5:50");

            mRef=mDataBase.getReference().child("studentList").child("4:50-5:50");


                // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("5:50-6:50")){
             textView.setText("NEWTON COLLEGE\nXII-Maths\nTTS-5:50-6:50");

            mRef=mDataBase.getReference().child("studentList").child("5:50-6:50");


               // Read the added and changed data in the firebase database

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        else if(myMessage.equals("6:50-7:50")){
            textView.setText("NEWTON COLLEGE\nXII-Accounts\nTTS-6:50-7:50");

            mRef=mDataBase.getReference().child("studentList").child("6:50-7:50");
            // Read the added and changed data in the firebase database
           
           

            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();
                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    StudentDetails studentDetails1=new StudentDetails();

                    studentDetails1=dataSnapshot.getValue(StudentDetails.class);
                    detailsList.add(studentDetails1);
                    recyclerView.setAdapter(studentAdapter);



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
        Button myButton=(Button) findViewById(R.id.send_message);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int length=studentAdapter.getAbsenteeList().size();

                if (length==0){
                    Toast.makeText(getApplicationContext(),"All are present",Toast.LENGTH_LONG).show();
                    new Thread(){
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                        }
                    }.start();

                }
                else if(length!=0) {

                    CloudRail.setAppKey("5a4c3e5bfd458621e434a130");
                    for(int i=0;i<length;i++) {


// final SMS sms = new Nexmo(this, "[clientIdentifier]", "[clientSecret]");
                        final SMS sms = new Twilio(getApplicationContext(), "AC5d31a2cd89ebd5c8569f17de784b414a", "003ce3f27a111be80250810ad2960413");
                        final int I= i;

                        new Thread() {
                            @Override
                            public void run() {
                                sms.sendSMS("+1 469-340-0579 ","+91"+studentAdapter.getAbsenteeList().get(I).getPhoneNo(), "Hello tarun");
                            }
                        }.start();


                    }
                    Toast.makeText(getApplicationContext(),"Messages have been sent to absentees",Toast.LENGTH_SHORT).show();
                    new Thread(){
                        @Override
                        public void run() {
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);

                        }
                    }.start();

                }


            }
        });


    }
}
