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
        mPlayer.setVolume(50,50);
        mPlayer.start();
    }
}
