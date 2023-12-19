package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class QuestionHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) {
        GuessWhoGame.PlayerHandler opponent = game.getOpponent(playerHandler);

        playerHandler.sendMessage(GameMessages.CHOOSE_A_QUESTION);
        String[] question = GameMessages.CHOOSE_A_QUESTION.split("\\n");

        String messageToSend = question[Integer.parseInt(playerHandler.getIn().nextLine())];
        playerHandler.sendMessage(messageToSend);
        opponent.sendMessage(playerHandler.getName() + ":" + messageToSend.replaceAll("[^a-zA-Z ?]", ""));
    }
}
