package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private static Fragment fragment;
    private Score score;

    //moved data saving to Score.java





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        score = new Score(GameActivity.this);
        System.out.println("frag creation.");

        Intent settingsData = getIntent();

        fragment = GameFragment.newInstance(((Intent) settingsData).getBooleanExtra("audio", false));
        System.out.println("frag creation passed.");

        System.out.println("Settings Received: " + settingsData.getBooleanExtra("audio", false));
        System.out.println("adding settings data");
        fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
        System.out.println("settings data added");

        score.testScores();
        System.out.println("testScores has been called");
        score.saveScores();
        System.out.println("saveScores has been called");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case android.R.id.home:
            {
                fm.beginTransaction().remove(fragment).commit();
                fragment = GameFragment.newInstance(false);
                fm.beginTransaction().add(R.id.fragmentContainerView2,fragment).commit();
                Intent parentActivityIntent = new Intent(GameActivity.this, SettingsActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(parentActivityIntent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //moved to Score.java


   /* @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(String, int);
    } *///saving data across rotation, save game state on rotation
}