package com.company;

//The method hopDistance() is implemented for you and the main in right in the class to make it simpler.
public class FrogSimulation
{
    public int[] testHops;
    int nextHopIndex;

    /** Distance, in inches, from the starting position to the goal. */
    private int goalDistance;

    /** Maximum number of hops allowed to reach the goal. */
    private int maxHops;

    /** Constructs a FrogSimulation where dist is the distance, in inches, from the starting
     * position to the goal, and numHops is the maximum number of hops allowed to reach the goal.
     * Precondition: dist > 0; numHops > 0
     */
    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    /** Returns an integer representing the distance, in inches, to be moved when the frog hops.
     */
    private int hopDistance()
    {
        int hop = testHops[nextHopIndex];
        nextHopIndex++;
        if (nextHopIndex >= testHops.length)
            nextHopIndex = 0;

        return hop;
    }

/********************** Part (a) *************************/

    /** Simulates a frog attempting to reach the goal as described in part (a).
     * Returns true if the frog successfully reached or passed the goal during the simulation;
     * false otherwise.
     */
    public boolean simulate()
    {
        int hops = 0;
        for (int i = 0; i < maxHops; i++)
        {
            hops = hops + hopDistance();
            if (hops >= goalDistance)
            {
                return true;
            }
            if (hops < 0)
            {
                return false;
            }
        }
        return false;
    }

/********************** Part (b) *************************/

    /** Runs num simulations and returns the proportion of simulations in which the frog
     * successfully reached or passed the goal.
     * Precondition: num > 0
     */
    public double runSimulations(int num)
    {
        int number = 0;
        for (int x = 0; x<num; x++)
        {
            boolean y = simulate();
            if (y == true)
            {
                number++;
            }
        }
        return number/num;
    }
}