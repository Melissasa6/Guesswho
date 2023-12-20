package game.commands;

import game.Ascii_art.Board;
import game.GuessWhoGame;


public class BoardHandler implements CommandHandler{

    /**
     * Allows the player look ate the board, with all his cards printed any time during the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     * @throws NullPointerException  when player closes the socket from his side
     */

    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(Board.printAllAsciiArt(playerHandler.getCardList()));
    }
}
