package enums;

public enum COLORS {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    WHITE("\u001B[97m"),
    CYAN_BG("\u001B[46m"),
    MAGENTA_BG("\u001B[105m"),
    GRAY_BG("\u001B[47m"),
    DARK_GRAY_BG("\u001B[100m");


    public String ansiCode;

    COLORS(String ansiCode) {this.ansiCode = ansiCode;}

    @Override
    public String toString() { return this.ansiCode; }
}
