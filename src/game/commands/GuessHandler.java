package game.commands;

import game.ascii_art.Titles;
import game.GameMessages;
import game.GuessWhoGame;

public class GuessHandler implements CommandHandler {

    /**
     * Allows the player guess the opponent's card
     * If the guess is correct the player wins the game
     * If the guess is wrong the player loses the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     * @throws NullPointerException when player closes the socket from his side
     */

    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.PLAYER_GUESS);
        String opponentCard = playerHandler.getOpponent().getChosenCard().getCharacterName();
        String guess = playerHandler.getIn().nextLine();
        if (guess.equalsIgnoreCase(opponentCard)) {
            playerHandler.sendMessage(Titles.WINNER);
            game.setGameFinished(true);
            return;
        }
        playerHandler.sendMessage(Titles.LOSER);
        game.setGameFinished(true);
    }
}
