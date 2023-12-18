package game.commands;

import client.Client;
import game.GuessWhoGame;
import server.Server;

public interface CommandHandler {

  void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException;

}

