package com.jpferreira95.advanced.threads.and.concurrency.firstchapter;

public class Synchronization {

    public static void exec() {
        //step1();
        step2();
    }

    /**
     * Step 1: Each thread has its own runnable instance. This means that both have their own reference variables in each thread stack.
     * Each object will be stored in the heap.
     * <p>
     * They run in separate ways, so and don't share anything so we will see the i variable printing the same numbers twice in the console
     * because both threads are running at the same time with their own thread stacks.
     */
    private static void step1() {
        MyRunnable myRunnable1 = new MyRunnable();
        // Reference variable myRunnable1 in thread stack of Thread1
        Thread thread1 = new Thread(myRunnable1, "Thread1");

        MyRunnable myRunnable2 = new MyRunnable();
        // Reference variable myRunnable2 in thread stack of Thread2
        Thread thread2 = new Thread(myRunnable2, "Thread2");

        thread1.start();
        thread2.start();
    }

    /**
     * Step 2: With just one Runnable object and both threads sharing the same variable object present in the heap.
     * However, they'll reference it using their own reference variables in their respective thread stacks.
     * With this approach they will be attempting to do the same thing at the same time. This will cause a Data Race.
     * <p>
     * The expected result should be 2Million, but since there are data races happening, it won't get there.
     */
    private static void step2() {
        CounterRunnable myRunnable = new CounterRunnable();

        Thread thread1 = new Thread(myRunnable, "Thread1");
        Thread thread2 = new Thread(myRunnable, "Thread2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myRunnable.getCounter());
    }

}
