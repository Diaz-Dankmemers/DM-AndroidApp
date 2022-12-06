package com.example.concentration;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private Fragment fragment;
    private Score score;
    private String words[] = {"PENGUIN","LION","KOALA","MONKEY","DOG","CAT","EAGLE","CAMEL","PARROT","MOOSE",
            "PENGUIN","LION","KOALA","MONKEY","DOG","CAT","EAGLE","CAMEL","PARROT","MOOSE"};
    private ArrayList<Button> buttonList = new ArrayList<Button>();

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

        fragment = GameFragment.newInstance(((Intent) settingsData).getBooleanExtra("audio", true));
        System.out.println("frag creation passed.");

        System.out.println("Settings Received: " + settingsData.getBooleanExtra("audio", true));
        System.out.println("adding settings data");
        fm.beginTransaction().add(R.id.fragmentContainerView2, fragment).commit();
        System.out.println("settings data added");

        score.testScores();
        System.out.println("testScores has been called");
        score.saveScores();
        System.out.println("saveScores has been called");


        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button button10 = (Button)findViewById(R.id.button10);
        Button button11 = (Button)findViewById(R.id.button11);
        Button button12 = (Button)findViewById(R.id.button12);
        Button button13 = (Button)findViewById(R.id.button13);
        Button button14 = (Button)findViewById(R.id.button14);
        Button button15 = (Button)findViewById(R.id.button15);
        Button button16 = (Button)findViewById(R.id.button16);
        Button button17 = (Button)findViewById(R.id.button17);
        Button button18 = (Button)findViewById(R.id.button18);
        Button button19 = (Button)findViewById(R.id.button19);
        Button button20 = (Button)findViewById(R.id.button20);

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

        Collections.shuffle(buttonList);

        for(int i = 0; i < 20; i++){
            int finalI = i;
            buttonList.get(i).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    buttonList.get(finalI).setText(words[finalI]);
                }
            });
        }
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
}