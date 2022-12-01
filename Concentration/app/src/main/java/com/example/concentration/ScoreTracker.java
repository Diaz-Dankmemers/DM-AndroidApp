package com.example.concentration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class ScoreTracker implements ScoreTrackingInterface{

    private static final String JSON_NAMES = "name";
    private static final String JSON_SCORES = "score";

    private int score;
    private String name;

    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_NAMES, name);
        json.put(JSON_SCORES, score);
        return json;
    }

    public ScoreTracker(JSONObject json) throws JSONException{
        score = json.getInt(JSON_SCORES);
        name = json.getString(JSON_NAMES);
    }

    public ScoreTracker() {
        score = 0;
        name = "AAA";
    }

    public void setName(String newName){
        name = newName;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score = newScore;
    }

    public void adjustScore(int points) {
        score += points;
    }
}
