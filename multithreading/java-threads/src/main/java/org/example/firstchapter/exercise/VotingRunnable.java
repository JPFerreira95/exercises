package org.example.firstchapter.exercise;

public class VotingRunnable implements Runnable{ // Step 1 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false;

    public VotingRunnable(Design d) {
        this.d = d;
    }

    // Step 2 - Override the run() method
    @Override
    public void run() {
        System.out.println("Voting going on for design " + d.getName());
        d.getVotes().add(1L);
    }
}
