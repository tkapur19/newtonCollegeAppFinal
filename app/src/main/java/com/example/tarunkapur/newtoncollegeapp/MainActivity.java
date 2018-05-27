package com.example.tarunkapur.newtoncollegeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CALL_PHONE = 1;
    List<listOfNotice> notices;
    private static final int RC_SIGN_IN = 123;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    private FirebaseDatabase mDataBase;
    private DatabaseReference mRef;
    private ChildEventListener childEventListener;
    String TAG="myMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar Settings
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Firebase Authentication(Google,Email)
        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){
            }
        else {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),

                                    new AuthUI.IdpConfig.GoogleBuilder().build())).setIsSmartLockEnabled(false)

                            .setTheme(R.style.GreenTheme).setLogo(R.drawable.background).build(),
                    RC_SIGN_IN);
        }


        // RecyclerView initialisation and data encapsulation in recyclerView
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        notices=new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //FirebaseDatabase initialisation
        mDataBase=FirebaseDatabase.getInstance();
        mRef=mDataBase.getReference().child("myNotice");
        final NoticeAdapter myAdapter=new NoticeAdapter(notices);


        // Read the added and changed data in the firebase database
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listOfNotice myNotice=new listOfNotice();
                myNotice=dataSnapshot.getValue(listOfNotice.class);
                notices.add(myNotice);
                recyclerView.setAdapter(myAdapter);
                }
                @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                listOfNotice myNotice=new listOfNotice();
                myNotice=dataSnapshot.getValue(listOfNotice.class);
                notices.add(myNotice);
                recyclerView.setAdapter(myAdapter);


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

        // AutoScrollViewPager for ImageSlider
        AutoScrollViewPager viewPager=(AutoScrollViewPager) findViewById(R.id.view_pager);

        viewPagerAdapter viewPagerAdapter=new viewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.startAutoScroll(5000);
        viewPager.setInterval(5000);
        viewPager.setCycle(true);

        viewPager.setBorderAnimation(true);
        viewPager.setSlideBorderMode(1);


        //Nevigation drawer Set-Up

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AuthUI.getInstance().signOut(this);
            Toast.makeText(MainActivity.this, "LogOut Success", Toast.LENGTH_SHORT).show();
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),

                                    new AuthUI.IdpConfig.GoogleBuilder().build())).setIsSmartLockEnabled(false)

                            .setTheme(R.style.GreenTheme).setLogo(R.drawable.background).build(),
                    RC_SIGN_IN);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1813788072233513"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ntclg"));
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.reg_class) {
            // attendance system activity
            Intent attandanceActivity=new Intent(this, Attendance.class);
            startActivity(attandanceActivity);
        }
        else if (id == R.id.extra_class) {
            // Gallery System Activity
            Intent newtonGallery=new Intent(this,NewtonGallery.class);
            startActivity(newtonGallery);


        }
        else if (id == R.id.test) {

            // Assignment System Activity
            Intent assignmentActivity=new Intent(this,Assignment.class);
            startActivity(assignmentActivity);



        }
        else if (id == R.id.phone) {


            // Calling Action With Asking Permisssion
            int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CALL_PHONE);
                Log.i(TAG, "onNavigationItemSelected: ");
            }
            else {

                Intent mycall = new Intent(Intent.ACTION_CALL);
                mycall.setData(Uri.parse("tel:9899728447"));
                startActivity(mycall);

            }

            }





        else if (id == R.id.email) {

            //Intent For E-mail

           Intent intent=new Intent(Intent.ACTION_SEND);
           intent.setData(Uri.parse("mailto:"));
           String []to={"1tarun.kapur@gmail.com"};
           intent.putExtra(Intent.EXTRA_EMAIL,to);
           intent.putExtra(Intent.EXTRA_SUBJECT,"");
           intent.putExtra(Intent.EXTRA_TEXT,"");
           intent.setType("message/rfc822");
            Intent chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);


        }
        else if (id==R.id.facebook){

            //Intent for opening facebook page
            Intent facebookIntent=getOpenFacebookIntent(MainActivity.this);
            startActivity(facebookIntent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //AuthUI.getInstance().signOut(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Checking for Succesful LogIn

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "LogIn success", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                finish();
                Toast.makeText(MainActivity.this, "logIn cancel", Toast.LENGTH_SHORT).show();


            }
        }


    }

        


}

