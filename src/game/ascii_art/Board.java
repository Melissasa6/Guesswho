package game.ascii_art;

import game.Card;
import java.util.List;

/**
 * Class responsible for drawing the player board
 */
public class Board {


    /**
     * Split each card's ASCII art into lines
     * Print each line of the ASCII arts side by side
     * @return The printed board
     */
    public static String printAllAsciiArt(List<Card> cardList) {

        List<String[]> cardLines = getCardLines(cardList);


        return printHorizontalArt(cardLines);
    }

    /**
     *Collect lines from each card's ASCII arts
     * @return a list of card asciiart lines
     */
    private static List<String[]> getCardLines(List<Card> cards) {
        return cards.stream()
                .map(card -> card.getAsciiArt().split("\n"))
                .toList();
    }

    /**
     * Get the number of the lines in the ASCII arts
     * Print each line of the ASCII arts side by side
     * Print the corresponding line or a separator if it's shorter
     * Move to the next line after printing each row
     * @return all cards printed in a horizontal direction
     */
    private static String printHorizontalArt(List<String[]> cardLines) {
        String board = "";
        int numLines = cardLines.get(0).length;

        for (int i = 0; i < numLines; i++) {
            for (String[] lines : cardLines) {

                if (i < lines.length) {
                    board = board.concat(lines[i]);
                } else {
                    board = board.concat(" ".repeat(lines[0].length())); // Add spaces as separator
                }
                board = board.concat("   "); // Adjust this separator as needed
            }
            board = board.concat("\n"); // Move to the next line after printing each row
        }
        return board;
    }
}
