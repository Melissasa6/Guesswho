package game.commands;

import game.GameMessages;
import game.GuessWhoGame;
import server.Server;

public class CommandNotFoundHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.INVALID_COMMAND);
    }
}
