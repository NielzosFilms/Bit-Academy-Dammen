package enums;

public enum COLORS {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    WHITE("\u001B[1;37m"),
    GRAY("\u001B[37m"),
    CYAN_BG("\u001B[46m"),
    WHITE_BG("\u001B[1;47m"),
    BLACK_BG("\u001B[40m"),
    GRAY_BG("\u001B[47m");


    public String ansiCode;

    COLORS(String ansiCode) {this.ansiCode = ansiCode;}

    @Override
    public String toString() { return this.ansiCode; }
}
