package com.example.concentration;

import static android.content.ContentValues.TAG;

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

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm = getSupportFragmentManager();
    private Fragment fragment;
    private Score score;
    private final String[] words1 = {"KOALA", "LION", "EAGLE", "PENGUIN", "MOOSE", "CAMEL", "PARROT", "DOG", "MONKEY", "CAT"};
    private boolean[] clickedOn;
    private ArrayList<Button> buttonList = new ArrayList<Button>();
    private int count = 0;
    private Button endGame;
    private Button newGame;
    private Button refresh;
    private boolean flag;
    private int clickedID, clickedID2;
    Button clicked;
    Button clicked2;


    //moved data saving to Score.java

    //code for handling scores
    public static int gameNum = -1;
    public static ScoreTrackingInterface newScore = new ScoreTracker();
    TextView tv1;


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
        try {
            flag = savedInstanceState.getBoolean("flag");
        } catch (Exception e) {
            flag = true;
        }
        try {
            clickedOn = savedInstanceState.getBooleanArray("matched");
        } catch (Exception e) {
            clickedOn = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,};
        }
        try {
            clickedID = savedInstanceState.getInt("ID");
            System.out.println("Clicked ID: " + clickedID);
            clickedID2 = savedInstanceState.getInt("ID2");
            System.out.println("Clicked ID2: " + clickedID2);
            clicked = findViewById(clickedID);
            clicked2 = findViewById(clickedID2);

            System.out.println("Clicked2 ID: " + clicked2.getId());
        } catch (Exception e) {

        }



        System.out.println("frag creation.");

        Intent settingsData = getIntent();

        fragment = GameFragment.newInstance(((Intent) settingsData).getBooleanExtra("audio", true));
        System.out.println("frag creation passed.");

        if (flag) {
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

        tv1 = (TextView)findViewById(R.id.mScoreDisplayGame);
        tv1.setText("Score: "+newScore.getScore());

        int gameTiles = getIntent().getIntExtra("tiles", 20);
        switch(gameTiles)
        {
            case 4:
                gameNum = 0;
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

        }

        int listSize = buttonList.size();
        for (int i = gameTiles; i < listSize; i++) {
            buttonList.remove(gameTiles);
        }
        Collections.shuffle(buttonList);

        for (int i = 0; i < buttonList.size() / 2; i++) {
            int finalI = i;
            buttonList.get(i).setOnClickListener(view -> {
                if (count == 0) {
                    buttonList.get(finalI).setText(words1[finalI]);
                    clicked = buttonList.get(finalI);
                    clicked.setEnabled(false);
                    clickedOn[buttonList.indexOf(clicked)] = true;
                    count++;
                } else if (count == 1) {
                    buttonList.get(finalI).setText(words1[finalI]);
                    clicked2 = buttonList.get(finalI);
                    clicked.setEnabled(true);
                    clickedOn[buttonList.indexOf(clicked2)] = true;
                    count++;
                    if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                        count = 0;
                        clicked.setEnabled(false);
                        clicked2.setEnabled(false);
                        newScore.addScore(2);

                    } else {
                        newScore.addScore(-1);
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
                    clicked = buttonList.get(finalI);
                    clicked.setEnabled(false);
                    clickedOn[buttonList.indexOf(clicked)] = true;
                    count++;
                } else if (count == 1) {
                    buttonList.get(finalI).setText(words1[finalI - buttonList.size() / 2]);
                    clicked2 = buttonList.get(finalI);
                    clicked.setEnabled(true);
                    clickedOn[buttonList.indexOf(clicked2)] = true;
                    count++;
                    if (clicked.getText().toString().equals(clicked2.getText().toString())) {
                        count = 0;
                        clicked.setEnabled(false);
                        clicked2.setEnabled(false);
                        newScore.addScore(2);
                    } else {
                        newScore.addScore(-1);
                    }
                    tv1.setText("Score: "+newScore.getScore());
                }

            });
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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


    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBooleanArray("matched", clickedOn);
        try {
            clickedID = clicked.getId();
            clickedID2 = clicked2.getId();
            savedInstanceState.putInt("ID", clickedID);
            savedInstanceState.putInt("ID2", clickedID2);
        } catch (Exception ignored) {

        }

        savedInstanceState.putBoolean("flag", false);
    } //saving data across rotation, save game state on rotation

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
                    clicked.setText("");
                    clicked2.setText("");
                }
                break;
            }

        }
    }
}
