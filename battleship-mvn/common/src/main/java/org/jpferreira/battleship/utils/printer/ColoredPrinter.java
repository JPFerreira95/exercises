package org.jpferreira.battleship.utils.printer;

import org.jpferreira.battleship.utils.printer.color.BackgroundColor;
import org.jpferreira.battleship.utils.printer.color.TextColor;

/**
 * Colored Printer class to print system outputs with colors
 */
public class ColoredPrinter {

    private static final String RESET = "\033[0m";

    private TextColor textTextColor;
    private BackgroundColor backgroundColor;

    private ColoredPrinter(TextColor textTextColor, BackgroundColor backgroundColor) {
        this.textTextColor = textTextColor;
        this.backgroundColor = backgroundColor;
    }

    public static ColoredPrinter build() {
        return new ColoredPrinter(TextColor.WHITE, null);
    }

    public void reset() {
        System.out.print(RESET);
    }

    public void print(String text) {
        System.out.print(text);
    }

    public ColoredPrinter textColor(TextColor textTextColor) {
        this.textTextColor = textTextColor;
        return this;
    }

    public ColoredPrinter backgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public void println(String text) {

        String background = backgroundColor != null ? backgroundColor.toString() : "";
        String textC = textTextColor != null ? textTextColor.toString() : "";

        System.out.println(textC + background + text);
    }

}
