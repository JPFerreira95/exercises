package org.example.secondchapter.exercise;

import org.example.firstchapter.exercise.Design;

/**
 * Contains code that represent the counting process.
 * It will keep counting the number of votes each cake design is getting.
 */
public class CountingRunnable implements Runnable { // Step 3 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false;

    public CountingRunnable(Design d) {
        this.d = d;
    }

    // Step 4 - Override the run() method
    @Override
    public void run() {
        while (!doStop) {
            System.out.println("Design " + d.getName() + " has " + d.getVotes().size() + " votes");

            // Pause thread for 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
