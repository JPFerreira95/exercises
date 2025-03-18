package org.example.firstchapter;

/**
 * Create a new thread class by implementing Runnable interface
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
