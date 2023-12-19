package game;

import game.Ascii_art.Colors;

import java.util.Arrays;
import java.util.List;
import static game.Ascii_art.Colors.*;

public final class BoardFactory {

    private static final List<Card> CARD_LIST = Arrays.asList(
            new Card("Emily", YELLOW, BROWN, GREEN, true),
            new Card("Homer", BROWN, GREEN, GRAY, true),
            new Card("Mia", RED, BLUE, PINK, true),

            new Card ("Henry", GRAY, BLUE, GREEN, false),
            new Card("Daisy", PINK, GREEN, BROWN, false),
            new Card("Levi", BROWN, GRAY, BLUE, false)
    );

    public static List<Card> characterList() {

        return CARD_LIST;
    }
}
