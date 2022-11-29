package com.example.concentration;

//import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ScoreTrackTester {

    public static void main(String[] args){

        System.out.println(new File("scores.txt").getAbsolutePath());
        System.out.println(new File("scores.txt").getPath());
        try {
            System.out.println(new File("scores.txt").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        //Testing code for Score tracking, since the tiles aren't here yet.
        ScoreTrackingInterface testScore = new ScoreTracker();
        System.out.println(testScore.getName(0) + " " + testScore.getScore(0));
        System.out.println(testScore.getName(1) + " " + testScore.getScore(1));
        System.out.println(testScore.getName(2) + " " + testScore.getScore(2));

        testScore.setCurrentScore(9);
        testScore.adjustCurrentScore(4);

        testScore.submitScore("BEP");

        System.out.println(testScore.getName(0) + " " + testScore.getScore(0));
        System.out.println(testScore.getName(1) + " " + testScore.getScore(1));
        System.out.println(testScore.getName(2) + " " + testScore.getScore(2));

        //Testing end
        */


        /*
        Scanner scnr = new Scanner("scores.txt");
        while (scnr.hasNext()){
            System.out.println(scnr.next());
        }
        scnr.close();
        */
    }
}
