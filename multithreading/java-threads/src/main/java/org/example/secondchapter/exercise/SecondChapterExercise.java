package org.example.secondchapter.exercise;

import org.example.firstchapter.exercise.Design;

/**
 * <p>Complete the voting system</p>
 *
 * 1 - Change the VotingRunnable to simulate votes coming in at random intervals
 * 2 - Pause the thread for a random amount of time (0-1000 milliseconds)
 * 3 - Change the CountingRunnable so that the counting of votes happens every two seconds
 * 4 - Voting and counting tasks should stop after 30 seconds
 * 5 - A Boolean flag with a default value of false is used in the runnable class for stopping the tasks
 * 6 - Main thread should pause for 30 seconds to let the voting and counting threads execute
 * 7 - At the end of 30 seconds, the flag should be set to true for all tasks (runnables)
 * 8 - Print the total number of votes obtained by all three designs
 */
public class SecondChapterExercise {

    public static void execute() {
        /*
         * Design 1
         */
        Design d1 = new Design(1, "D1");
        VotingRunnable votingRunnableD1 = new VotingRunnable(d1);
        CountingRunnable countingRunnableD1 = new CountingRunnable(d1);

        Thread votingD1 = new Thread(votingRunnableD1);
        Thread countingD1 = new Thread(countingRunnableD1);

        votingD1.start();
        countingD1.start();

        /*
         * Design 2
         */
        Design d2 = new Design(2, "D2");
        VotingRunnable votingRunnableD2 = new VotingRunnable(d2);
        CountingRunnable countingRunnableD2 = new CountingRunnable(d2);

        Thread votingD2 = new Thread(votingRunnableD2);
        Thread countingD2 = new Thread(countingRunnableD2);

        votingD2.start();
        countingD2.start();

        /*
         * Design 3
         */
        Design d3 = new Design(3, "D3");
        VotingRunnable votingRunnableD3 = new VotingRunnable(d3);
        CountingRunnable countingRunnableD3 = new CountingRunnable(d3);

        Thread votingD3 = new Thread(votingRunnableD3);
        Thread countingD3 = new Thread(countingRunnableD3);

        votingD3.start();
        countingD3.start();

        // Pause the main thread for 30 seconds
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // At the end of 30 seconds all threads should be stopped.
        votingRunnableD1.doStop = true;
        votingRunnableD2.doStop = true;
        votingRunnableD3.doStop = true;
        countingRunnableD1.doStop = true;
        countingRunnableD2.doStop = true;
        countingRunnableD3.doStop = true;

        System.out.println("Voting has stopped for design " + d1.getName());
        System.out.println("Total votes for " + d1.getName() + ": " + d1.getVotes().size());
        System.out.println("Voting has stopped for design " + d2.getName());
        System.out.println("Total votes for " + d2.getName() + ": " + d2.getVotes().size());
        System.out.println("Voting has stopped for design " + d3.getName());
        System.out.println("Total votes for " + d3.getName() + ": " + d3.getVotes().size());
    }
}
