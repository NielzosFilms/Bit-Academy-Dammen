package main;

import enums.COLORS;

public class Stone {
    private static String icon = "o";

    private COLORS color;

    public Stone(COLORS color) {
        this.color = color;
    }

    public COLORS getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.color.toString() + icon;
    }
}
