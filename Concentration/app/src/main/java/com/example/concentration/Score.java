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

    public void addScore(ScoreTracker s)
    {
        mScores.add(s);
    }

    public boolean saveScores() {
        try {
            mSerializer.saveScores(mScores);
            Log.d(TAG, "scores saved to file");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving scores: ", e);
            return false;
        }
    }

    public void testScores(){
        mScores.add(new ScoreTracker(50, "DAN"));
        mScores.add(new ScoreTracker());
        mScores.add(new ScoreTracker());
    }
    //end data saving code - remi
}
