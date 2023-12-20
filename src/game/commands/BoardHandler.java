package game.commands;

import game.Ascii_art.Board;
import game.GuessWhoGame;

public class BoardHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(Board.printAllAsciiArt(playerHandler.getCardList()));
    }
}
