package com.example.concentration;

import static android.content.ContentValues.TAG;

import static com.example.concentration.GameFragment.music;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Collections;

/***************************************************************
 *  file: GameActivity.java
 *  author: K. Hoang, J. Ong, D Menkir, S. Araya
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for the game screen functionality
 *
 ****************************************************************/

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm = getSupportFragmentManager();
    private Fragment fragment;
    private Score score;
    private final String[] words1 = {"KOALA", "LION", "EAGLE", "PENGUIN", "MOOSE", "CAMEL", "PARROT", "DOG", "MONKEY", "CAT"};
    private boolean[] clickedOn;
    private ArrayList<Button> buttonList = new ArrayList<Button>();
    private int count = 0;
    private int match;
    private Button endGame;
    private Button newGame;
    private Button refresh;
    private boolean audioFlag;
    private int musicTimestamp;
    private boolean repeat;
    private int clickedID, clickedID2;
    private Button clicked;
    private Button clicked2;


    //moved data saving to Score.java

    //code for handling scores
    public static int gameNum = -1;
    public static ScoreTrackingInterface newScore = new ScoreTracker();
    TextView tv1;

    // method:onCreate
    // purpose: This sets up all the UI for the activity screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);


        score = new Score(GameActivity.this);
        endGame = findViewById(R.id.mEndGame);
        newGame = findViewById(R.id.mNewGame);
        refresh = findViewById(R.id.mRestart);
        endGame.setOnClickListener(this::onClick);
        newGame.setOnClickListener(this::onClick);
        refresh.setOnClickListener(this::onClick);

        int gameTiles = getIntent().getIntExtra("tiles", 20); //amount of tiles
        try {
            audioFlag = savedInstanceState.getBoolean("flag");

        } catch (Exception e) {
            audioFlag = true;
        }
        try {
            clickedOn = savedInstanceState.getBooleanArray("enable");
        } catch (Exception e) {
            clickedOn = new boolean[gameTiles];
            for (int i = 0; i < gameTiles; i++) {
                clickedOn[i] = true;
            }
        }
        try {
            clickedID = savedInstanceState.getInt("ID");
            System.out.println("Clicked ID name: " + clickedID);
            clickedID2 = savedInstanceState.getInt("ID2");
            System.out.println("Clicked ID2: " + clickedID2);
            clicked = findViewById(clickedID);
            clicked2 = findViewById(clickedID2);

            System.out.println("Clicked2 ID: " + clicked2.getId());
        } catch (Exception e) {

        }
        try {
            if(audioFlag) {
                musicTimestamp = savedInstanceState.getInt("musicTimestamp");
                music.stop();
                music.play(GameActivity.this, musicTimestamp);
            }
        }
        catch (Exception e) {

        }
        try {
            count = savedInstanceState.getInt("count");
        }
        catch (Exception e) {

        }
        try {
            repeat = savedInstanceState.getBoolean("repeat");
        }
        catch (Exception e) {
            repeat = false;
        }
        try {
            match = savedInstanceState.getInt("match");
        }
        catch (Exception e) {
            match = 0;
        }



        System.out.println("frag creation.");

        Intent settingsData = getIntent();

        fragment = GameFragment.newInstance(((Intent) settingsData).getBooleanExtra("audio", true));
        System.out.println("frag creation passed.");

        if (audioFlag) {
            System.out.println("Settings Received: " + settingsData.getBooleanExtra("audio", true));
            System.out.println("adding settings data");
            fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
            System.out.println("settings data added");
        }

        ScoreTrackingInterface currentScore = new ScoreTracker();


        /*
        score.testScores();
        System.out.println("testScores has been called");
        score.saveScores();
        System.out.println("saveScores has been called");
        */

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button12 = (Button) findViewById(R.id.button12);
        Button button13 = (Button) findViewById(R.id.button13);
        Button button14 = (Button) findViewById(R.id.button14);
        Button button15 = (Button) findViewById(R.id.button15);
        Button button16 = (Button) findViewById(R.id.button16);
        Button button17 = (Button) findViewById(R.id.button17);
        Button button18 = (Button) findViewById(R.id.button18);
        Button button19 = (Button) findViewById(R.id.button19);
        Button button20 = (Button) findViewById(R.id.button20);

        tv1 = (TextView)findViewById(R.id.mScoreDisplayGame);
        tv1.setText("Score: "+newScore.getScore());


        switch(gameTiles) //set buttons based on tiles and set where score will be saved
        {
            case 4:
                gameNum = 0;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                /*button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);*/
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);*/
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 6:
                gameNum = 1;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                /*button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);*/
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);*/
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 8:
                gameNum = 2;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                /*button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);*/
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);*/
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 10:
                gameNum = 3;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                /*button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);*/
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);*/
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 12:
                gameNum = 4;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                buttonList.add(button11);
                buttonList.add(button12);
               /* button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);*/
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);*/
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 14:
                gameNum = 5;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                buttonList.add(button11);
                buttonList.add(button12);
                buttonList.add(button13);
                buttonList.add(button14);
               /* button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);*/
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);*/
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 16:
                gameNum = 6;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                buttonList.add(button11);
                buttonList.add(button12);
                buttonList.add(button13);
                buttonList.add(button14);
                buttonList.add(button15);
                buttonList.add(button16);
               /* button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);*/
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                /*button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);*/
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 18:
                gameNum = 7;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                buttonList.add(button11);
                buttonList.add(button12);
                buttonList.add(button13);
                buttonList.add(button14);
                buttonList.add(button15);
                buttonList.add(button16);
                buttonList.add(button17);
                buttonList.add(button18);
               /* button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);*/
                button19.setEnabled(false);
                button20.setEnabled(false);
               /* button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);*/
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                break;
            case 20:
                gameNum = 8;
                buttonList.add(button1);
                buttonList.add(button2);
                buttonList.add(button3);
                buttonList.add(button4);
                buttonList.add(button5);
                buttonList.add(button6);
                buttonList.add(button7);
                buttonList.add(button8);
                buttonList.add(button9);
                buttonList.add(button10);
                buttonList.add(button11);
                buttonList.add(button12);
                buttonList.add(button13);
                buttonList.add(button14);
                buttonList.add(button15);
                buttonList.add(button16);
                buttonList.add(button17);
                buttonList.add(button18);
                buttonList.add(button19);
                buttonList.add(button20);
                break;

        }


        //tries to reinitialize buttons on rotate, start
        for (int i = 0; i < buttonList.size() / 2; i++) {
            if (!clickedOn[i]) {
                buttonList.get(i).setText(words1[i]);
                buttonList.get(i).setEnabled(false);
            }
        }
        for (int i = buttonList.size() / 2; i < buttonList.size(); i++) {
            if (!clickedOn[i]) {
                buttonList.get(i).setText(words1[(i - buttonList.size() / 2)]);
                buttonList.get(i).setEnabled(false);
            }
        }
        //end




        for (int i = 0; i < buttonList.size() / 2; i++) { //first half of buttons
            int finalI = i;
            buttonList.get(i).setOnClickListener(view -> {

                if (count == 0) {
                    buttonList.get(finalI).setText(words1[finalI]);
                        clickedID = buttonList.get(finalI).getId(); //get first comparison button's ID
                        clicked = buttonList.get(finalI); //get first comparison button
                        clicked.setEnabled(false); //disables button to prevent user from clicking it again
                    count++; //pass count as info could work to simplify code
                    try { //try if clicked or clicked2 is null
                        if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                            count = 0;
                            clicked.setEnabled(false);
                            clicked2.setEnabled(false); //disables buttons
                            newScore.addScore(2); //add 2 points
                            clicked = null;
                            clicked2 = null; //clicked and clicked2 set to null
                            clickedID = 0;
                            clickedID2 = 0;
                            match++; //a match was made
                            if(match == gameTiles/2)
                            {
                                endGame.performClick(); //end the game if all matches are made
                            }

                        } else {
                            clicked.setEnabled(true);
                            clicked2.setEnabled(true); //enable 2 compared buttons
                            if(newScore.getScore() > 0) {

                                newScore.addScore(-1); //minus 1 point
                            }

                        }

                    } catch (Exception e) {

                    }

                    tv1.setText("Score: "+newScore.getScore()); //update score
                } else if (count == 1) {
                    buttonList.get(finalI).setText(words1[finalI]);
                        clickedID2 = buttonList.get(finalI).getId();
                        clicked2 = buttonList.get(finalI);
                        clicked2.setEnabled(true);
                    count++;
                    try {
                        if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                            count = 0;
                            clicked.setEnabled(false);
                            clicked2.setEnabled(false);
                            newScore.addScore(2);
                            clicked = null;
                            clicked2 = null;
                            clickedID = 0;
                            clickedID2 = 0;
                            match++;
                            if(match == gameTiles/2)
                            {
                                endGame.performClick();
                            }

                        } else {
                            clicked.setEnabled(true);
                            clicked2.setEnabled(true);
                            if(newScore.getScore() > 0) {

                                newScore.addScore(-1);
                            }
                        }


                    } catch (Exception e) {

                    }
                    tv1.setText("Score: "+newScore.getScore());
                }

            });
        }

        for (int i = buttonList.size() / 2; i < buttonList.size(); i++) {
            int finalI = i;
            buttonList.get(i).setOnClickListener(view -> {
                if (count == 0) {
                    buttonList.get(finalI).setText(words1[finalI - buttonList.size() / 2]);
                        clickedID = buttonList.get(finalI).getId();
                        clicked = buttonList.get(finalI);
                        clicked.setEnabled(false);
                    count++;
                    try {
                        if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                            count = 0;
                            clicked.setEnabled(false);
                            clicked2.setEnabled(false);
                            newScore.addScore(2);
                            clicked = null;
                            clicked2 = null;
                            clickedID = 0;
                            clickedID2 = 0;
                            match++;
                            if(match == gameTiles/2)
                            {
                                endGame.performClick();
                            }

                        } else {
                            clicked.setEnabled(true);
                            clicked2.setEnabled(true);
                            if(newScore.getScore() > 0) {


                                newScore.addScore(-1);
                            }
                        }

                    } catch (Exception e) {

                    }
                    tv1.setText("Score: "+newScore.getScore());
                } else if (count == 1) {
                    buttonList.get(finalI).setText(words1[finalI - buttonList.size() / 2]);
                        clickedID2 = buttonList.get(finalI).getId();
                        clicked2 = buttonList.get(finalI);
                        clicked2.setEnabled(true);
                    count++;
                    try {
                        if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                            count = 0;
                            clicked.setEnabled(false);
                            clicked2.setEnabled(false);
                            newScore.addScore(2);
                            clicked = null;
                            clicked2 = null;
                            clickedID = 0;
                            clickedID2 = 0;
                            match++;
                            if(match == gameTiles/2)
                            {
                                endGame.performClick();
                            }

                        } else {
                            clicked.setEnabled(true);
                            clicked2.setEnabled(true);
                            if(newScore.getScore() > 0) {

                                newScore.addScore(-1);
                            }
                        }


                    } catch (Exception e) {

                    }
                    tv1.setText("Score: "+newScore.getScore());
                }

            });
        }



    }
    // method:onOptionsItemSelected
    // purpose: This sets up the UI for the activity screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            try{
                music.stop();
            }
            catch (Exception e)
            {

            }

            fm.beginTransaction().remove(fragment).commit();
            fragment = GameFragment.newInstance(false);
            fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
            Intent parentActivityIntent = new Intent(GameActivity.this, SettingsActivity.class);
            parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(parentActivityIntent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //moved to Score.java

    // method:onSaveInstanceState
    // purpose: This saves settings for the screen
    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBooleanArray("matched", clickedOn);
        try{
            savedInstanceState.putInt("musicTimestamp", music.getTimeStamp());
        } catch (Exception e) {

        }
        boolean[] enable = new boolean[buttonList.size()];
        for(int i = 0; i < buttonList.size(); i++)
        {
            enable[i] = buttonList.get(i).isEnabled();
        }

        try{

           savedInstanceState.putBooleanArray("enable", enable);
        } catch (Exception e) {

        }

        savedInstanceState.putInt("count", count);
        savedInstanceState.putInt("ID", clickedID);
        savedInstanceState.putInt("ID2", clickedID2);
        savedInstanceState.putBoolean("repeat", true);
        savedInstanceState.putInt("match", match);
        savedInstanceState.putBoolean("flag", false);
    } //saving data across rotation, save game state on rotation

    // method:onClick
    // purpose: This sets up actions for clicking a button.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mEndGame: {

                //show answers
                for (int i = 0; i < buttonList.size() / 2; i++) {
                    buttonList.get(i).setText(words1[i]);

                }
                for (int i = buttonList.size() / 2; i < buttonList.size(); i++) {
                    buttonList.get(i).setText(words1[(i - buttonList.size() / 2)]);

                }

                final Handler handler = new Handler();

                handler.postDelayed(() -> {

                    Intent parentActivityIntent = new Intent(GameActivity.this, YourScoreActivity.class);
                    parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(parentActivityIntent);

                    finish();

                }, 3000);
                //save scores

                //save scores code below
                score.addScore(gameNum, newScore);

                //go to your score display

                break;
            }
            case R.id.mNewGame: {
                newScore.setScore(0);
                try{
                    music.stop();
                }
                catch (Exception e)
                {

                }
                fm.beginTransaction().remove(fragment).commit();
                fragment = GameFragment.newInstance(false);
                fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
                Intent parentActivityIntent = new Intent(GameActivity.this, SettingsActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(parentActivityIntent);
                finish();
                break;
            }
            case R.id.mRestart: {
                if (clicked != null && clicked2 != null && (!clicked.getText().toString().equals(clicked2.getText().toString()))) {
                    count = 0;
                    clicked.setEnabled(true);
                    clicked2.setEnabled(true);
                    clicked.setText(" ");
                    clicked2.setText(" ");
                    clicked = null;
                    clicked2 = null;
                }
                break;
            }

        }
    }
}
