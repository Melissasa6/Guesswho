package game.ascii_art;
import static game.ascii_art.Colors.*;

/**
 * Class that holds the ascii art for the cards
 */
public class Cards {

    private static final String hiddenAsciiArt =
            "+------------------+\n" +
            "| x               x|\n" +
            "|  x             x |\n" +
            "|   x           x  |\n" +
            "|    x         x   |\n" +
            "|     x       x    |\n" +
            "|      x     x     |\n" +
            "|       x   x      |\n" +
            "|        x x       |\n" +
            "|         x        |\n" +
            "|        x x       |\n" +
            "|       x   x      |\n" +
            "|      x     x     |\n" +
            "|     x       x    |\n" +
            "|    x         x   |\n" +
            "+------------------+\n";

    private static final String emilyAsciiArt =
            "+------------------+\n" +
                    "|" + YELLOW.getAsciiCode() +"   ###########" + RESET.getAsciiCode() + "    |\n" +
                    "|  /" + YELLOW.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\   |\n" +
                    "| | " + ORANGE.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "| |\n" +
                    "| | " + ORANGE.getAsciiCode() + "#_|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|==|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " | |\n" +
                    "| |   " + ORANGE.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "| |\n" +
                    "| \\/\\    ^    /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n" +
                    "|    /|" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|      Emily       |\n" +
                    "+------------------+\n";

    private static final String homerAsciiArt =
            "+------------------+\n" +
                    "|" + BROWN.getAsciiCode() +"   ###########" + RESET.getAsciiCode() + "    |\n" +
                    "|  /" + BROWN.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\   |\n" +
                    "| | " + ORANGE.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "| |\n" +
                    "| | " + ORANGE.getAsciiCode() + "#_|" + GREEN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|==|" + GREEN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " | |\n" +
                    "| |   " + ORANGE.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "| |\n" +
                    "| \\/\\    ^    /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + GRAY.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n" +
                    "|    /|" + GRAY.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + GRAY.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + GRAY.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|      Homer       |\n" +
                    "+------------------+\n";

    private static final String miaAsciiArt =
            "+------------------+\n" +
                    "|" + RED.getAsciiCode() + "   ###########" + RESET.getAsciiCode() + "    |\n" +
                    "|  /" + RED.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\   |\n" +
                    "| | " + ORANGE.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "| |\n" +
                    "| | " + ORANGE.getAsciiCode() + "#_|" + BLUE.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|==|" + BLUE.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " | |\n" +
                    "| |   " + ORANGE.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "| |\n" +
                    "| \\/\\    ^    /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n" +
                    "|    /|" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|       Mia        |\n" +
                    "+------------------+\n";

    private static final String henryAsciiArt =
            "+------------------+\n" +
                    "| " + GRAY.getAsciiCode() + "   ##########" + RESET.getAsciiCode() + "    |\n" +
                    "|   /" + GRAY.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\  |\n" +
                    "|  |            |  |\n" +
                    "|  |   " + BLUE.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + BLUE.getAsciiCode() + "0" + RESET.getAsciiCode() + "   |  |\n" +
                    "|  |            |  |\n" +
                    "|  \\/\\    ^   /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n"  +
                    "|    /|" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|      Henry       |\n" +
                    "+------------------+\n";

    private static final String daisyAsciiArt =
            "+------------------+\n" +
                    "| " + PINK.getAsciiCode() + "   ##########" + RESET.getAsciiCode() + "    |\n" +
                    "|   /" + PINK.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\  |\n" +
                    "|  |            |  |\n" +
                    "|  |   " + GREEN.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + GREEN.getAsciiCode() + "0" + RESET.getAsciiCode() + "   |  |\n" +
                    "|  |            |  |\n" +
                    "|  \\/\\    ^   /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + BROWN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n"  +
                    "|    /|" + BROWN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + BROWN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + BROWN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|      Daisy       |\n" +
                    "+------------------+\n";

    private static final String leviAsciiArt =
            "+------------------+\n" +
                    "| " + BROWN.getAsciiCode() + "   ##########" + RESET.getAsciiCode() + "    |\n" +
                    "|   /" + BROWN.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\  |\n" +
                    "|  |            |  |\n" +
                    "|  |   " + GRAY.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + GRAY.getAsciiCode() + "0" + RESET.getAsciiCode() + "   |  |\n" +
                    "|  |            |  |\n" +
                    "|  \\/\\    ^   /\\/  |\n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + BLUE.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n"  +
                    "|    /|" + BLUE.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + BLUE.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + BLUE.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|      Levi        |\n" +
                    "+------------------+\n";



    public static String getHiddenAsciiArt() {
        return hiddenAsciiArt;
    }
    public static String getEmilyAsciiArt() {
        return emilyAsciiArt;
    }
    public static String getHomerAsciiArt() {
        return homerAsciiArt;
    }
    public static String getMiaAsciiArt(){
        return miaAsciiArt;
    }
    public static String getHenryAsciiArt() {
        return henryAsciiArt;
    }
    public static String getDaisyAsciiArt() {
        return daisyAsciiArt;
    }
    public static String getLeviAsciiArt() {
        return leviAsciiArt;
    }

}
