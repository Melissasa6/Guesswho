package game.commands;

/**
 * Commands available to be used by the players in each game
 */
public enum Command {
    HELP("/help", new HelpHandler()),
    RULES("/rules", new RulesHandler()),
    BOARD ("/board", new BoardHandler()),
    MY_CARD("/mycard", new MyCardHandler()),
    HIDE ("/hide", new HideHandler()),
    QUESTION("/question", new QuestionHandler()),
    GUESS ("/guess", new GuessHandler()),
    NOT_FOUND("Command not found", new CommandNotFoundHandler());

    private String description;
    private CommandHandler handler;


    /**
     * Method constructor of the enum command this accept two arguments
     * @param description represents the name of the command
     * @param handler represents the command that will receive and need to be handler
     */
    Command(String description, CommandHandler handler){
        this.description = description;
        this.handler = handler;
    }

    /**
     * Method to get a command enum constant based on its description
     * @param description represents the name of the command
     * @return the correponding command enum constant or NOT_FOUND if not found
     */
    public static Command getCommandFromDescription(String description){
        for(Command command : values()){
            if (description.equals(command.description)){
                return command;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Allows to know what command that will be used
     * @return the enum command
     */
    public CommandHandler getHandler() {
        return handler;
    }

    /**
     * @return the description of the command when is instanced
     */
    public String getDescription() {
        return description;
    }
}