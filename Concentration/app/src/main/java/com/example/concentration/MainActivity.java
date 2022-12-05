package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button startButton;

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
                    case R.id.mStartButton:
                        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                        System.out.println("Test");



                        startActivity(i);
                }
            }

        });

    }






}