package enums;

public enum COLORS {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    WHITE("\u001B[97m"),
    GRAY("\u001B[37m"),
    DARK_GRAY("\u001B[90m"),
    CYAN_BG("\u001B[46m"),
    WHITE_BG("\u001B[107m"),
    BLACK_BG("\u001B[40m"),
    GRAY_BG("\u001B[47m"),
    DARK_GRAY_BG("\u001B[100m");


    public String ansiCode;

    COLORS(String ansiCode) {this.ansiCode = ansiCode;}

    @Override
    public String toString() { return this.ansiCode; }
}
