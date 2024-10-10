//package org.battleship.util;
//
//import org.battleship.util.printer.ColoredPrinter;
//import org.battleship.util.printer.color.BackgroundColor;
//import org.battleship.util.printer.color.TextColor;
//
//public class Main {
//    public static void main(String[] args) {
//
//        ColoredPrinter printer = ColoredPrinter.build().textColor(TextColor.BLACK_BOLD);
//        printer.println("Black_Bold");
//        printer.reset();
//
//        printer.textColor(TextColor.YELLOW);
//        printer.backgroundColor(BackgroundColor.BLUE);
//        printer.println("YELLOW & BLUE");
//        printer.reset();
//
//        printer.textColor(TextColor.MAGENTA_BRIGHT);
//        printer.backgroundColor(BackgroundColor.BLACK);
//        printer.println("YELLOW");
//        printer.reset();
//
//        System.out.print(TextColor.BLACK_BOLD);
//        System.out.println("Black_Bold");
//        System.out.print("\033[0m");
//
//        System.out.print(TextColor.YELLOW);
//        System.out.print(BackgroundColor.BLUE);
//        System.out.println("YELLOW & BLUE");
//        System.out.print("\033[0m");
//
//        System.out.print(TextColor.YELLOW);
//        System.out.println("YELLOW");
//        System.out.print("\033[0m");
//
//        System.out.print("\007");
//    }
//}