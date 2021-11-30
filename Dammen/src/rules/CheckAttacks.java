package rules;

import enums.COLORS;
import main.Board;
import main.Move;
import main.Stone;

import java.awt.*;
import java.util.LinkedList;

public class CheckAttacks implements RuleCheckerInterface {
    private static final Point[] PLAYER1_OFFSETS = {
            new Point(1, -1),
            new Point(-1, -1),
    };

    private static final Point[] PLAYER2_OFFSETS = {
            new Point(1, 1),
            new Point(-1, 1),
    };
    private COLORS currentPlayerColor;

    @Override
    public boolean check(Board board, Move move) {
        this.currentPlayerColor = board.getCurrentPlayerColor();

        if(isPlayerAttacking(board, move)) {
            return isValidAttack(board, move);
        } else {
            return !canPlayerAttack(board);
        }
    }

    private boolean isPlayerAttacking(Board board, Move move) {
        return board.containsStone(move.getTo()) && board.getStone(move.getTo()).getColor() != this.currentPlayerColor;
    }

    private boolean isValidAttack(Board board, Move move) {
        int xDiff = move.getTo().x - move.getFrom().x;
        int yDiff = move.getTo().y - move.getFrom().y;

        Point offsetCell = new Point(move.getTo().x + xDiff, move.getTo().y + yDiff);

        return board.containsCell(offsetCell) && !board.containsStone(offsetCell);
    }

    private boolean canPlayerAttack(Board board) {
        LinkedList<Stone> playerStones = board.getStonesFromCurrentPlayer();
        for (Stone stone : playerStones) {
            Point cell = board.getStonePosition(stone);
            Point[] playerOffsets = board.currentPlayerIsPlayer1() ? PLAYER1_OFFSETS : PLAYER2_OFFSETS;
            for (Point offset : playerOffsets) {
                Point offset1 = new Point(cell.x + offset.x, cell.y + offset.y);
                Point offset2 = new Point(cell.x + offset.x * 2, cell.y + offset.y * 2);

                if (board.containsCell(offset1) && board.containsCell(offset2)) {
                    if (board.containsStone(offset1) && !board.containsStone(offset2)) {
                        if (board.getStone(offset1).getColor() != this.currentPlayerColor) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
