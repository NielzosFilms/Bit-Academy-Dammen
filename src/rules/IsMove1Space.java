package rules;

import main.Board;
import main.Move;

public class IsMove1Space implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        int xDiff = Math.abs(move.getFrom().x - move.getTo().x);
        int yDiff = Math.abs(move.getFrom().y - move.getTo().y);
        return xDiff == 1 && yDiff == 1;
    }
}
