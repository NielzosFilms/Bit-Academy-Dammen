package rules;

import main.Board;
import main.Move;

public class IsMoveDiagonal implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        int xDiff = Math.abs(move.getFrom().x - move.getTo().x);
        int yDiff = Math.abs(move.getFrom().y - move.getTo().y);
        return xDiff == yDiff;
    }
}
