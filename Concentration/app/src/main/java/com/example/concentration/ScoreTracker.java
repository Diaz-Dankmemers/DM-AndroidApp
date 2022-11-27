package com.example.concentration;

public class ScoreTracker implements ScoreTrackingInterface{

    private int score;

    public ScoreTracker(){
        score = 0;
    }

    private void processScores(){

    }

    @Override
    public void submitScore(String name, int newScore) {
        try {
            FileWriter myWriter = new FileWriter("scores.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String getName(int position) {
        return null;
    }

    @Override
    public int getScore(int position) {
        return 0;
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
