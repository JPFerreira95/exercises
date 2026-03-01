package com.jpferreira95.advanced.threads.and.concurrency.firstchapter;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        // This variable i it's stored in its thread stack
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
