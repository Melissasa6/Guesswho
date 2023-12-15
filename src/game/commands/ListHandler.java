package game.commands;

import client.Client;

import java.util.List;

public class ListHandler implements CommandHandler {
    @Override
    public void handleCommands(Client client, String[] commands) throws NullPointerException {
        if (commands.length < 2){
            System.out.println("Invalid list command. Use: /list <character_name");
            return;
        }

        String characterToRemove = commands[1];

        // List<String> playerPossibleCharacters = "Missing Getter das Possible Characters"
    }
}
