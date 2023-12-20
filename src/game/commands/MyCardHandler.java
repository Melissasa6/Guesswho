package game.commands;

import game.GuessWhoGame;

public class MyCardHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(playerHandler.getChosenCard().getAsciiArt());
    }
}
