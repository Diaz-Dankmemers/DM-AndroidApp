package com.example.concentration;

import android.content.Context;
import android.media.MediaPlayer;

/***************************************************************
 *  file: AudioPlayer.java
 *  author: D. Menkir
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for music functionality
 *
 ****************************************************************/
public class AudioPlayer {

    private static MediaPlayer mPlayer;
    private static AudioPlayer mAudioPlayer;

    // method: get
    // purpose: returns the audio player
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

    // method: stop
    // purpose: stops the audio player
    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }
    // method: setSong
    // purpose: sets song for the audio player
    public void setSong(Context c){
        mPlayer = MediaPlayer.create(c, R.raw.dancing_in_the_moonlight_johnny_lectro_remix);
    }
    // method: play
    // purpose: sets the volume, loops the music player and starts it.
    public void play(Context c){

        setSong(c);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50,50);
        mPlayer.start();
    }
    // method: play
    // purpose: sets the volume, loops the music player and starts it for a specified time.
    public void play(Context c, int time)
    {
        setSong(c);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50,50);
        mPlayer.seekTo(time);
        mPlayer.start();
    }
    // method: pause
    // purpose: Pauses the music player
    public void pause()
    {
        mPlayer.pause();
    }
    // method: unpause
    // purpose: Unpauses the music player
    public void unpause(){
        mPlayer.start();
    }
    // method: getTimeStamp
    // purpose: returns a timeStamp from the song
    public int getTimeStamp()
    {
       return mPlayer.getCurrentPosition();
    }
    // method: goTo
    // purpose: Goes to a specified place in the music player
    public void goTo(int place){
        mPlayer.seekTo(place);
    }
    // method: isPlaying
    // purpose: returns if the music player is working
    public boolean isPlaying(){
        return mPlayer.isPlaying();
    }
}
