package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    private Button audioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        startButton = findViewById(R.id.mStartButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(String, int);
    } //saving data across rotation, save settings on rotation

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mAudioButton:
                Intent i = new Intent(SettingsActivity.this, GameActivity.class);
                startActivity(i);
        }
    }
}