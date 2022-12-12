package com.example.concentration;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private static MediaPlayer mPlayer;
    private static AudioPlayer mAudioPlayer;

    public static AudioPlayer get(Context c){
        if(mAudioPlayer == null)
        {
           mAudioPlayer = new AudioPlayer();
        }
        mAudioPlayer.setSong(c);
        return mAudioPlayer;
    }



    private AudioPlayer(){

    }


    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void setSong(Context c){
        mPlayer = MediaPlayer.create(c, R.raw.dancing_in_the_moonlight_johnny_lectro_remix);
    }
    public void play(Context c){

        setSong(c);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50,50);
        mPlayer.start();
    }

    public void play(Context c, int time)
    {
        setSong(c);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50,50);
        mPlayer.seekTo(time);
        mPlayer.start();
    }

    public void pause()
    {
        mPlayer.pause();
    }

    public void unpause(){
        mPlayer.start();
    }

    public int getTimeStamp()
    {
       return mPlayer.getCurrentPosition();
    }

    public void goTo(int place){
        mPlayer.seekTo(place);
    }

    public boolean isPlaying(){
        return mPlayer.isPlaying();
    }
}
