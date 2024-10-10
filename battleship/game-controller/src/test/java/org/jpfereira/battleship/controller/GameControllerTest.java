package org.jpfereira.battleship.controller;

import org.jpferreira.battleship.GameController;
import org.junit.Assert;
import org.junit.Test;
import org.jpferreira.battleship.dto.Letter;
import org.jpferreira.battleship.dto.Position;
import org.jpferreira.battleship.dto.Ship;

import java.util.Arrays;
import java.util.List;

public class GameControllerTest {
    @Test
    public void testCheckIsHitTrue() {
        List<Ship> ships = GameController.initializeShips();
        int counter = 0;

        for (Ship ship : ships) {
            Letter letter = Letter.values()[counter];

            for (int i = 0; i < ship.getSize(); i++) {
                ship.getPositions().add(new Position(letter, i + 1));
            }

            counter++;
        }

        boolean result = GameController.checkIsHit(ships, new Position(Letter.A, 1));

        Assert.assertTrue(result);
    }

    @Test
    public void testCheckIsHitFalse() {
        List<Ship> ships = GameController.initializeShips();
        int counter = 0;

        for (Ship ship : ships) {
            Letter letter = Letter.values()[counter];

            for (int i = 0; i < ship.getSize(); i++) {
                ship.getPositions().add(new Position(letter, i + 1));
            }

            counter++;
        }

        boolean result = GameController.checkIsHit(ships, new Position(Letter.H, 1));

        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsHitPositstionIsNull() {
        GameController.checkIsHit(GameController.initializeShips(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsHitShipIsNull() {
        GameController.checkIsHit(null, new Position(Letter.H, 1));
    }

    @Test
    public void testIsShipValidFalse() {
        Ship ship = new Ship("TestShip", 3);
        boolean result = GameController.isShipValid(ship);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsShipValidTrue() {
        List<Position> positions = Arrays.asList(new Position(Letter.A, 1), new Position(Letter.A, 1), new Position(Letter.A, 1));
        Ship ship = new Ship("TestShip", 3, positions);

        boolean result = GameController.isShipValid(ship);

        Assert.assertTrue(result);
    }

}
