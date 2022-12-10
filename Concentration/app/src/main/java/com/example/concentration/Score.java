package com.example.concentration;

import android.content.Context;
import android.util.Log;

import com.example.concentration.GameActivity;
import com.example.concentration.ScoreTracker;
import com.example.concentration.ScoresJSONSerializer;

import java.util.ArrayList;

public class Score {

    //for data saving - remi
    private static final String TAG = "GameActivity";
    private static final String FILENAME = "scores.json";

    private ArrayList<ArrayList<ScoreTracker>> mScores;
    //private ArrayList<ScoreTracker> mScores;
    private ScoresJSONSerializer mSerializer;

    private static GameActivity sGameActivity;
    private Context mAppContext;

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

    public ArrayList<ScoreTracker> getScores(int i){
        return mScores.get(i);
    }

    //Removes all but the three highest scores.
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

    public void addScore(int i, ScoreTracker s)
    {
        mScores.get(i).add(s);
    }

    public ArrayList<ArrayList<ScoreTracker>> getmScores() { return  mScores;}

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

    public void testScores(){
        resetScores();
        for(int i=0; i<mScores.size(); i++) {
            mScores.get(i).add(new ScoreTracker(50, "DAN"));
            mScores.get(i).add(new ScoreTracker());
            mScores.get(i).add(new ScoreTracker());
            mScores.get(i).add(new ScoreTracker(20, "JEF"));
            mScores.get(i).add(new ScoreTracker(66, "POG"));
            mScores.get(i).add(new ScoreTracker(12, "BOI"));
        }
        testScores2();
    }

    public void testScores2(){
        mScores.get(0).add(new ScoreTracker(70, "AAA"));
        mScores.get(1).add(new ScoreTracker(70, "BBB"));
        mScores.get(2).add(new ScoreTracker(70, "CCC"));
        mScores.get(3).add(new ScoreTracker(70, "DDD"));
        mScores.get(4).add(new ScoreTracker(70, "EEE"));
        mScores.get(5).add(new ScoreTracker(70, "FFF"));
        mScores.get(6).add(new ScoreTracker(70, "GGG"));
        mScores.get(7).add(new ScoreTracker(70, "HHH"));
        mScores.get(8).add(new ScoreTracker(70, "III"));
    }
    //end data saving code - remi
}
