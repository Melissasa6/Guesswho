package game.Ascii_art;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.sql.SQLOutput;

import static game.Ascii_art.Colors.*;
public class Cards {

    static final String asciiArtOneWithGlasses =
            "+------------------+\n" +
                    "|" + YELLOW.getAsciiCode() +"   ###########" + RESET.getAsciiCode() + "    |\n" +
                    "|  /" + YELLOW.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\   |\n" +
                    "| | " + ORANGE.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "| |\n" +
                    "| | " + ORANGE.getAsciiCode() + "#_|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|==|" + BROWN.getAsciiCode() + "0" + ORANGE.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " | |\n" +
                    "| |   " + ORANGE.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "| |\n" +
                    "| \\/\\    ^    /\\/  | \n" +
                    "|    \\  ===  /     |\n" +
                    "|     \\_____/      |\n" +
                    "|      _|_|_       |\n" +
                    "|     /" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\      |\n" +
                    "|    /|" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\     |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "|  | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |   |\n" +
                    "+------------------+\n";





    static final String asciiArtTwoWithGlasses =
            BROWN.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
            " /" + BROWN.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
            "| " + RED.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "|\n" +
            "| " + RED.getAsciiCode() + "#_|" + BLUE.getAsciiCode() + "0" + RED.getAsciiCode() + "|==|" + BLUE.getAsciiCode() + "0" + RED.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " |\n" +
            "|   " + RED.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "|\n" +
            "\\/\\    ^    /\\/ \n" +
            "   \\  ===  /\n" +
            "    \\_____/\n" +
            "     _|_|_\n" +
            "    /" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
            "   /|" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
            " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
            " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtThreeWithGlasses =
            RED.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
            " /" + RED.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
            "| " + BROWN.getAsciiCode() + "  / \\  / \\   " + RESET.getAsciiCode() + "|\n" +
            "| " + BROWN.getAsciiCode() + "#_|" + GREEN.getAsciiCode() + "0" + BROWN.getAsciiCode() + "|==|" + GREEN.getAsciiCode() + "0" + BROWN.getAsciiCode() + "|_#" + RESET.getAsciiCode() + " |\n" +
            "|   " + BROWN.getAsciiCode() + "\\_/  \\_/   " + RESET.getAsciiCode() + "|\n" +
            "\\/\\    ^    /\\/ \n" +
            "   \\  ===  /\n" +
            "    \\_____/\n" +
            "     _|_|_\n" +
            "    /" + GRAY.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
            "   /|" + GRAY.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
            " | |" + GRAY.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
            " | |" + GRAY.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtFourWithoutGlasses =
            GRAY.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
                    " /" + GRAY.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|              |\n" +
                    "|    " + BLUE.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + BLUE.getAsciiCode() + "0" + RESET.getAsciiCode() + "    |\n" +
                    "|              |\n" +
                    "\\/\\    ^    /\\/ \n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + GREEN.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + GREEN.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtFiveWithoutGlasses =
            BLUE.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
                    " /" + BLUE.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|              |\n" +
                    "|    " + BROWN.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + BROWN.getAsciiCode() + "0" + RESET.getAsciiCode() + "    |\n" +
                    "|              |\n" +
                    "\\/\\    ^    /\\/ \n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + PINK.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
                    " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + PINK.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";

    static final String asciiArtSixWithoutGlasses =
            YELLOW.getAsciiCode() + "  ###########\n" + RESET.getAsciiCode() +
                    " /" + YELLOW.getAsciiCode() + "###########" + RESET.getAsciiCode() + "\\\n" +
                    "|              |\n" +
                    "|    " + GREEN.getAsciiCode() + "0" + RESET.getAsciiCode() + "    " + GREEN.getAsciiCode() + "0" + RESET.getAsciiCode() + "    |\n" +
                    "|              |\n" +
                    "\\/\\    ^    /\\/ \n" +
                    "   \\  ===  /\n" +
                    "    \\_____/\n" +
                    "     _|_|_\n" +
                    "    /" + YELLOW.getAsciiCode() + "$$$$$" + RESET.getAsciiCode()  + "\\\n" +
                    "   /|" + YELLOW.getAsciiCode() + "$$$$$" + RESET.getAsciiCode() + "|\\\n" +
                    " | |" + YELLOW.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n" +
                    " | |" + YELLOW.getAsciiCode() + "$$$$$$$" + RESET.getAsciiCode() + "| |\n";


    public static void main(String[] args) {
        System.out.println(asciiArtOneWithGlasses);
//        System.out.println(framedAsciiArtOneWithGlasses);
//        System.out.println(asciiArtTwoWithGlasses);
//        System.out.println(asciiArtThreeWithGlasses);
//        System.out.println(asciiArtFourWithoutGlasses);
//        System.out.println(asciiArtFiveWithoutGlasses);
//        System.out.println(asciiArtSixWithoutGlasses);
    }
}
