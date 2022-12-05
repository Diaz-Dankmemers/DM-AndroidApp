package com.example.concentration;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private static MediaPlayer mPlayer;


    public static MediaPlayer get(Context c){
        if(mPlayer == null)
        {
            mPlayer = MediaPlayer.create(c, R.raw.dancing_in_the_moonlight_johnny_lectro_remix);
        }
        return mPlayer;
    }

    AudioPlayer(){

    }


    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        mPlayer = MediaPlayer.create(c, R.raw.dancing_in_the_moonlight_johnny_lectro_remix);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50,50);
        mPlayer.start();
    }

    public void pause()
    {
        mPlayer.pause();
    }

    public void unpause(){
        mPlayer.start();
    }
}
