package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class GuessHandler implements CommandHandler {

    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        playerHandler.sendMessage(GameMessages.PLAYER_GUESS);
        String opponentCard = game.getOpponent(playerHandler).getChosenCard().getCharacterName();
        String guess = playerHandler.getIn().nextLine();
        if (guess.equals(opponentCard)) {
            playerHandler.sendMessage(GameMessages.PLAYER_WON);
            return;
        }
        playerHandler.sendMessage(GameMessages.FAIL_GUESS);
    }
}
