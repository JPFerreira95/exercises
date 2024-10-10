package org.jpferreira.battleship.dto;

public class Position {
    private Letter column;
    private int row;

    public Position() {
        super();
    }

    public Position(Letter column, int row) {
        this();

        if (!isRowValid(row)) {
            throw new IllegalArgumentException();
        }

        this.column = column;
        this.row = row;
    }

    public Letter getColumn() {
        return column;
    }

    public void setColumn(Letter column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override public boolean equals(Object o) {
        if(o instanceof Position) {
            Position position = (Position) o;

            if(position == null) {
                return false;
            }

            return position.column.equals(column) && position.row == row;
        }

        return false;
    }

    private static boolean isRowValid(int row) {
        return row >=1 && row <=8;
    }
}
