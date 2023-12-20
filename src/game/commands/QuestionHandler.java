package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class QuestionHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) {
        GuessWhoGame.PlayerHandler opponent = playerHandler.getOpponent();

        playerHandler.sendMessage(GameMessages.CHOOSE_A_QUESTION);
        String[] question = GameMessages.CHOOSE_A_QUESTION.split("\\n");
        int playerChoice = Integer.parseInt(playerHandler.getIn().nextLine());
        if (playerChoice <= 0 || playerChoice > question.length) {
            playerHandler.sendMessage(GameMessages.INVALID_QUESTION);
            return;
        }
        String messageToSend = question[Integer.parseInt(playerHandler.getIn().nextLine())];

        playerHandler.sendMessage(messageToSend);
        opponent.sendMessage(playerHandler.getName() + ":" + messageToSend.replaceAll("[^a-zA-Z ?]", ""));
    }
}
