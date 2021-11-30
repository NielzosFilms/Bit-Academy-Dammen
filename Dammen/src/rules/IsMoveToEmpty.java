package rules;

import main.Board;
import main.Move;

public class IsMoveToEmpty implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        return !board.containsStone(move.getTo());
    }
}
