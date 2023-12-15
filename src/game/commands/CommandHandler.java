package game.commands;

import client.Client;

public interface CommandHandler {

  void handleCommands(Client client, String[] commands) throws NullPointerException;

}

