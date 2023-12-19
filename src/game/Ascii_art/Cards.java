package game.Ascii_art;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import static game.Ascii_art.Colors.*;
public class Cards {

    static final String asciiArtOneWithGlasses =
            YELLOW.getAsciiCode() +
                    "  ###########\n" + RESET.getAsciiCode() +
                    " /" + YELLOW.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "| " + ORANGE.getAsciiCode() + "#_/ \\  / \\_# " + RESET.getAsciiCode() + "|\n" +
                    "|   " + ORANGE.getAsciiCode() + "|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|==|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|" + RESET.getAsciiCode() + "   |\n" +
                    "|   " + ORANGE.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "|\n" +
                    "\\/\\    ^    /\\/ \n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + GREEN.getAsciiCode() +
                    "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + GREEN.getAsciiCode() + "$$$$$" +
                    RESET.getAsciiCode() + "|\\\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtTwoWithGlasses =
            BROWN.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
            " /" + BROWN.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
            "| " + RED.getAsciiCode() + "#_/ \\  / \\_# " + RESET.getAsciiCode() + "|\n" +
            "|   " + RED.getAsciiCode() + "|" + BLUE.getAsciiCode() + "0" + RED.getAsciiCode() + "|==|" + BLUE.getAsciiCode() + "0" + RED.getAsciiCode() + "|" + RESET.getAsciiCode() + "   |\n" +
            "|   " + RED.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "|\n" +
            "\\/\\    ^    /\\/ \n" +
            "   \\  ===  /\n" +
            "    \\_____/\n" +
            "     _|_|_\n" +
            "    /" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
            "   /|" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
            " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
            " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";



    static final String homerSimpson =
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



    public static void main(String[] args) {
        System.out.println(asciiArtOneWithGlasses);
        System.out.println(asciiArtTwoWithGlasses);
    }
}
