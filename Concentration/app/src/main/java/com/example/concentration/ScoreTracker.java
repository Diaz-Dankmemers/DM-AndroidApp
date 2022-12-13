package com.example.concentration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
/***************************************************************
 *  file: ScoreTracker.java
 *  author: J. Ong
 *  class: CS 2450
 *
 *  assignment: Android App
 *  date last modified: 12/11/2022
 *
 *  purpose: This contains the code for score tracking
 *
 ****************************************************************/
public class ScoreTracker implements ScoreTrackingInterface{

    private static final String JSON_NAMES = "name";
    private static final String JSON_SCORES = "score";

    private int score;
    private String name;

    public ScoreTracker(JSONObject json) throws JSONException{
        score = json.getInt(JSON_SCORES);
        name = json.getString(JSON_NAMES);
    }
    // method: Constructor
    // purpose: Initializes variables for tracking score
    public ScoreTracker() {
        score = 0;
        name = "AAA";
    }
    // method: Constructor
    // purpose: Initializes variables for tracking score
    public ScoreTracker(int points, String word){
        score = points;
        if(word.length() > 3)
        {
            name = word.substring(0,2);
        }
        else
            name = word;
    }
    // method: toJSON
    // purpose: Converts input into JSON object
    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_NAMES, name);
        json.put(JSON_SCORES, score);
        return json;
    }


    // method: setName
    // purpose: Sets a new name
    public void setName(String newName){
        name = newName;
    }
    // method: getName
    // purpose: Returns name
    public String getName() {
        return name;
    }
    // method: getScore
    // purpose: returns the score
    public int getScore() {
        return score;
    }
    // method: setScore
    // purpose: Sets the score
    public void setScore(int newScore) {
        score = newScore;
    }
    // method: addScore
    // purpose: Add points to existing score
    public void addScore(int points) {
        score += points;
    }
}
