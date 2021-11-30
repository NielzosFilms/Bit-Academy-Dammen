package rules;

import main.Board;
import main.Move;

public class IsMoveToEmpty implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        return !board.containsStone(move.getTo()) ||
                (board.containsStone(move.getTo()) && board.getStone(move.getTo()).getColor() != board.getCurrentPlayerColor());
    }
}
