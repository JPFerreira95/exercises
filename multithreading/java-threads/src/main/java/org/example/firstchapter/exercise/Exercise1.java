package org.example.firstchapter.exercise;

public class Exercise1 {

    public static void execute() {
        /*
         * Design 1
         */
        Design d1 = new Design(1, "D1");

        // Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnableD1 = new VotingRunnable(d1);
        CountingRunnable countingRunnableD1 = new CountingRunnable(d1);

        // Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for the Thread constructor
        Thread votingD1 = new Thread(votingRunnableD1);

        // Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for the Thread constructor
        Thread countingD1 = new Thread(countingRunnableD1);

        // Step 7.1 - Start voting thread for design1
        votingD1.start();

        // Step 7.2 - Start counting thread for design1
        countingD1.start();

        /*
         * Design 2
         */
        Design d2 = new Design(2, "D2");

        // Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnableD2 = new VotingRunnable(d2);
        CountingRunnable countingRunnableD2 = new CountingRunnable(d2);

        // Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for the Thread constructor
        Thread votingD2 = new Thread(votingRunnableD2);

        // Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for the Thread constructor
        Thread countingD2 = new Thread(countingRunnableD2);

        // Step 7.1 - Start voting thread for design1
        votingD2.start();

        // Step 7.2 - Start counting thread for design1
        countingD2.start();

        /*
         * Design 3
         */
        Design d3 = new Design(3, "D3");

        // Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnableD3 = new VotingRunnable(d3);
        CountingRunnable countingRunnableD3 = new CountingRunnable(d3);

        // Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for the Thread constructor
        Thread votingD3 = new Thread(votingRunnableD3);

        // Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for the Thread constructor
        Thread countingD3 = new Thread(countingRunnableD3);

        // Step 7.1 - Start voting thread for design1
        votingD3.start();

        // Step 7.2 - Start counting thread for design1
        countingD3.start();
    }
}
