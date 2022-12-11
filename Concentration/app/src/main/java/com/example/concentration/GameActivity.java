package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm = getSupportFragmentManager();
    private Fragment fragment;
    private Score score;
    private String words[] = {"KOALA","LION","EAGLE","PENGUIN","MOOSE","CAMEL","KOALA","DOG","LION","MOOSE","DOG","PARROT","EAGLE","CAMEL","PENGUIN","MONKEY","CAT","PARROT","MONKEY","CAT"};

    private ArrayList<Button> buttonList = new ArrayList<Button>();
    private int count = 0;
    private Button endGame;
    private Button newGame;
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
        endGame.setOnClickListener(this::onClick);
        newGame.setOnClickListener(this::onClick);

        System.out.println("frag creation.");

        Intent settingsData = getIntent();

        fragment = GameFragment.newInstance(((Intent) settingsData).getBooleanExtra("audio", true));
        System.out.println("frag creation passed.");

        System.out.println("Settings Received: " + settingsData.getBooleanExtra("audio", true));
        System.out.println("adding settings data");
        fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
        System.out.println("settings data added");

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
        Button button21 = (Button) findViewById(R.id.refresh);

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

        tv1 = (TextView)findViewById(R.id.scoreDisplayGame);
        tv1.setText("Score: "+newScore.getScore());

        int gametiles = getIntent().getIntExtra("tiles", 20);
        switch(gametiles)
        {
            case 4:
                gameNum = 0;
                button2.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button1.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button2.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                button5.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
                button8.setVisibility(View.INVISIBLE);
                button9.setVisibility(View.INVISIBLE);
                button10.setVisibility(View.INVISIBLE);
                button11.setVisibility(View.INVISIBLE);
                button12.setVisibility(View.INVISIBLE);
                button15.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 6:
                gameNum = 1;
                button4.setEnabled(false);
                button5.setEnabled(false);
                button1.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button4.setVisibility(View.INVISIBLE);
                button5.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
                button8.setVisibility(View.INVISIBLE);
                button10.setVisibility(View.INVISIBLE);
                button11.setVisibility(View.INVISIBLE);
                button12.setVisibility(View.INVISIBLE);
                button15.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 8:
                gameNum = 2;
                button5.setEnabled(false);
                button1.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button5.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
                button8.setVisibility(View.INVISIBLE);
                button10.setVisibility(View.INVISIBLE);
                button11.setVisibility(View.INVISIBLE);
                button12.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 10:
                gameNum = 3;
                button1.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button1.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
                button8.setVisibility(View.INVISIBLE);
                button11.setVisibility(View.INVISIBLE);
                button12.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 12:
                gameNum = 4;
                button8.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button8.setVisibility(View.INVISIBLE);
                button11.setVisibility(View.INVISIBLE);
                button12.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 14:
                gameNum = 5;
                button12.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button12.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 16:
                gameNum = 6;
                button16.setEnabled(false);
                button17.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button16.setVisibility(View.INVISIBLE);
                button17.setVisibility(View.INVISIBLE);
                button19.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 18:
                gameNum = 7;
                button17.setEnabled(false);
                button20.setEnabled(false);
                button17.setVisibility(View.INVISIBLE);
                button20.setVisibility(View.INVISIBLE);
            case 20:
                gameNum = 8;

        }

        //Collections.shuffle(buttonList);

{
                for (int i = 0; i < 20; i++) {
                    int finalI = i;
                    buttonList.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(count == 0){
                                buttonList.get(finalI).setText(words[finalI]);
                                clicked = buttonList.get(finalI);
                                clicked.setEnabled(false);
                                count++;}
                            else if(count == 1){
                                buttonList.get(finalI).setText(words[finalI]);
                                clicked2 = buttonList.get(finalI);
                                clicked.setEnabled(true);
                                count++;
                                if(clicked.getText().toString().equals(clicked2.getText().toString())){
                                    count = 0;
                                    clicked.setEnabled(false);
                                    clicked2.setEnabled(false);
                                    newScore.addScore(2);
                                } else {
                                    newScore.addScore(-1);
                                }
                                tv1.setText("Score: "+newScore.getScore());
                            }

                        }
                    });
                }
            }

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                clicked.setText("");
                clicked2.setText("");
            }
        });

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


   @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState");
    } //saving data across rotation, save game state on rotation

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mEndGame: {

                //show answers
                for(int i = 0; i < 20; i++){
                    buttonList.get(i).setText(words[i]);

                }

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent parentActivityIntent = new Intent(GameActivity.this, YourScoreActivity.class);
                        parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(parentActivityIntent);
                        finish();
                    }
                }, 1200);
                //save scores code below
                score.addScore(gameNum, newScore);
                //go to your score display

                break;
            }
            case R.id.mNewGame: {
                fm.beginTransaction().remove(fragment).commit();
                fragment = GameFragment.newInstance(false);
                fm.beginTransaction().add(R.id.fragmentContainerView2,fragment).commit();
                Intent parentActivityIntent = new Intent(GameActivity.this, SettingsActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(parentActivityIntent);
                finish();
                break;
            }

        }
    }
}
