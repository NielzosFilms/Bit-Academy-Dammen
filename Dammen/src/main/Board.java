package main;

import enums.COLORS;

import java.awt.*;
import java.util.HashMap;

public class Board {
    private static final Character[] COLUMN_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    private int width, height;

    HashMap<Point, Stone> cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        this.cells = new HashMap<>();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Point cell = new Point(x, y);
                Stone stone = null;

                COLORS bgColor = getBackgroundColor(cell);

                if(y < 3) {
                    if(bgColor == COLORS.DARK_GRAY_BG) {
                        stone = new Stone(COLORS.WHITE);
                    }
                } else if(y > 4) {
                    if(bgColor == COLORS.GRAY_BG) {
                        stone = new Stone(COLORS.BLACK);
                    }
                }

                this.cells.put(cell, stone);
            }
        }
    }

    public void printBoard() {
        for (int y = 0; y < this.height; y++) {
            StringBuilder row = new StringBuilder();
            row.append(COLORS.CYAN_BG.toString() + COLORS.BLACK + " " + (y + 1) + " " + COLORS.RESET);
            for (int x = 0; x < this.width; x++) {
                Point cell = new Point(x, y);
                Stone stone = this.cells.get(new Point(x, y));

                row.append(getBackgroundColor(cell).toString())
                        .append(stone != null ? " " + stone.toString() + " " : "   ")
                        .append(COLORS.RESET);
            }
            System.out.println(row.toString());
        }

        StringBuilder lastRow = new StringBuilder();
        lastRow.append("   " + COLORS.CYAN_BG + COLORS.BLACK);
        for(Character character : COLUMN_CHARS) {
            lastRow.append(" " + character + " ");
        }
        lastRow.append(COLORS.RESET);
        System.out.println(lastRow.toString());
    }

    private COLORS getBackgroundColor(Point position) {
        if (position.y % 2 == 0) {
            return position.x % 2 == 0 ? COLORS.GRAY_BG : COLORS.DARK_GRAY_BG;
        } else {
            return position.x % 2 != 0 ? COLORS.GRAY_BG : COLORS.DARK_GRAY_BG;
        }
    }
}
