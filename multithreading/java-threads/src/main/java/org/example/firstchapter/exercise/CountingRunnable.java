package org.example.firstchapter.exercise;

public class CountingRunnable implements Runnable { // Step 3 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false;

    public CountingRunnable(Design d) {
        this.d = d;
    }

    // Step 4 - Override the run() method
    @Override
    public void run() {
        System.out.println("Design " + d.getName() + " has " + d.getVotes().size() + " votes");
    }
}
