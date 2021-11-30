package main;

import java.awt.*;

public class Main {
    public static final Character[] COLUMN_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static final int BOARD_WIDTH = 10, BOARD_HEIGHT = 10;
    public static final Point[] PLAYER1_MOVE_OFFSETS = {
            new Point(1, -1),
            new Point(-1, -1),
    };

    public static final Point[] PLAYER2_MOVE_OFFSETS = {
            new Point(1, 1),
            new Point(-1, 1),
    };

    private static Board board;
    private static PlayerInterface playerInterface;
    private static RuleChecker ruleChecker;

    private static boolean running = true;

    private static void init() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        playerInterface = new PlayerInterface(board);
        ruleChecker = new RuleChecker();
    }

    public static void main(String[] args) {
        init();

        board.printBoard();
        while(running) {
            Move move = playerInterface.askAndGetMove();
            boolean validMove = ruleChecker.isValidMove(board, move, false);
            if(validMove) {
                System.out.println("✔ Is valid move");
                board.executeMove(move);
                board.swapPlayer();
                board.printBoard();
            } else {
                System.out.println("❌ Move is not valid");
            }
            handleWins();
        }
    }

    public static void handleWins() {
        boolean canPlayer1Move = board.canPlayerMove(1, ruleChecker);
        boolean canPlayer2Move = board.canPlayerMove(2, ruleChecker);

        if(!canPlayer1Move || !canPlayer2Move) {
            if(!canPlayer1Move && !canPlayer2Move) {
                System.out.println("Its a draw!");
            } else if(!canPlayer2Move) {
                System.out.println("Player 1 (White) has won!");
            } else {
                System.out.println("Player 2 (Black) has won!");
            }
            running = false;
            System.out.println("Game over!");
        }
    }
}
