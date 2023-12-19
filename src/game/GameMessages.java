package game;

public final class GameMessages {

    public static final String WELCOME_MESSAGE = "~~ Welcome to GUESS WHO! Are you ready? ~~\n";
    public static final String ENTER_NAME = "Please enter your name:";
    public static final String WAITING_FOR_PLAYER_JOIN = "Waiting for another player to join...";
    public static final String WAITING_FOR_PLAYER_NAME = "The other player is still choosing a name. Please wait...";
    public static final String CLIENT_ERROR = "Something went wrong with this client's connection. Error: ";
    public static final String PLAYER_JOINED = "Player %s joined the game!\n";
    public static final String START_GAME = "\nTHE GAME IS ON!\n";
    public static final String GAME_RULES = """
            ********** Insert game rules here ********
            """;

    public static final String COMMAND_HELP = """
            \nList of available commands:
            /help\t\t\t Shows the help menu
            /rules\t\t\t Brings up the rulebook
            /question\t\t Ask the opponent a question
            /mycard\t\t\t Check player own character
            /hide <name>\t Hides one or more characters from your board
            /guess <name>\t Attempt to guess the opponent character
            /quit\t\t\t Quits the game
            """;
    public static final String THIS_IS_THE_CHARACTER = "This is the character that you will try to guess\n";
    public static final String WAITING_PLAYER_QUESTION= "We're waiting for %s to ask a question...\n";
    public static final String PLAYER_GUESS = "Please, choose a character (if you miss, you lose): ";
    public static final String CHOOSE_A_QUESTION = "Please choose one question:\n"+
            "1 Is he a man?\n" +
            "2 Is she a women?\n" +
            "3 Is he old?\n" +
            "4 Is his hair blond?\n" +
            "5 Is his hair brown?\n" +
            "6 Is he bold?\n" +
            "7 Does he have a hat?\n" +
            "8 Does he wear glasses?\n" +
            "9 Are his eyes blue?\n" +
            "10 Are his eyes brown?\n";
    public static final String INVALID_QUESTION = " Please choose a question:\n";
    public static final String FAIL_GUESS = "%s has guessed %s and... Wrong character, try again next turn\n\n";
    public static final String INVALID_COMMAND = "No such command\n";
    public static final String MISS_TURN= "%s loss the turn, wait for the next turn :(\n";
    public static final String PLAYER_TURN = "%s is playing now\n";
    public static final String PLAYER_WON = "%s is the WINNER\n\n";
    public static final String PLAYER_LEFT_GAME = "%s has left the game\n";
    public static final String GAME_OVER = "This game is now over. Nice to see you\n";
}

