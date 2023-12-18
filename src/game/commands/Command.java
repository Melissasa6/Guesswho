package game.commands;

public enum Command {
    QUESTION("/question", new QuestionHandler()),
    HELP("/help", new HelpHandler()),
    GUESS ("/guess", new GuessHandler()),
    NOT_FOUND("Command not found", new CommandNotFoundHandler());

    private String description;
    private CommandHandler handler;

    Command(String description, CommandHandler handler){
        this.description = description;
        this.handler = handler;
    }

    public static Command getCommandFromDescription(String description){
        for(Command command : values()){
            if (description.equals(command.description)){
                return command;
            }
        }
        return NOT_FOUND;
    }

    public CommandHandler getHandler() {
        return handler;
    }

    public String getDescription() {
        return description;
    }
}