package org.example.secondchapter.exercise;

import org.example.firstchapter.exercise.Design;

/**
 * Contains code that represents the voting process.
 * It will keep track of what cake designs are getting votes
 */
public class VotingRunnable implements Runnable {

    private Design d;
    protected boolean doStop = false;

    public VotingRunnable(Design d) {
        this.d = d;
    }

    // Step 2 - Override the run() method
    @Override
    public void run() {
        while (!doStop) {
            System.out.println("Voting going on for design: " + d.getName());
            d.getVotes().add(1L);

            // Generate a random number between 0 & 1000
            Double sleepFor = Math.random() * 1000;

            // 2 - Pause the thread for this random amount of time
            try {
                Thread.sleep(sleepFor.longValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
