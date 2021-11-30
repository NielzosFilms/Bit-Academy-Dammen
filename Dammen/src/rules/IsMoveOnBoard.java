package rules;

import main.Board;
import main.Move;

public class IsMoveOnBoard implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        return board.containsCell(move.getFrom()) && board.containsCell(move.getTo());
    }
}
