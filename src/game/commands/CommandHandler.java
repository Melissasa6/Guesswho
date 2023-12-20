package game.commands;

import game.GuessWhoGame;

/**
 * All commands implement the interface CommandHandler
 */
public interface CommandHandler {

  /**
   * This method represents the action that each player will have
   * @param game represents the instance of a GuessWhoGame
   * @param playerHandler allows the access to the properties and methods of PlayerHandler
   * @throws NullPointerException when player closes the socket from his side
   */

  void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException;

}

