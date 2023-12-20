package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class RulesHandler implements CommandHandler{

    /**
     * Allows to each player ask for the rules any time during the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     * @throws NullPointerException when player closes the socket from his side
     */
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.GAME_RULES);
    }
}
