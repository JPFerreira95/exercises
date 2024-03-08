package jferreira95.exercises.junitin5steps;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    public void test() {
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");

        assertTrue(test); // assertTrue(true, test)
        assertTrue(test, "Flag is not true");
        assertFalse(test2);

        assertEquals(3, todos.size());
        assertEquals(3, todos.size(), "Invalid list size");

        // assertNull, assertNotNull
        assertArrayEquals(new int[] {1,2}, new int[] {1,2});
    }
}
