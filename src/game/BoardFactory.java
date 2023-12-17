package game;

import java.util.Arrays;
import java.util.List;

public final class BoardFactory {

    private static final List<Card> CARD_LIST = Arrays.asList(
            new Card("Emily", Colors.BROWN, Colors.BLUE, Colors.BLUE, true, false, false, true ),
            new Card("Mia", Colors.YELLOW , Colors.BROWN, Colors.BROWN, false, true, false, true ),
            new Card("Daisy", Colors.BLACK , Colors.BLACK, Colors.GREEN, true, false, false, false ),
            new Card("Noah", Colors.BROWN , Colors.BLUE, Colors.BLUE, true, true, false, true ),
            new Card("Henry", Colors.YELLOW , Colors.BROWN, Colors.BROWN, false, false, true, false),
            new Card("Levi", Colors.BLACK , Colors.BLACK, Colors.GREEN, false, false,true, true)
    );

    public static List<Card> characterList() {

        return CARD_LIST;
    }
}
