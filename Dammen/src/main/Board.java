package main;

import enums.COLORS;

import java.awt.*;
import java.util.HashMap;

public class Board {
    private int width, height;

    HashMap<Point, Stone> cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        this.cells = new HashMap<>();
        initBoard();
    }

    private void initBoard() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Point cell = new Point(x, y);
                Stone stone = null;

                COLORS bgColor = getBackgroundColor(cell);

                if(bgColor == COLORS.DARK_GRAY_BG) {
                    if(y < 4) {
                        stone = new Stone(COLORS.BLACK);
                    } else if(y > 5) {
                        stone = new Stone(COLORS.WHITE);
                    }
                }

                this.cells.put(cell, stone);
            }
        }
    }

    public void printBoard() {
        for (int y = 0; y < this.height; y++) {
            StringBuilder row = new StringBuilder();
            int rowNumber = this.height - y;
            row.append(COLORS.CYAN_BG.toString() + COLORS.BLACK + " " + rowNumber + (rowNumber < 10 ? "  " : " ") + COLORS.RESET);
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
        lastRow.append(COLORS.MAGENTA_BG + "    " + COLORS.CYAN_BG + COLORS.BLACK);
        for(Character character : Main.COLUMN_CHARS) {
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
