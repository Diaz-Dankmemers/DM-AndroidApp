package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button startButton;
    private Button highScores;
    /***************************************************************
     *  file: MainActivity.java
     *  author:
     *  class: CS 2450
     *
     *  assignment: Android App
     *  date last modified: 12/11/2022
     *
     *  purpose: This contains the code for the formatted main screen
     *
     ****************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setHomeButtonEnabled(false);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);


        startButton = findViewById(R.id.mStartButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.mStartButton: {
                        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(i);
                        break;
                    }
                }
            }

        });
        highScores = findViewById(R.id.mHighScores);
        highScores.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case  R.id.mHighScores: {
                        Intent i = new Intent(MainActivity.this, HighScoresActivity.class);
                        startActivity(i);
                        break;
                    }
                }
            }
        });

    }






}