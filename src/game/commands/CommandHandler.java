package game.commands;

import client.Client;
import game.GuessWhoGame;
import server.Server;

/**
 * Al the commands implement the interface command handler
 */
public interface CommandHandler {

  /**
   * This method represents the action that each player will have
   * @param game represents the instance of a member class GuessWhoGame
   * @param playerHandler represents the access of the properties and methods of player
   * @throws NullPointerException when player closes the socket from his side
   */

  void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException;

}

