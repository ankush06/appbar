package com.example.desibazar.appbar;

import android.os.Bundle;

public class MainActivity extends BaseToolbarActivity
         {
             @Override
             protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 //requestWindowFeature(Window.FEATURE_NO_TITLE);
                 setContentView(R.layout.activity_main);
             }

}

