package org.example.secondchapter;

public class SecondChapter {

    public static void execute() {
        Thread taskThread = new Thread(new MyRunnable());
        taskThread.start();
//        sleep(3000);
        taskThread.interrupt(); // It will cause the sleep on "MyRunnable" to throw an InterruptedException
        sleep(3000);
        System.out.println(taskThread.isInterrupted());
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
