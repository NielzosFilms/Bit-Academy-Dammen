package main;

import enums.COLORS;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Board {
    private int width, height;

    HashMap<Point, Stone> cells;

    private int currentPlayer = 1;

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

                if (bgColor == COLORS.DARK_GRAY_BG) {
                    if (y < 4) {
                        stone = new Stone(COLORS.BLACK);
                    } else if (y > 5) {
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
            int rowNumber = this.height - y - 1;
            row.append(COLORS.CYAN_BG.toString() + COLORS.BLACK + " " + rowNumber + " " + COLORS.RESET);
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
        lastRow.append(COLORS.MAGENTA_BG + "   " + COLORS.CYAN_BG + COLORS.BLACK);
        for (Character character : Main.COLUMN_CHARS) {
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

    public void swapPlayer() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    public Integer getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean currentPlayerIsPlayer1() {
        return currentPlayer == 1;
    }

    public String getPlayerColor() {
        return this.currentPlayerIsPlayer1() ? "White" : "Black";
    }

    public LinkedList<Stone> getStonesFromCurrentPlayer() {
        LinkedList<Stone> playerStones = new LinkedList<>();
        for (Stone stone : this.cells.values()) {
            COLORS playerColor = this.currentPlayerIsPlayer1() ? COLORS.WHITE : COLORS.BLACK;
            if (stone != null && stone.getColor() == playerColor) playerStones.add(stone);
        }
        return playerStones;
    }

    public HashMap<Point, Stone> getCells() {
        return this.cells;
    }

    public boolean containsStone(Point cell) {
        return this.cells.get(cell) != null;
    }

    public boolean containsCell(Point cell) {
        return this.cells.containsKey(cell);
    }

    public Stone getStone(Point cell) {
        return this.cells.get(cell);
    }

    public Point getStonePosition(Stone stone) {
        for (Point cell : this.cells.keySet()) {
            if (this.cells.get(cell) == stone) {
                return cell;
            }
        }
        return null;
    }

    public COLORS getCurrentPlayerColor() {
        return this.currentPlayerIsPlayer1() ? COLORS.WHITE : COLORS.BLACK;
    }

    public void executeMove(Move move) {
        if (this.containsStone(move.getTo())) {
            int xDiff = move.getTo().x - move.getFrom().x;
            int yDiff = move.getTo().y - move.getFrom().y;

            Point offsetCell = new Point(move.getTo().x + xDiff, move.getTo().y + yDiff);

            Stone stone = this.getStone(move.getFrom());
            this.cells.put(move.getFrom(), null);
            this.cells.put(move.getTo(), null);
            this.cells.put(offsetCell, stone);
        } else {
            Stone stone = this.getStone(move.getFrom());
            this.cells.put(move.getFrom(), null);
            this.cells.put(move.getTo(), stone);
        }
    }
}
