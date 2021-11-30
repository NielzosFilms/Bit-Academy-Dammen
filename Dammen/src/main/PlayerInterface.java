package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerInterface {
    private static final String INPUT_PATTERN = "([abcdefgh])([12345678])-([abcdefgh])([12345678])";

    private Scanner sc;
    private boolean currentPlayerIsPlayer1 = true;

    public PlayerInterface() {
        this.currentPlayerIsPlayer1 = true;
        this.sc = new Scanner(System.in);
    }

    public Move askAndGetMove() {
        String input = "";

        while (!input.matches(INPUT_PATTERN)) {
            System.out.println("⭐ Player " + getCurrentPlayer() + " (" + getPlayerColor() + ") define your move: (eg. \"a1-b2\")");
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

    public void swapPlayer() {
        currentPlayerIsPlayer1 = !currentPlayerIsPlayer1;
    }

    public Integer getCurrentPlayer() {
        return currentPlayerIsPlayer1 ? 1 : 2;
    }

    public boolean currentPlayerIsPlayer1() {
        return currentPlayerIsPlayer1;
    }

    public String getPlayerColor() {
        return currentPlayerIsPlayer1 ? "White" : "Black";
    }
}
