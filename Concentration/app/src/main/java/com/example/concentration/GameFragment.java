package com.example.concentration;


import static android.content.Intent.getIntent;

import android.app.Activity;
import android.app.GameManager;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/***************************************************************
 *  file: GameFragment.java
 *  author: D. Menkir
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for the fragment, making the music play
 *
 ****************************************************************/

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class GameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "audio";

    // TODO: Rename and change types of parameters
    private boolean mParam1;
    public static AudioPlayer music;
    private int musicTimestamp;


    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Audio on/off.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    // method:newInstance
    // purpose: This initializes the fragment.
    public static GameFragment newInstance(boolean param1) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        System.out.println("Settings received in fragment: " + param1);
        args.putBoolean(ARG_PARAM1, param1);
        fragment.setArguments(args);

        return fragment;
    }
    // method:onCreate
    // purpose: This sets up the UI for the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null) {

            mParam1 = getArguments().getBoolean(ARG_PARAM1, true);
            System.out.println("Arguments available. Set audio to: " + mParam1);
        }

            music = AudioPlayer.get(GameFragment.this.getContext());

        if (mParam1) {
            music.stop();
            music.play(GameFragment.this.getContext());

        }
        else
        {
            music.stop();
        }

    }
    // method:onAttach
    // purpose: This sets up the UI for the fragment
    @Override
    public void onAttach(Context context) {

        if(mParam1)
        {
            try {
                music.stop();
                music.goTo(musicTimestamp);
                music.play(GameFragment.this.getContext());
            } catch (Exception e)
            {
                music.stop();
                music.play(GameFragment.this.getContext());
            }
        }
        super.onAttach(context);
    }

    /*@Override
    public void onDetach() {
        musicTimestamp = music.getTimeStamp();
        music.stop();
        super.onDetach();
    }*/
    // method:onDestroy
    // purpose: This is the UI for stopping music
    @Override
    public void onDestroy() {


        music.stop();

        super.onDestroy();

    }
    // method:onCreateView
    // purpose: This is for the layout of the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        music.pause();
        System.out.println("Saved music time stamp.");


    }*/

   /* @Override
    public void onViewStateRestored(Bundle savedInstanceState) {

        super.onViewStateRestored(savedInstanceState);
        try {

            System.out.println("Time stamp initialized in onViewStateRestored");
        } catch (Exception ignored) {

        }

    }*/


}