package game;

import game.ascii_art.Cards;

import java.util.Arrays;
import java.util.List;
import static game.ascii_art.Colors.*;

/**
 * Class that builds the different character cards and puts them into a list, representing the board
 */
public final class BoardFactory {

    private static final List<Card> CARD_LIST = Arrays.asList(
            new Card("Emily", YELLOW, BROWN, GREEN, true, Cards.getEmilyAsciiArt()),
            new Card("Homer", BROWN, GREEN, GRAY, true, Cards.getHomerAsciiArt()),
            new Card("Mia", RED, BLUE, PINK, true, Cards.getMiaAsciiArt()),
            new Card ("Henry", GRAY, BLUE, GREEN, false, Cards.getHenryAsciiArt()),
            new Card("Daisy", PINK, GREEN, BROWN, false, Cards.getDaisyAsciiArt()),
            new Card("Levi", BROWN, GRAY, BLUE, false, Cards.getLeviAsciiArt())
    );

    /**
     * Method to return the list of cards
     * @return a list of cards
     */
    public static List<Card> characterList() {

        return CARD_LIST;
    }
}
