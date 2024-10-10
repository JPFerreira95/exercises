package org.jpferreira.battleship;

import org.jpferreira.battleship.dto.Letter;
import org.jpferreira.battleship.dto.Position;
import org.jpferreira.battleship.dto.Ship;
import org.jpferreira.battleship.utils.printer.ColoredPrinter;
import org.jpferreira.battleship.utils.printer.color.BackgroundColor;
import org.jpferreira.battleship.utils.printer.color.TextColor;

import java.util.*;

public class Main {
    private static List<Ship> myFleet;
    private static List<Ship> enemyFleet;
    private static ColoredPrinter console;

    public static void main(String[] args) {
        console = ColoredPrinter.build().backgroundColor(BackgroundColor.BLACK).textColor(TextColor.WHITE);

        console.textColor(TextColor.MAGENTA);
        console.println("                                     |__");
        console.println("                                     |\\/");
        console.println("                                     ---");
        console.println("                                     / | [");
        console.println("                              !      | |||");
        console.println("                            _/|     _/|-++'");
        console.println("                        +  +--|    |--|--|_ |-");
        console.println("                     { /|__|  |/\\__|  |--- |||__/");
        console.println("                    +---------------___[}-_===_.'____                 /\\");
        console.println("                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _");
        console.println(" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7");
        console.println("|                        Welcome to Battleship                         BB-61/");
        console.println(" \\_________________________________________________________________________|");
        console.println("");
        console.textColor(TextColor.WHITE);

        InitializeGame();

        StartGame();
    }

    private static void StartGame() {
        Scanner scanner = new Scanner(System.in);

        console.print("\033[2J\033[;H");
        console.println("                  __");
        console.println("                 /  \\");
        console.println("           .-.  |    |");
        console.println("   *    _.-'  \\  \\__/");
        console.println("    \\.-'       \\");
        console.println("   /          _/");
        console.println("  |      _  /\" \"");
        console.println("  |     /_\'");
        console.println("   \\    \\_/");
        console.println("    \" \"\" \"\" \"\" \"");

        do {
            console.println("");
            console.println("Player, it's your turn");
            console.println("Enter coordinates for your shot :");
            Position position = tryToGetCoordinates(scanner);
            boolean isHit = GameController.checkIsHit(enemyFleet, position);
            if (isHit) {
                beep();

                console.println("                \\         .  ./");
                console.println("              \\      .:\" \";'.:..\" \"   /");
                console.println("                  (M^^.^~~:.'\" \").");
                console.println("            -   (/  .    . . \\ \\)  -");
                console.println("               ((| :. ~ ^  :. .|))");
                console.println("            -   (\\- |  \\ /  |  /)  -");
                console.println("                 -\\  \\     /  /-");
                console.println("                   \\  \\   /  /");

                if (checkEndGame(enemyFleet, true))
                    return;
            }

            console.println(isHit ? "Yeah ! Nice hit !" : "Miss");

            position = getRandomPosition();
            isHit = GameController.checkIsHit(myFleet, position);
            console.println("");
            console.println(String.format("Computer shoot in %s%s and %s", position.getColumn(), position.getRow(), isHit ? "hit your ship !" : "miss"));
            if (isHit) {
                beep();

                if (checkEndGame(myFleet, false)) {
                    return;
                }

                console.println("                \\         .  ./");
                console.println("              \\      .:\" \";'.:..\" \"   /");
                console.println("                  (M^^.^~~:.'\" \").");
                console.println("            -   (/  .    . . \\ \\)  -");
                console.println("               ((| :. ~ ^  :. .|))");
                console.println("            -   (\\- |  \\ /  |  /)  -");
                console.println("                 -\\  \\     /  /-");
                console.println("                   \\  \\   /  /");
            }
        } while (true);
    }

    private static boolean checkEndGame(Collection<Ship> ships, boolean isPlayer) {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                return false;
            }
        }

        console.println("             _ ._  _ , _ ._ ");
        console.println("           (_ ' ( `  )_  .__) ");
        console.println("        ( (  (    )   `)  ) _) ");
        console.println("       (__ (_   (_ . _) _) ,__)");
        console.println("           `~~`\\ ' . /`~~`     ");
        console.println("                ;   ;           ");
        console.println("                /   \\           ");
        console.println("_______________/_ __ \\_____________");

        console.println("Game Over! ");
        console.println(isPlayer ? "Congratulations! You win!" : "Computer wins!");
        return true;
    }

    private static Position tryToGetCoordinates(Scanner scanner) {
        while (true) {
            try {
                return parsePosition(scanner.next());
            } catch (IllegalArgumentException e) {
                console.println("Input is not valid. Keep it between 1 and 8");
            }
        }
    }

    private static void beep() {
        console.print("\007");
    }

    protected static Position parsePosition(String input) {
        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));
        return new Position(letter, number);
    }

    private static Position getRandomPosition() {
        int rows = 8;
        int lines = 8;
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(lines)];
        int number = random.nextInt(rows - 1) + 1;
        Position position = new Position(letter, number);
        return position;
    }

    private static void InitializeGame() {
        InitializeMyFleet();

        InitializeEnemyFleet();
    }

    private static void InitializeMyFleet() {
        Scanner scanner = new Scanner(System.in);
        myFleet = GameController.initializeShips();

        List<Position> existingMyFleetPositions = new ArrayList<>();

        console.println("Please position your fleet (Game board has size from A to H and 1 to 8) :");

        for (Ship ship : myFleet) {
            console.println("");
            console.println(String.format("Please enter the positions for the %s (size: %s)", ship.getName(), ship.getSize()));

            Set<Position> tmpPositions = new HashSet<>();
            for (int i = 1; i <= ship.getSize(); i++) {
                console.println(String.format("Enter position %s of %s (i.e A3):", i, ship.getSize()));

                String positionInput = scanner.next();
                try {
                    Position newPosition = ship.addPosition(positionInput);
                    if (existingMyFleetPositions.contains(newPosition)) {
                        console.println("Position already used. Please insert all the ship positions again.");
                        i = 0;
                        tmpPositions.forEach(existingMyFleetPositions::remove);
                        ship.getPositions().clear();
                        tmpPositions = new HashSet<>();
                    } else {
                        existingMyFleetPositions.add(newPosition);
                        tmpPositions.add(newPosition);
                    }
                } catch (Exception e) {
                    console.println("Invalid position. Please try again.");
                    i--;
                }
            }
        }
    }

    private static void InitializeEnemyFleet() {
        enemyFleet = GameController.initializeShips();

        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 4));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 5));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 6));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 7));
        enemyFleet.get(0).getPositions().add(new Position(Letter.B, 8));

        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 6));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 7));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 8));
        enemyFleet.get(1).getPositions().add(new Position(Letter.E, 5));
    }

}
