package org.jpferreira.battleship;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MainEndToEndTest {
    @ClassRule
    public static final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @ClassRule
    public static final TextFromStandardInputStream gameInput = emptyStandardInputStream();

    @Test
    public void testPlayGameShotHits() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b4");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Yeah ! Nice hit !"));
        }
    }

    @Test
    public void testPlayGameWithRowLesserThanZero() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b0");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Input is not valid. Keep it between 1 and 8"));
        }
    }

    @Test
    public void testPlayGameWithRowBiggerThan8() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b9");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Input is not valid. Keep it between 1 and 8"));
        }
    }

    @Test
    public void testPlayGameWithWrongLetter() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "i1");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Input is not valid. Keep it between 1 and 8"));
        }
    }

    @Test
    public void testPlayGameShotMisses() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "e4");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Miss"));
        }
    }

    @Test
    public void testPlayGameWithWrongInputs() {
        try {
            gameInput.provideLines("a1", "a2", "a3", "a5", "a4", "a5", "a1", "b1", "b2", "b3", "b4", "e4");

            Main.main(new String[]{});
        } catch(NoSuchElementException e) {
            Assert.assertTrue(systemOutRule.getLog().contains("Welcome to Battleship"));
            Assert.assertTrue(systemOutRule.getLog().contains("Miss"));
        }
    }
}
