package game.Ascii_art;

import game.BoardFactory;
import game.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

//    private static List<Cards> Cards;

    public static void printAllAsciiArt() {
        List<Card> cards = BoardFactory.characterList();

        // Split each card's ASCII art into lines
        List<String[]> cardLines = getCardLines(cards);

        // Print each line of the ASCII arts side by side
        printHorizontalArt(cardLines);
    }

    private static List<String[]> getCardLines(List<Card> cards) {
        // Collect lines of each card's ASCII art
        return cards.stream()
                .map(card -> card.getAsciiArt().split("\n"))
                .toList();
    }

    private static void printHorizontalArt(List<String[]> cardLines) {
        // Get the number of lines in the ASCII arts
        int numLines = cardLines.get(0).length;

        // Print each line of the ASCII arts side by side
        for (int i = 0; i < numLines; i++) {
            for (String[] lines : cardLines) {
                // Print the corresponding line or a separator if it's shorter
                if (i < lines.length) {
                    System.out.print(lines[i]);
                } else {
                    System.out.print(" ".repeat(lines[0].length())); // Add spaces as separator
                }
                System.out.print("   "); // Adjust this separator as needed
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public static void main(String[] args) {
        printAllAsciiArt();
    }


}
