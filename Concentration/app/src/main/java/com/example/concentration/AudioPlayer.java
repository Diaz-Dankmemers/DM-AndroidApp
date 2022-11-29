package com.example.concentration;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mPlayer;

    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        mPlayer = MediaPlayer.create(c, R.raw.dancing_in_the_moonlight_johnny_lectro_remix);
        mPlayer.setLooping(true);
        mPlayer.start();

        ScoreTrackingInterface testScore = new ScoreTracker();
        System.out.println(testScore.getName(0) + " " + testScore.getScore(0));
        System.out.println(testScore.getName(1) + " " + testScore.getScore(1));
        System.out.println(testScore.getName(2) + " " + testScore.getScore(2));

        testScore.setCurrentScore(9);
        testScore.adjustCurrentScore(4);

        testScore.submitScore("BEP");

    }
}
