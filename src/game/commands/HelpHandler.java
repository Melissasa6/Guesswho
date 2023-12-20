package game.commands;


import game.GameMessages;
import game.GuessWhoGame;

public class HelpHandler implements CommandHandler{
    /**
     * Allows to each player ask for help any time during the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     */
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) {
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }
}
