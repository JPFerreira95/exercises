package org.jpferreira.battleship;


import org.jpferreira.battleship.dto.Color;
import org.jpferreira.battleship.dto.Letter;
import org.jpferreira.battleship.dto.Position;
import org.jpferreira.battleship.dto.Ship;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameController {
    public static boolean checkIsHit(Collection<Ship> ships, Position shot) {
        if (ships == null) {
            throw new IllegalArgumentException("ships is null");
        }

        if (shot == null) {
            throw new IllegalArgumentException("shot is null");
        }

        for (Ship ship : ships) {
            boolean isHit = ship.checkHit(shot);
            if(isHit) {
                return true;
            }
        }

        return false;
    }

    public static List<Ship> initializeShips() {
        return Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE),
                new Ship("Battleship", 4, Color.RED));
    }

    public static boolean isShipValid(Ship ship) {
        return ship.getPositions().size() == ship.getSize();
    }

    public static Position getRandomPosition(int size) {
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(size)];
        int number = random.nextInt(size);
        Position position = new Position(letter, number);
        return position;
    }
}
