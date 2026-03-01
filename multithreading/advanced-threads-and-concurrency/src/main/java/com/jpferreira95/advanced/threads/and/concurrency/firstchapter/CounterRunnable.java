package com.jpferreira95.advanced.threads.and.concurrency.firstchapter;

class CounterRunnable implements Runnable {
    private int counter;

    public int getCounter() {
        return this.counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
    }
}
