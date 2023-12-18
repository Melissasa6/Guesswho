package game.Ascii_art;

import java.sql.SQLOutput;

public class Cards {

    static final String asciiArtOne =
            ACS.ANSI_YELLOW +
                    "  ###########\n" + ACS.ANSI_RESET +
                    " /" + ACS.ANSI_YELLOW + "###########" + ACS.ANSI_RESET + "\\\n" +
                    "|    " + ACS.ANSI_BLUE + "0   0" + ACS.ANSI_RESET + "    |\n" +
                    "\\/\\    ^    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + ACS.ANSI_GREEN +
                    "$$$$$" + ACS.ANSI_RESET  + "\\\n" +
                    "   /|" + ACS.ANSI_GREEN + "$$$$$" +
                    ACS.ANSI_RESET + "|\\\n" +
                    " | |" + ACS.ANSI_GREEN + "$$$$$$$" + ACS.ANSI_RESET + "| |\n" +
                    " | |" + ACS.ANSI_GREEN + "$$$$$$$" + ACS.ANSI_RESET + "| |\n";

    static final String asciiArtTwo =
            "  " + ACS.ANSI_RED + "###########" + ACS.ANSI_RESET + "\n" +
                    " /" + ACS.ANSI_RED + "###########" + ACS.ANSI_RESET + "\\\n" +
                    "|    ■ - ■    |\n" +
                    "\\/\\    >    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + ACS.ANSI_PURPLE + "$$$$$" + ACS.ANSI_RESET + "\\\n" +
                    "   /|" + ACS.ANSI_PURPLE + "$$$$$" + ACS.ANSI_RESET + "|\\\n" +
                    " | |" + ACS.ANSI_PURPLE + "$$$$$$$" + ACS.ANSI_RESET + "| |\n" +
                    " | |" + ACS.ANSI_PURPLE + "$$$$$$$" + ACS.ANSI_RESET + "| |\n";

    static final String asciiArtThree =
                    "       .'  `'.\n" +
                    "      /  _    |\n" +
                    "      #_/.\\==/.\\\n" +
                    "     (, \\_/ \\\\_/\n" +
                    "      |    -' |\n" +
                    "      \\   '=  /\n" +
                    "      /`-.__.'\n" +
                    "   .-'`-.___|__\n" +
                    "  /" + ACS.ANSI_BLUE + "$$$$$" + ACS.ANSI_RESET + "\\" + ACS.ANSI_BLUE + "$$$$$$$" + ACS.ANSI_RESET + "\\`.\n" +
                    " /" + ACS.ANSI_BLUE + "$$$$$$" + ACS.ANSI_RESET + "\\" + ACS.ANSI_BLUE + "$$$$$$$$" + ACS.ANSI_RESET + "\\`.";

    static final String asciiArtFour =
            ACS.ANSI_RED +
                    "  ###########" + ACS.ANSI_RESET + "\n" +
                    " /" + ACS.ANSI_RED + "###########" + ACS.ANSI_RESET + "\\\n" +
                    "|    " + ACS.ANSI_GREEN + "0   0" + ACS.ANSI_RESET + "    |\n" +
                    "\\/\\    ^    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + ACS.ANSI_YELLOW +
                    "$$$$$" + ACS.ANSI_RESET  + "\\\n" +
                    "   /|" + ACS.ANSI_YELLOW + "$$$$$" +
                    ACS.ANSI_RESET + "|\\\n" +
                    " | |" + ACS.ANSI_YELLOW + "$$$$$$$" + ACS.ANSI_RESET + "| |\n" +
                    " | |" + ACS.ANSI_YELLOW + "$$$$$$$" + ACS.ANSI_RESET + "| |\n";

    static final String asciiArtFive =
            "  " + ACS.ANSI_PURPLE + "###########" + ACS.ANSI_RESET + "\n" +
                    " /" + ACS.ANSI_PURPLE + "###########" + ACS.ANSI_RESET + "\\\n" +
                    "|    ■ - ■    |\n" +
                    "\\/\\    >    /\\/\n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + ACS.ANSI_RED + "$$$$$" + ACS.ANSI_RESET + "\\\n" +
                    "   /|" + ACS.ANSI_RED + "$$$$$" + ACS.ANSI_RESET + "|\\\n" +
                    " | |" + ACS.ANSI_RED + "$$$$$$$" + ACS.ANSI_RESET + "| |\n" +
                    " | |" + ACS.ANSI_RED + "$$$$$$$" + ACS.ANSI_RESET + "| |\n";

    static final String asciiArtSix =
            "       .'  `'.\n" +
                    "      /  _    |\n" +
                    "      #_/.\\==/.\\\n" +
                    "     (, \\_/ \\\\_/\n" +
                    "      |    -' |\n" +
                    "      |  " + ACS.ANSI_YELLOW + "^~~~^" + ACS.ANSI_RESET + " |\n" +
                    "      \\   '=  /\n" +
                    "      /`-.__.'\n" +
                    "   .-'`-.___|__\n" +
                    "  /" + ACS.ANSI_GREEN + "$$$$$" + ACS.ANSI_RESET + "\\" + ACS.ANSI_GREEN + "$$$$$$$" + ACS.ANSI_RESET + "\\`.\n" +
                    " /" + ACS.ANSI_GREEN + "$$$$$$" + ACS.ANSI_RESET + "\\" + ACS.ANSI_GREEN + "$$$$$$$$" + ACS.ANSI_RESET + "\\`.";

    public static void main(String[] args) {
//        System.out.println(asciiArtOne);
//        System.out.println(asciiArtTwo);
//        System.out.println(asciiArtThree);
        System.out.println(asciiArtFour);
        System.out.println(asciiArtFive);
        System.out.println(asciiArtSix);
    }
}
