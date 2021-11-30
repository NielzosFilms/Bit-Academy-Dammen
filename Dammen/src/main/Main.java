package main;

import enums.COLORS;

import java.util.Scanner;

public class Main {

    private static final int BOARD_WIDTH = 12, BOARD_HEIGHT = 12;

    private static Board board;

    private static void init() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
    }

    public static void main(String[] args) {
        init();

        board.printBoard();
//        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
//        System.out.print("Enter first number- ");
//        int a = sc.nextInt();
//        System.out.print("Enter second number- ");
//        int b = sc.nextInt();
//        System.out.print("Enter third number- ");
//        int c = sc.nextInt();
//        int d = a + b + c;
//        System.out.println("Total= " + d);
    }
}
