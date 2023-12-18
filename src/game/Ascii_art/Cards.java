package game.Ascii_art;
import static game.Ascii_art.Colors.*;
public class Cards {

    static final String asciiArtOne =
            YELLOW.getAsciiCode() +
                    "  ###########\n" + RESET.getAsciiCode() +
                    " /" + YELLOW.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|    " + BLUE.getAsciiCode() + "0   0" + RESET.getAsciiCode() + "    |\n" +
                    "\\/\\    ^    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + GREEN.getAsciiCode() +
                    "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + GREEN.getAsciiCode() + "$$$$$" +
                    RESET.getAsciiCode() + "|\\\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtTwo =
            "  " + RED.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\n" +
                    " /" + RED.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|    ■ - ■    |\n" +
                    "\\/\\    >    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + PURPLE.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "\\\n" +
                    "   /|" + PURPLE.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
                    " | |" + PURPLE.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + PURPLE.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtThree =
                    "       .'  `'.\n" +
                    "      /  _    |\n" +
                    "      #_/.\\==/.\\\n" +
                    "     (, \\_/ \\\\_/\n" +
                    "      |    -' |\n" +
                    "      \\   '=  /\n" +
                    "      /`-.__.'\n" +
                    "   .-'`-.___|__\n" +
                    "  /" + BLUE.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "\\" + BLUE.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "\\`.\n" +
                    " /" + BLUE.getAsciiCode() + "$$$$$$" + RESET.getAsciiCode() + "\\" + BLUE.getAsciiCode() + "$$$$$$$$" + RESET.getAsciiCode() + "\\`.";

    static final String asciiArtFour =
            RED.getAsciiCode() +
                    "  ###########" + RESET.getAsciiCode() + "\n" +
                    " /" + RED.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|    " + GREEN.getAsciiCode() + "0   0" + RESET.getAsciiCode() + "    |\n" +
                    "\\/\\    ^    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + YELLOW.getAsciiCode() +
                    "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + YELLOW.getAsciiCode() + "$$$$$" +
                    RESET.getAsciiCode() + "|\\\n" +
                    " | |" + YELLOW.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + YELLOW.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtFive =
            "  " + PURPLE.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\n" +
                    " /" + PURPLE.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|    ■ - ■    |\n" +
                    "\\/\\    >    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + RED.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "\\\n" +
                    "   /|" + RED.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
                    " | |" + RED.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + RED.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtSix =
            "       .'  `'.\n" +
                    "      /  _    |\n" +
                    "      #_/.\\==/.\\\n" +
                    "     (, \\_/ \\\\_/\n" +
                    "      |    -' |\n" +
                    "      |  " + YELLOW.getAsciiCode() + "^~~~^" + RESET.getAsciiCode() + " |\n" +
                    "      \\   '=  /\n" +
                    "      /`-.__.'\n" +
                    "   .-'`-.___|__\n" +
                    "  /" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "\\" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "\\`.\n" +
                    " /" + GREEN.getAsciiCode() + "$$$$$$" + RESET.getAsciiCode() + "\\" + GREEN.getAsciiCode() + "$$$$$$$$" + RESET.getAsciiCode() + "\\`.";

    public static void main(String[] args) {
        System.out.println(asciiArtOne);
        System.out.println(asciiArtTwo);
        System.out.println(asciiArtThree);
        System.out.println(asciiArtFour);
        System.out.println(asciiArtFive);
        System.out.println(asciiArtSix);
    }
}
