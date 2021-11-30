package rules;

import main.Board;
import main.Move;

public class IsMoveForward implements RuleCheckerInterface {
    @Override
    public boolean check(Board board, Move move) {
        if(board.currentPlayerIsPlayer1()) {
            return move.getFrom().y > move.getTo().y;
        } else {
            return move.getFrom().y < move.getTo().y;
        }
    }
}
