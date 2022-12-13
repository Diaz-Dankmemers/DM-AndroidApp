package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/***************************************************************
 *  file: HighScoresActivity.java
 *  author: J. Ong
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code high score functionality
 *
 ****************************************************************/
public class HighScoresActivity extends AppCompatActivity {

    private Score score;
    // method:onCreate
    // purpose: This is the UI for highscores
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        score = new Score(HighScoresActivity.this);

        Spinner spinnerTiles = findViewById(R.id.mScoreSelect);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.dropDown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerTiles.setAdapter(adapter);

        spinnerTiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // method:onItemSelected
            // purpose: This is the functionality for the buttons
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                ArrayList<ScoreTracker> selectedScores = null;


                // Load and use views afterwards
                TextView tv1 = (TextView)findViewById(R.id.scoreDisplay1);
                TextView tv2 = (TextView)findViewById(R.id.scoreDisplay2);
                TextView tv3 = (TextView)findViewById(R.id.scoreDisplay3);

                switch (item) {
                    case "4 tiles": {
                        System.out.println("4 tiles selected.");
                        selectedScores = score.getScores(0);
                        break;
                    }
                    case "6 tiles": {
                        System.out.println("6 tiles selected.");
                        selectedScores = score.getScores(1);
                        break;
                    }
                    case "8 tiles": {
                        System.out.println("8 tiles selected.");
                        selectedScores = score.getScores(2);
                        break;
                    }
                    case "10 tiles": {
                        System.out.println("10 tiles selected.");
                        selectedScores = score.getScores(3);
                        break;
                    }case "12 tiles": {
                        System.out.println("12 tiles selected.");
                        selectedScores = score.getScores(4);
                        break;
                    }
                    case "14 tiles": {
                        System.out.println("14 tiles selected.");
                        selectedScores = score.getScores(5);
                        break;
                    }
                    case "16 tiles": {
                        System.out.println("16 tiles selected.");
                        selectedScores = score.getScores(6);
                        break;
                    }
                    case "18 tiles": {
                        System.out.println("18 tiles selected.");
                        selectedScores = score.getScores(7);
                        break;
                    }
                    case "20 tiles": {
                        System.out.println("20 tiles selected.");
                        selectedScores = score.getScores(8);
                        break;
                    }
                }
                tv1.setText(selectedScores.get(0).getName() + ": " + selectedScores.get(0).getScore());
                tv2.setText(selectedScores.get(1).getName() + ": " + selectedScores.get(1).getScore());
                tv3.setText(selectedScores.get(2).getName() + ": " + selectedScores.get(2).getScore());
            }
            // method:onNothingSelected
            // purpose: This is the code for not selecting anything
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    // method:onOptionsItemSelected
    // purpose: This is for button functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case android.R.id.home:
            {
                Intent parentActivityIntent = new Intent(HighScoresActivity.this, MainActivity.class);
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