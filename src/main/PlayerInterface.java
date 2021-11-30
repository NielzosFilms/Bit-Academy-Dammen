package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerInterface {
    private static final String INPUT_PATTERN = "([abcdefghij])([0123456789])-([abcdefghij])([0123456789])";

    private Scanner sc;
    private Board board;

    public PlayerInterface(Board board) {
        this.sc = new Scanner(System.in);
        this.board = board;
    }

    public Move askAndGetMove() {
        String input = "";

        while (!input.matches(INPUT_PATTERN)) {
            System.out.println("⭐ Player " + board.getCurrentPlayer() + " (" + board.getPlayerColor() + ") define your move: (eg. \"a1-b2\")");
            input = sc.next().toLowerCase();
            if (!input.matches(INPUT_PATTERN)) System.out.println("❌ This is not a valid input.");
        }

        return getMoveFromInput(input);
    }

    private Move getMoveFromInput(String input) {
        Pattern pattern = Pattern.compile(INPUT_PATTERN);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        return new Move(
                matcher.group(1).toCharArray()[0],
                Integer.parseInt(matcher.group(2)),
                matcher.group(3).toCharArray()[0],
                Integer.parseInt(matcher.group(4))
        );
    }
}
