package com.example.concentration;

import android.content.Context;
import android.util.Log;

import com.example.concentration.GameActivity;
import com.example.concentration.ScoreTracker;
import com.example.concentration.ScoresJSONSerializer;

import java.util.ArrayList;
/***************************************************************
 *  file: Score.java
 *  author: J. Ong
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for file saving the score
 *
 ****************************************************************/

public class Score {

    //for data saving - remi
    private static final String TAG = "GameActivity";
    private static final String FILENAME = "scores.json";

    private ArrayList<ArrayList<ScoreTracker>> mScores;
    //private ArrayList<ScoreTracker> mScores;
    private ScoresJSONSerializer mSerializer;

    private static GameActivity sGameActivity;
    private Context mAppContext;
    //method:Constructor
    //purpose: loads score
    public Score(Context appContext){
        mAppContext = appContext;

        mSerializer = new ScoresJSONSerializer(mAppContext, FILENAME);

        try {
            mScores = mSerializer.loadScores();
        } catch (Exception e)
        {
            mScores = new ArrayList<ArrayList<ScoreTracker>>();
            Log.e(TAG, "Error loading scores: ", e);
        }

    }
    //method:getScores
    //purpose: returns score
    public ArrayList<ScoreTracker> getScores(int i){
        return mScores.get(i);
    }

    //method:removeLowScores
    //Purpose:Removes all but the three highest scores.
    private void removeLowScores(){
        for(int i=0; i<mScores.size(); i++) {
            while (mScores.get(i).size() > 3) {
                int lowest = Integer.MAX_VALUE;
                int index = 0;
                for (int j = 0; j < mScores.get(i).size(); j++) {
                    if (mScores.get(i).get(j).getScore() < lowest) {
                        index = j;
                        lowest = mScores.get(i).get(j).getScore();
                    }
                }
                mScores.get(i).remove(index);
            }
        }
    }
    //method:sortScores
    //purpose: Organizes scores from lowest to highest
    private void sortScores(){
        for(int i=0; i<mScores.size(); i++) {
            ArrayList<ScoreTracker> sorted = new ArrayList<>();
            while (!mScores.get(i).isEmpty()) {
                int highest = Integer.MIN_VALUE;
                int index = 0;
                for (int j = 0; j < mScores.get(i).size(); j++) {
                    if (mScores.get(i).get(j).getScore() > highest) {
                        index = j;
                        highest = mScores.get(i).get(j).getScore();
                    }
                }
                sorted.add(mScores.get(i).remove(index));
            }
            mScores.set(i, sorted);
        }
    }
    //method:addScore
    //purpose: Adds a high score
    public void addScore(int i, ScoreTrackingInterface s)
    {
        mScores.get(i).add((ScoreTracker) s);
    }
    //method:getmScores
    //purpose: returns the scores
    public ArrayList<ArrayList<ScoreTracker>> getmScores() { return  mScores;}
    //method:saveScores
    //purpose: Saves scores to file
    public boolean saveScores() {
        try {
            removeLowScores();
            sortScores();
            mSerializer.saveScores(mScores);
            Log.d(TAG, "scores saved to file");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving scores: ", e);
            return false;
        }
    }
    //method:resetScores
    //purpose: resets the scores in the ArrayList
    public void resetScores(){
        mScores = new ArrayList<>();
        for(int i=0; i<9; i++) {
            ArrayList<ScoreTracker> iScores = new ArrayList<>();
            iScores.add(new ScoreTracker());
            iScores.add(new ScoreTracker());
            iScores.add(new ScoreTracker());
            mScores.add(iScores);
        }
    }
    //method:testScores
    //purpose: Testing with example scores
    public void testScores(){
        //resetScores();
        for(int i=0; i<mScores.size(); i++) {
            mScores.get(i).add(new ScoreTracker(50, "DAN"));
            mScores.get(i).add(new ScoreTracker());
            mScores.get(i).add(new ScoreTracker());
            mScores.get(i).add(new ScoreTracker(20, "JEF"));
            mScores.get(i).add(new ScoreTracker(66, "POG"));
            mScores.get(i).add(new ScoreTracker(12, "BOI"));
        }
        //testScores2();
    }
    //method:submitScore
    //purpose: User input submitting scores.
    public void submitScore(int tiles, int score, String name){
        mScores.get(tiles).add(new ScoreTracker(score, name));
    }
    //end data saving code - remi
}
