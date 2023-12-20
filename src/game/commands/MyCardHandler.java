package game.commands;

import game.GuessWhoGame;

public class MyCardHandler implements CommandHandler{

    /**
     * Allows each player take a look at his mystery card during the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     * @throws NullPointerException when player closes the socket from his side
     */
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(playerHandler.getChosenCard().getAsciiArt());
    }
}
