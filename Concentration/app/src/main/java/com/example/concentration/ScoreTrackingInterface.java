package com.example.concentration;

public interface ScoreTrackingInterface {

    /**
     * Gets the name of the person in the score position
     * @param position the position in the scores.txt file
     * @return String the name of the person in position
     */
    public String getName();

    /**
     * Gets the name of the person in the score position
     * @param newName the position in the scores.txt file
     * @return String the name of the person in position
     */
    public void setName(String newName);

    /**
     * Gets the score of the person in the score position
     * @param position the position in the score file
     * @return int the score of the person in position
     */
    public int getScore();

    /**
     * Sets the score to the desired value.
     * @param newScore the value to be set.
     */
    public void setScore(int newScore);

    /**
     * Adjusts the score by the desired value
     * @param points the amount of points to be added (negative values are okay).
     */
    public void addScore(int points);
}
