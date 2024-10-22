package org.jpferreira.battleship.utils.printer.color;

public enum BackgroundColor {

    // Background
    BLACK("\033[40m"),   // BLACK
    RED("\033[41m"),     // RED
    GREEN("\033[42m"),   // GREEN
    YELLOW("\033[43m"),  // YELLOW
    BLUE("\033[44m"),    // BLUE
    MAGENTA("\033[45m"), // MAGENTA
    CYAN("\033[46m"),    // CYAN
    WHITE("\033[47m"),   // WHITE

    // High Intensity backgrounds
    BLACK_BRIGHT("\033[0;100m"),     // BLACK
    RED_BRIGHT("\033[0;101m"),       // RED
    GREEN_BRIGHT("\033[0;102m"),     // GREEN
    YELLOW_BRIGHT("\033[0;103m"),    // YELLOW
    BLUE_BRIGHT("\033[0;104m"),      // BLUE
    MAGENTA_BRIGHT("\033[0;105m"),   // MAGENTA
    CYAN_BRIGHT("\033[0;106m"),      // CYAN
    WHITE_BRIGHT("\033[0;107m");     // WHITE

    private final String code;

    BackgroundColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
