package game.commands;

import client.Client;
import game.GameMessages;
import game.GuessWhoGame;
import server.Server;

import java.util.Arrays;

public class QuestionHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        GuessWhoGame.PlayerHandler opponent = game.getOpponent(playerHandler);
        playerHandler.sendMessage(GameMessages.CHOOSE_A_QUESTION);
        String[] question = GameMessages.CHOOSE_A_QUESTION.split("\\n");
        String messageToSend = question[Integer.parseInt(playerHandler.getIn().nextLine())];
        opponent.sendMessage(messageToSend);

        //String answer = opponent.getIn().nextLine();
        //playerHandler.sendMessage(answer);
    }
}
