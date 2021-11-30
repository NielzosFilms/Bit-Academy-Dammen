package main;

import enums.COLORS;

import java.util.Scanner;

public class Main {
    public static final Character[] COLUMN_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static final int BOARD_WIDTH = 10, BOARD_HEIGHT = 10;

    private static Board board;
    private static PlayerInterface playerInterface;

    private static void init() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        playerInterface = new PlayerInterface();
    }

    public static void main(String[] args) {
        init();

        board.printBoard();
        System.out.println(playerInterface.askAndGetMove());
    }
}
