package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class RulesHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.GAME_RULES);
    }
}
