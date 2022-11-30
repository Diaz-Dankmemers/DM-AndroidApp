package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.material.tooltip.TooltipDrawable;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    private Button playButton;
    private Switch audioButton;
    private Intent settingsDataForGame;
    private boolean audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
}