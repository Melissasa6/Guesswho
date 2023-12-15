package game.commands;

import client.Client;

public class HelpHandler implements CommandHandler{

    @Override
    public void handleCommands(Client client, String[] commands) throws NullPointerException {
        System.out.println("Available Commands:");
        for (Command command : Command.values()){
            System.out.println(command.getDescription());
        }
    }
}
