package com.example.desibazar.appbar;

import android.os.Bundle;

/**
 * Created by arai on 8/29/2017.
 */

public class SettingsActivity extends BaseToolbarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);
    }

}


