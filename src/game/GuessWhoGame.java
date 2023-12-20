package game;

import game.ascii_art.Board;
import game.ascii_art.Titles;
import game.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame implements Runnable{

    private ExecutorService service;
    private final List<PlayerHandler> players;
    private final int MAX_PLAYERS = 2;
    private boolean isGameStarted;
    private boolean isGameFinished;
    private int round;

    /**
     * Constructor method
     */
    public GuessWhoGame() {
        service = Executors.newFixedThreadPool(MAX_PLAYERS);
        players = new ArrayList<>();
        isGameStarted = false;
        isGameFinished = false;
        round = 0;
    }

    /**
     * Starts the game
     * Keeps running until the game is finished
     */
    @Override
    public void run() {
        while (!isGameFinished) {
            if (checkIfGameCanStart() && !isGameStarted) {
                startGame();
            }
            if (isGameStarted && !isGameFinished) {
                playRound();
            }
        }
        finishGame();
    }

    /**
     * Only allows 2 players in each game
     * @return true if the game can start or false if ther isn't enough players available to start the game
     */
    public boolean isGameFull(){
        return players.size() == MAX_PLAYERS;
    }

    /**
     * Accepts a new player into the game
     * @param playerSocket the socket from the client that connected
     */
    public void acceptPlayer(Socket playerSocket) {
        PlayerHandler player = new PlayerHandler(playerSocket);
        service.submit(player);
    }

    /**
     * Checks if a game can start and start the game
     */
    private synchronized boolean checkIfGameCanStart() {
        return isGameFull() && (players.get(0).getName() != null) && (players.get(1).getName() != null);
    }

    /**
     * Start the game, add a quote to the game and send messages to all players
     */
    private void startGame() {
        System.out.println("Game started...");
        this.isGameStarted = true;
        choosePlayerCard();
        for (PlayerHandler player : players) {
            player.sendMessage(String.format(GameMessages.PLAYER_CARD, player.getChosenCard().getCharacterName().toUpperCase()));
            player.sendMessage(player.getChosenCard().getAsciiArt());
        }
        broadcast(GameMessages.START_GAME);
    }

    /**
     * Plays a round of the game, communicating with the players
     */
    public synchronized void playRound() {
        round++;
        broadcast("~~ ROUND " + round + " ~~");
        for (PlayerHandler player : players) {
            PlayerHandler opponent = player.getOpponent();
            player.sendMessage(Board.printAllAsciiArt(player.getCardList()));
            opponent.sendMessage(Board.printAllAsciiArt(opponent.getCardList()));


            player.sendMessage(GameMessages.PLAYER_TURN);
            opponent.sendMessage(String.format(GameMessages.OPPONENT_TURN, player.getName()));

            while (true) {
                if (player.getMessage() == null || opponent.getMessage() == null) {
                    continue;
                }
                String answer;
                if (player.getMessage().equals("/question") || player.getMessage().equals("/guess")) {
                    answer = opponent.getMessage();
                    if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Allows to add a player to the game
     * Print the TITLE of the game for each player
     * @param playerHandler represents the player to be added
     */
    private void addPlayer(PlayerHandler playerHandler) {
        players.add(playerHandler);
        playerHandler.sendMessage(Titles.TITLE);
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }

    /**
     * Broadcast a message to each player
     * @param message represents the message to be boradcasted
     */
    public void broadcast(String message) {
        players.forEach(playerHandler -> playerHandler.sendMessage(message));
    }

    /**
     * Allows to send a card from the list of cards available randomly to the players that represents their mystery card
     */
    private void choosePlayerCard() {
        Random rand = new Random();
        PlayerHandler player1 = players.get(0);
        PlayerHandler player2 = players.get(1);
        player1.setChosenCard(player1.cardList.get(rand.nextInt(player1.cardList.size() - 1)));
        player2.setChosenCard(player2.cardList.get(rand.nextInt(player2.cardList.size() - 1)));
    }

    /**
     * Removes a player from the game
     * @param clientConnectionHandler represents the player to be removed
     */
    public void removePlayer(PlayerHandler clientConnectionHandler) {
        players.remove(clientConnectionHandler);
    }

    /**
     * Stop the game, causing players to quit
     */
    public void finishGame() {
        players.forEach(PlayerHandler::quitGame);
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    /**
     * PlayerHandler Inner class implements the interface Runnable
     */
    public class PlayerHandler implements Runnable {

        private String name;
        private String message;
        public Socket playerSocket;
        private PrintWriter out;
        private Scanner in;
        private List<Card> cardList;
        private Card chosenCard;


        /**
         * Constructor method
         * Initilizes player attributes
         * @param playerSocket represents the socket from the player
         */
        public PlayerHandler(Socket playerSocket) {
            this.playerSocket = playerSocket;
            try {
                out = new PrintWriter(playerSocket.getOutputStream(), true);
                in = new Scanner(playerSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            cardList = BoardFactory.characterList();
        }


        /**
         * Add player to the game
         * Verify if there is 2 players to join the game
         * Send a message to all players to inform that a new player has arrived
         * Checks if in the end of game the thread was interrupted and forces the players to quit
         */
        @Override
        public void run() {
            addPlayer(this);
            askName();
            if (players.size() < MAX_PLAYERS) {
                sendMessage(GameMessages.WAITING_FOR_PLAYER_JOIN);
            }

            try {
                in = new Scanner(playerSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (in.hasNext()) {
                try {

                    message = in.nextLine();
                    if (isCommand(message)) {
                        dealWithCommand(message);
                        continue;
                    }
                    if (message.equals("")) {
                        System.out.println("Empty message");
                        // continue;
                    }

                    sendMessageToOpponent(message);

                } catch (IOException e) {
                    System.err.println(GameMessages.CLIENT_ERROR + e.getMessage());
                    removePlayer(this);
                }

            }
        }

        /**
         * Send message to the player
         * @param message message to send
         */
        public void sendMessage(String message) {
            out.println(message);
            out.flush();
        }

        /**
         *
         * @return
         */
        public PlayerHandler getOpponent() {
            if (players.get(0).equals(this)) {
                return players.get(1);
            }
            return players.get(0);
        }

        /**
         * Sen message to the opponents
         * @param message message to send
         */
        public void sendMessageToOpponent(String message) {
            getOpponent().out.println(name + ": " + message);
            out.flush();
        }

        /**
         * Ask the name os each player when they entered the game
         */
        private void askName() {
            sendMessage(GameMessages.ENTER_NAME);
            name = in.nextLine();
            sendMessage("Hi, " + name);
        }


        /**
         * Informs how to start a command
         */
        private boolean isCommand(String message) {
            return message.startsWith("/");
        }

        /**
         * Extract the first wor from the message
         * Get the corresponding command based on the description
         * Call the handlers method associated with the command
         */
        private void dealWithCommand(String message) throws IOException {
            String description = message.split(" ")[0];
            Command command = Command.getCommandFromDescription(description);

            command.getHandler().handleCommands(GuessWhoGame.this, this);
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }

        public Card getChosenCard() {
            return chosenCard;
        }

        public Scanner getIn() {
            return in;
        }

        public List<Card> getCardList() {
            return cardList;
        }

        public void setChosenCard(Card chosenCard) {
            this.chosenCard = chosenCard;
        }


        /**
         * Close the connection from the players
         */
        private void quitGame() {
            try {
                playerSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}