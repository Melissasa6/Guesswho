package game.Ascii_art;

import game.Card;
import java.util.List;

public class Board {
    public static String printAllAsciiArt(List<Card> cardList) {
        // Split each card's ASCII art into lines
        List<String[]> cardLines = getCardLines(cardList);

        // Print each line of the ASCII arts side by side
        return printHorizontalArt(cardLines);
    }

    private static List<String[]> getCardLines(List<Card> cards) {
        // Collect lines of each card's ASCII art
        return cards.stream()
                .map(card -> card.getAsciiArt().split("\n"))
                .toList();
    }

    private static String printHorizontalArt(List<String[]> cardLines) {
        String board = "";
        // Get the number of lines in the ASCII arts
        int numLines = cardLines.get(0).length;

        // Print each line of the ASCII arts side by side
        for (int i = 0; i < numLines; i++) {
            for (String[] lines : cardLines) {
                // Print the corresponding line or a separator if it's shorter
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
