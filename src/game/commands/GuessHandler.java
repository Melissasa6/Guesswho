package game.commands;

import game.Ascii_art.Titles;
import game.GameMessages;
import game.GuessWhoGame;

public class GuessHandler implements CommandHandler {

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
