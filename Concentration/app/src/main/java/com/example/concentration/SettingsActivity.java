package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    private Button playButton;
    private ImageButton audioButton;
    private Intent settingsDataForGame;
    private boolean audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        playButton = findViewById(R.id.mPlayButton);
        playButton.setOnClickListener(this::onClick);

        audioButton = findViewById(R.id.mAudioButton);
        audioButton.setOnClickListener(this::onClick);


        settingsDataForGame = new Intent(SettingsActivity.this, GameActivity.class);
        audio = true;
        settingsDataForGame.putExtra("audio", audio);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean("audio", audio);
    } //saving data across rotation, save settings on rotation

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mAudioButton:
                audioButton.setSelected(!audioButton.isPressed());
                if(audioButton.isSelected())
                {
                    audioButton.setImageResource();
                }
                audio = !audio;
                settingsDataForGame.removeExtra("audio");
                settingsDataForGame.putExtra("audio", audio);
            case R.id.mPlayButton:
                startActivity(settingsDataForGame);

        }
    }
}