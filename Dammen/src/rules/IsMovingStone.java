package rules;

import main.Board;
import main.Move;

public class IsMovingStone implements RuleCheckerInterface {

    @Override
    public boolean check(Board board, Move move) {
        return board.containsStone(move.getFrom());
    }
}
