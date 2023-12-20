package game.commands;

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