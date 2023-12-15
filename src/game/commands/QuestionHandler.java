package game.commands;

import client.Client;

public class QuestionHandler implements CommandHandler{
    @Override
    public void handleCommands(Client client, String[] commands) throws NullPointerException {
        if (commands.length < 2){
            System.out.println("Invalid question. Use: /question <trait_name>");
            return;
        }

        String askedTrait = commands[1];
    }
}
