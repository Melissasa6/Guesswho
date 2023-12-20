package game.commands;

import game.GameMessages;
import game.GuessWhoGame;

public class QuestionHandler implements CommandHandler{

    /**
     * Allow to each player choose a question from a list of questions predefined from the game
     * @param game represents the instance of a member class GuessWhoGame
     * @param playerHandler represents the access of the properties and methods of player
     */
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
