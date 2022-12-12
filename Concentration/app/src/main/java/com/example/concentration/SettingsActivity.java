package com.example.concentration;

import static android.content.ContentValues.TAG;

import static com.example.concentration.GameActivity.newScore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;

import com.google.android.material.tooltip.TooltipDrawable;
/***************************************************************
 *  file: SettingsActivity.java
 *  author:
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for the settings page (Tile selection, audio button...)
 *
 ****************************************************************/

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button resetButton;
    private Score score;

    private Button playButton;
    private Switch audioButton;
    private Intent settingsDataForGame;
    private boolean audio;
    private int tiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        score = new Score(SettingsActivity.this);
        newScore.setScore(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        resetButton = findViewById(R.id.resetScoresButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.resetScores();
                score.saveScores();
            }
        });

        playButton = findViewById(R.id.mPlayButton);
        playButton.setOnClickListener(this::onClick);

        audioButton = findViewById(R.id.mAudioSwitch);
        audioButton.setOnClickListener(this::onClick);
        audioButton.setTextOff("No sound");
        audioButton.setTextOn("Sound");
        audioButton.setShowText(true);

        settingsDataForGame = new Intent(SettingsActivity.this, GameActivity.class);
        audio = false;


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
            case R.id.mAudioSwitch: {

                if(audioButton.isChecked())
                {
                    audio = true;

                }
                else
                    audio = false;
                System.out.println(audio);

                break;
            }
            case R.id.mPlayButton: {
                System.out.println("Settings passed: " + audio);
                settingsDataForGame.putExtra("audio", audio);
                settingsDataForGame.putExtra("tiles", tiles);
                startActivity(settingsDataForGame);
            }


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case android.R.id.home:
            {
                Intent parentActivityIntent = new Intent(SettingsActivity.this, MainActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(parentActivityIntent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton3:
                if (checked)
                    tiles = 4;
                    break;
            case R.id.radioButton4:
                if (checked)
                    tiles = 6;
                    break;
            case R.id.radioButton5:
                if (checked)
                    tiles = 8;
                    break;
            case R.id.radioButton6:
                if (checked)
                    tiles = 10;
                    break;
            case R.id.radioButton7:
                if (checked)
                    tiles = 12;
                    break;
            case R.id.radioButton8:
                if (checked)
                    tiles = 14;
                    break;
            case R.id.radioButton9:
                if (checked)
                    tiles = 16;
                    break;
            case R.id.radioButton10:
                if (checked)
                    tiles = 18;
                    break;
            case R.id.radioButton11:
                if (checked)
                    tiles = 20;
                    break;

        }
    }
}