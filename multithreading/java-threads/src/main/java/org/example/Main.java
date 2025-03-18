package org.example;

import org.example.secondchapter.exercise.SecondChapterExercise;
import org.example.secondchapter.waitforthreads.Average;
import org.example.secondchapter.waitforthreads.Marks;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Try first chapter
        //FirstChapter.execute();

        // Try second chapter
        //SecondChapter.execute();

        // Wait for threads
        //waitForThreads();

        // Second chapter exercise
        SecondChapterExercise.execute();
    }

    private static void waitForThreads() {
        int[] marks = new int[10];
        Thread marksThread = new Thread(new Marks(marks));
        Thread avgThread = new Thread(new Average(marks)); // This is the main thread because it needs to wait for the marksThread to finish before running its task
        marksThread.start();
        try {
            marksThread.join(); // With this join only after the marksThread finishes its task, is when the avgThread will execute its task
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        avgThread.start();

    }

}