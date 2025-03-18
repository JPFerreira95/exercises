package org.example.secondchapter;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
//         handleInterruptedException();
        handleInterruptWithStaticMethod();
    }

    private void handleInterruptedException() {
        for (int i = 1; i <=100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());
                // When getting an InterruptedException we can simply terminate the loop by using break statement
                // This is how an interruption request is handled in most cases
                break;
            }
        }
    }

    private void handleInterruptWithStaticMethod() {
        for (int i = 1; i <=100; i++) {
            System.out.println(i);

            if (Thread.interrupted()) {
                break;
            }
        }
    }
}
