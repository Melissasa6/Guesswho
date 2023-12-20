package game.commands;

import game.Ascii_art.Cards;
import game.Card;
import game.GuessWhoGame;

public class HideHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        String message = playerHandler.getMessage();

        String[] cardNames = message.split(" ")[1].split(",");

        for (String name : cardNames) {
            for (Card card : playerHandler.getCardList()){
                if (card.getCharacterName().equalsIgnoreCase(name)) {
                    card.setAsciiArt(Cards.getHiddenAsciiArt());
                }
            }
        }
    }
}
