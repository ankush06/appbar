package com.example.desibazar.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by arai on 8/30/2017.
 */

public class BaseToolbarActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout mDrawerLayout;
    public ActionBarDrawerToggle mDrawerToggle;
    public  String TAG = AppCompatActivity.class.getSimpleName();
    public Toolbar toolbar;


    @Override
    public void setContentView(int layoutResID)
    {
         /**
         * This is going to be our actual root layout.
         */
        mDrawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base_toolbar, null);
        FrameLayout activityContainer = (FrameLayout) mDrawerLayout.findViewById(R.id.content_frame);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(mDrawerLayout);


        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if(useToolbar()) {
            setSupportActionBar(toolbar);
        }
        else
        {
            toolbar.setVisibility(View.GONE);
        }

        setNavView();
    }

    protected boolean useToolbar()
    {
        return true;
    }
    protected void setNavView()
    {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_action_main, menu);
        return true;
    }

    /* TO update navigation icon */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {

            case R.id.chart:
                Log.d(TAG, "chart selected ........................");
                SettingsActivity();
                return true;

            default:
                Log.e(TAG, "selected default....................................................................");

        }
        // TOD0O selecting activity...
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        if(item == null)
            return false;
        int id = item.getItemId();
        if (id == R.id.settings) {
            Log.d(TAG, " settings selected ....................................................................");
        } else if (id == R.id.search) {
            Log.d(TAG, "search selected ....................................................................");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Launching new activity
     * */
    private void SettingsActivity() {
        Intent i = new Intent(BaseToolbarActivity.this, SettingsActivity.class);
        startActivity(i);
    }

}


