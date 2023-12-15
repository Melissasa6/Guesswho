package game.commands;

import java.util.List;

public enum Command {
    QUESTION("/question", new QuestionHandler()),
    HELP("/help", new HelpHandler()),
    GUESS ("/guess", new GuessHandler()),
    LIST("/list", new ListHandler());

    private String description;
    private CommandHandler handler;

    Command(String description, CommandHandler handler){
        this.description = description;
        this.handler = handler;
    }

    public CommandHandler getHandler() {
        return handler;
    }

    public String getDescription() {
        return description;
    }
}