package main;

import java.awt.*;
import java.util.Arrays;

public class Move {
    private Character fromChar, toChar;
    private int fromRow, toRow;
    private Point fromPos, toPos;

    public Move(Character fromChar, int fromRow, Character toChar, int toRow) {
        this.fromChar = fromChar;
        this.toChar = toChar;
        this.fromRow = fromRow;
        this.toRow = toRow;

        this.fromPos = getPosition(this.fromChar, this.fromRow);
        this.toPos = getPosition(this.toChar, this.toRow);
    }

    private Point getPosition(Character character, int row) {
        int y = Math.abs(row - Main.BOARD_HEIGHT);
        int x = -1;
        for(int i = 0; i < Main.COLUMN_CHARS.length; i++) {
            Character colChar = Main.COLUMN_CHARS[i];
            if(colChar.toString().toLowerCase().equals(character.toString())) {
                x = i;
                break;
            }
        }
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return fromPos.toString() + " to " + toPos.toString();
    }
}
