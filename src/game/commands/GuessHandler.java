package game.commands;

import client.Client;

public class GuessHandler implements CommandHandler {

    @Override
    public void handleCommands(Client client, String[] commands) throws NullPointerException {
        if (commands.length < 2) {
            System.out.println("Invalid guess. Use: /guess <character_name>");
            return;
        }
    String guessedCharacter = commands[1];

    }
}
