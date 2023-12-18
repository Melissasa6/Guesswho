package game.commands;


import game.Ascii_art.Cards;
import game.GameMessages;
import game.GuessWhoGame;
import server.Server;

public class HelpHandler implements CommandHandler{

    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) {
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }
}
