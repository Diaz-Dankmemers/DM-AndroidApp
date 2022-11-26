package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends AppCompatActivity {

    private AudioPlayer music;
    private FragmentManager fm = getSupportFragmentManager();
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        fragment = fm.findFragmentById(R.id.fragmentContainerView);
        if(fragment == null)
        {
            fragment = new GameFragment();
            fm.beginTransaction().add(R.id.fragmentContainerView, fragment).commit();
        }



        Intent settingsData = getIntent();

        Bundle bundle = new Bundle();
        bundle.putBoolean("audio", ((Intent) settingsData).getBooleanExtra("audio", true) );
        fragment.setArguments(bundle);
        fm.beginTransaction().add(R.id.fragmentContainerView, fragment).commit();
    }

   /* @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(String, int);
    } *///saving data across rotation, save game state on rotation
}