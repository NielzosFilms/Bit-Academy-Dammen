package main;

import rules.*;

import java.util.LinkedList;

public class RuleChecker {

    private LinkedList<RuleCheckerInterface> rules;

    public RuleChecker() {
        this.rules = new LinkedList<>();
        this.rules.add(new IsMoveForward());
        this.rules.add(new IsMoveDiagonal());
        this.rules.add(new IsMove1Space());
        this.rules.add(new IsMoveOnBoard());
        this.rules.add(new IsMovingStone());
        this.rules.add(new CheckAttacks());
        this.rules.add(new IsMoveToEmpty());
    }

    public boolean isValidMove(Board board, Move move) {
        for(RuleCheckerInterface rule : this.rules) {
            if(!rule.check(board, move)) {
                System.out.println("❌ RuleChecker Failed on rule: " + rule.getClass().toString());
                return false;
            }
        }
        return true;
    }
}
