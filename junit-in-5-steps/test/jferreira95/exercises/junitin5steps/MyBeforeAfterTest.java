package jferreira95.exercises.junitin5steps;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * JUnit does not guarantee order. Which is why this class is created.
 */
public class MyBeforeAfterTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @Test
    public void test3() {
        System.out.println("test 3");
    }
}
