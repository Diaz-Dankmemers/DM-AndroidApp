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

    private ArrayList<ScoreTracker> mScores;
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
            mScores = new ArrayList<ScoreTracker>();
            Log.e(TAG, "Error loading scores: ", e);
        }

    }

    //Removes all but the three highest scores.
    private void removeLowScores(){
        while(mScores.size() > 3) {
            int lowest = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < mScores.size(); i++) {
                if (mScores.get(i).getScore() < lowest) {
                    index = i;
                    lowest = mScores.get(i).getScore();
                }
            }
            mScores.remove(index);
        }
    }

    private void sortScores(){
        ArrayList<ScoreTracker> sorted = new ArrayList<>();
        while(!mScores.isEmpty()){
            int highest = Integer.MIN_VALUE;
            int index = 0;
            for (int i=0; i<mScores.size(); i++){
                if (mScores.get(i).getScore() > highest){
                    index = i;
                    highest = mScores.get(i).getScore();
                }
            }
            sorted.add(mScores.remove(index));
        }
        mScores = sorted;
    }

    public void addScore(ScoreTracker s)
    {
        mScores.add(s);
    }

    public ArrayList<ScoreTracker> getmScores() { return  mScores;}

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
        mScores = new ArrayList<ScoreTracker>();
        mScores.add(new ScoreTracker());
        mScores.add(new ScoreTracker());
        mScores.add(new ScoreTracker());
    }

    public void testScores(){
        resetScores();
        mScores.add(new ScoreTracker(50, "DAN"));
        mScores.add(new ScoreTracker());
        mScores.add(new ScoreTracker());
        mScores.add(new ScoreTracker(20, "JEF"));
        mScores.add(new ScoreTracker(66, "POG"));
        mScores.add(new ScoreTracker(12, "BOI"));
    }
    //end data saving code - remi
}
