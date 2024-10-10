package org.jpferreira.battleship.dto;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private boolean isPlaced;
    private String name;
    private int size;
    private List<Position> positions;
    private Color color;
    private Orientation orientation;
    private List<Position> hitPositions = new ArrayList<>(size);
    private boolean isDestroyed = false;

    public Ship() {
        this.positions = new ArrayList<>();
    }

    public Ship(String name, int size) {
        this();

        this.name = name;
        this.size = size;
        this.isPlaced = false;
    }

    public Ship(String name, int size, List<Position> positions) {
        this(name, size);

        this.positions = positions;
    }

    public Ship(String name, int size, Color color) {
        this(name, size);

        this.color = color;
    }

    public Position addPosition(String input) {

        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));

        Position targetPosition = new Position(letter, number);

        if (positions == null) {
            positions = new ArrayList<>();
        } else {
            this.validateSequentialPosition(targetPosition);
        }

        positions.add(targetPosition);
        return targetPosition;
    }

    // TODO: property change listener implementer

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void validateSequentialPosition(Position targetPosition) {

        if (positions.isEmpty()) {
            return;
        }

        Position lastPosition = positions.get(positions.size() - 1);

        if (lastPosition.getColumn().ordinal() == targetPosition.getColumn().ordinal() && lastPosition.getRow() != targetPosition.getRow()) {
            throw new IllegalArgumentException("Invalid position. Please try again.");
        }

        if (positions.size() == 1) {

            if (lastPosition.getColumn().ordinal() == targetPosition.getColumn().ordinal() &&
                    (lastPosition.getRow() == targetPosition.getRow() - 1 ||
                            lastPosition.getRow() == targetPosition.getRow() + 1)) {
                orientation = Orientation.VERTICAL;
                return;
            }

            if (lastPosition.getRow() == targetPosition.getRow() &&
                    (lastPosition.getColumn().ordinal() == targetPosition.getColumn().ordinal() - 1 ||
                            lastPosition.getColumn().ordinal() == targetPosition.getColumn().ordinal() + 1)) {
                orientation = Orientation.HORIZONTAL;
                return;
            }

        } else {
            if (orientation == Orientation.HORIZONTAL) {

                // check if the row is the same
                if (lastPosition.getRow() != targetPosition.getRow()) {
                    throw new IllegalArgumentException("Invalid position. Please try again.");
                }

                // Check if the column is sequential with existing positions
                Letter minLetter = getMinColumn();
                Letter maxLetter = getMaxColumn();
                if (targetPosition.getColumn().ordinal() == minLetter.ordinal() - 1 || targetPosition.getColumn().ordinal() == maxLetter.ordinal() + 1) {
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid position. Please try again.");
                }


            } else {

                // check if the column is the same
                if (lastPosition.getColumn().ordinal() != targetPosition.getColumn().ordinal()) {
                    throw new IllegalArgumentException("Invalid position. Please try again.");
                }

                // Check if the column is sequential with existing positions
                int minRow = getMinRow();
                int maxRow = getMaxRow();
                if (targetPosition.getRow() == minRow - 1 || targetPosition.getRow() == maxRow + 1) {
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid position. Please try again.");
                }
            }
        }

        throw new IllegalArgumentException("Invalid position. Please try again.");
    }

    private int getMinRow() {
        return positions.stream().mapToInt(Position::getRow).min().getAsInt();
    }

    private int getMaxRow() {
        return positions.stream().mapToInt(Position::getRow).max().getAsInt();
    }

    private Letter getMinColumn() {
        Letter minLetter = positions.get(0).getColumn();

        for(int i = 1; i < positions.size(); i++) {
            if(positions.get(i).getColumn().ordinal() < minLetter.ordinal()) {
                minLetter = positions.get(i).getColumn();
            }
        }

        return minLetter;
    }

    private Letter getMaxColumn() {
        Letter maxLetter = positions.get(0).getColumn();

        for(int i = 1; i < positions.size(); i++) {
            if(positions.get(i).getColumn().ordinal() > maxLetter.ordinal()) {
                maxLetter = positions.get(i).getColumn();
            }
        }

        return maxLetter;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public boolean checkHit(Position shot) {
        for (Position position : this.getPositions()) {
            if (position.equals(shot)) {
                addHitPosition(shot);

                if (hitPositions.size() == size) {
                    isDestroyed = true;

                    System.out.println("Ship " + name + " is destroyed!");
                }

                return true;
            }
        }
        return false;
    }

    private void addHitPosition(Position shot) {

        if(hitPositions.isEmpty()) {
            hitPositions.add(shot);
            return;
        }

        for (Position p : hitPositions) {
            if (!p.equals(shot)) {
                hitPositions.add(p);
                return;
            }
        }
    }
}
