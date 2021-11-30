package rules;

import main.Board;
import main.Move;

public interface RuleCheckerInterface {
    boolean check(Board board, Move move);
}
