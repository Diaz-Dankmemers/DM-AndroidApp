package com.example.concentration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreTracker implements ScoreTrackingInterface{

    private int score;
    private int[] highScores;
    private String[] names;

    public ScoreTracker(){
        score = 0;
        highScores = new int[3];
        names = new String[3];
        processScoresFile();
    }

    private void processScoresFile(){
        Scanner scnr = new Scanner("scores.txt");
        int i = 0;
        while (scnr.hasNext()){
            names[i] = scnr.next();
            highScores[i] = scnr.nextInt();
            i++;
        }
        scnr.close();
    }

    @Override
    public void submitScore(String name) {

        int[] newHighScores = new int[highScores.length + 1];
        String[] newNames = new String[names.length + 1];

        int j=0;
        boolean spotFlag = false;
        for(int i=0; i<names.length; i++){
            if(score >= highScores[i] && !spotFlag){
                newHighScores[j] = score;
                newNames[j] = name;
                j++;
                spotFlag = true;
            }
            newHighScores[j] = highScores[i];
            newNames[j] = names[i];
            j++;
        }

        File scoreFile =new File("scores.txt");

        try {
            FileWriter f2 = new FileWriter(scoreFile, false);
            for (int i=0; i<3; i++){
                f2.write(newNames[i] + " " + newHighScores[i]);
            }
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        processScoresFile();
    }

    @Override
    public String getName(int position) {
        return names[position];
    }

    @Override
    public int getScore(int position) {
        return highScores[position];
    }

    @Override
    public void setCurrentScore(int newScore) {
        score = newScore;
    }

    @Override
    public void adjustCurrentScore(int points) {
        score += points;
    }

    @Override
    public int getCurrentScore(){
        return score;
    }
}
