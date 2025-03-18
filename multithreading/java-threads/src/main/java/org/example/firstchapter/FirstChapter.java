package org.example.firstchapter;

public class FirstChapter {

    public static void execute() {

        // print thread name
        // threadName();

        // create multiple threads
        //creatingThreads();

        // Exercise 1
        //Exercise1.execute();

        // Pause a thread
        pauseThread();

    }

    private static void threadName() {
        // Since we are in the "main" java method, it will print the main java thread name
        System.out.println(Thread.currentThread().getName());
    }

    private static void creatingThreads() {
        // Create multiple threads using FirstThread class
        for (int count = 1; count <= 3; count++) {
            FirstThread thread1 = new FirstThread(count);
            thread1.start();
        }

        // Create a new thread with MyRunnable class
        MyRunnable runnable1 = new MyRunnable();
        Thread thread = new Thread(runnable1);
        thread.start();
    }

    private static void pauseThread() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Main thread is printing " + i);
            if (i == 5) {
                System.out.println("Main thread is pausing for 2 seconds");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
