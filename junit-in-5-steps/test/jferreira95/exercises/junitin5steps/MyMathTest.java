package jferreira95.exercises.junitin5steps;

import static org.junit.jupiter.api.Assertions.*;

import jpferreira95.exercises.junitin5steps.MyMath;
import org.junit.jupiter.api.Test;

/**
 * JUnit does not guarantee order
 */
public class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        assertEquals(6, math.calculateSum(new int[] {1, 2, 3}));
    }

    @Test
    void calculateSum_EmptyArray() {
        assertEquals(0, math.calculateSum(new int[] {}));
    }

}
