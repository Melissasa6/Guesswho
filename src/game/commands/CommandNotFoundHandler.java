package game.commands;

import game.GameMessages;
import game.GuessWhoGame;
import server.Server;

public class CommandNotFoundHandler implements CommandHandler{

    /**
     * Informs the player that the command does not exist
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     * @throws NullPointerException when player closes the socket from his side
     */
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.INVALID_COMMAND);
    }
}
