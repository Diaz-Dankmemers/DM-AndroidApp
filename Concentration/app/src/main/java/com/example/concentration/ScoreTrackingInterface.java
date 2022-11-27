package com.example.concentration;

public interface ScoreTrackingInterface {

    int currentScore;

    /**
     * Submits the current score to the scores.txt file, trims scores if there are more than three.
     * @param name the name to be added
     * @param newScore the score achieved
     */
    public void submitScore(String name, int newScore);

    /**
     * Gets the name of the person in the score position
     * @param position the position in the scores.txt file
     * @return String the name of the person in position
     */
    public String getName(int position);

    /**
     * Gets the score of the person in the score position
     * @param position the position in the scores.txt file
     * @return int the score of the person in position
     */
    public int getScore(int position);

    /**
     * Sets the score to the desired value.
     * @param newScore the value to be set.
     */
    public void setCurrentScore(int newScore);

    /**
     * Adjusts the score by the desired value
     * @param points the amount of points to be added (negative values are okay).
     */
    public void adjustCurrentScore(int points);

}
