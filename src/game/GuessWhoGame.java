package game;

import game.Ascii_art.Winner;
import game.commands.Command;
import server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame implements Runnable{

    private ExecutorService service;
    private final List<PlayerHandler> players;
    private final int MAX_PLAYERS = 2;
    private boolean isGameStarted;
    private boolean isGameFinished;

    public GuessWhoGame(Server server) {
        service = Executors.newFixedThreadPool(MAX_PLAYERS);
        players = new ArrayList<>();
        isGameStarted = false;
        isGameFinished = false;
    }

    @Override
    public void run() {
        while (!isGameFinished) {
            if (checkIfGameCanStart() && !isGameStarted) {
                startGame();
                System.out.println("here");
                if (isGameStarted) {

                }
            }
        }
    }

    public boolean isGameFull(){
        return players.size() == MAX_PLAYERS;
    }

    public void acceptPlayer(Socket playerSocket) {
        PlayerHandler player = new PlayerHandler(playerSocket);
        service.submit(player);
    }

    private synchronized boolean checkIfGameCanStart() {
        return isGameFull() && (players.get(0).getName() != null) && (players.get(1).getName() != null);
    }
    public void playTurn() {

    }

    private void startGame() {
        this.isGameStarted = true;
        choosePlayerCards();
        broadcast(GameMessages.START_GAME);
    }

    private void addPlayer(PlayerHandler playerHandler) {
        players.add(playerHandler);
        playerHandler.sendMessage(Winner.TITLE);
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }

    public void broadcast(String message) {
        players.forEach(playerHandler -> playerHandler.sendMessage(message));
    }

    private void choosePlayerCards() {
        players.get(0).setChosenCard(new Card("Emily", Colors.BROWN, Colors.BLUE, Colors.BLUE, true, false, false, true ));

    }

    public void removePlayer(PlayerHandler clientConnectionHandler) {
        players.remove(clientConnectionHandler);

    }

    public Optional<PlayerHandler> getClientByName(String name) {
        return players.stream()
                .filter(clientConnectionHandler -> clientConnectionHandler.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public PlayerHandler getOpponent(PlayerHandler playerHandler) {
        if (players.get(0).equals(playerHandler)) {
            return players.get(1);
        }
        return players.get(0);
    }

    public void finishGame() {
        players.forEach(PlayerHandler::quitGame);
    }
    public class PlayerHandler implements Runnable {

        private String name;
        private String message;
        public Socket playerSocket;
        private PrintWriter out;
        private Scanner in;
        private List<Card> cardList;
        private Card chosenCard;



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
                    // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    message = in.nextLine();
                    if (isCommand(message)) {
                        dealWithCommand(message);
                        continue;
                    }
                    if (message.equals("")) {
                        System.out.println("Empty message");
                        // continue;
                    }

                    //broadcast(name, message);

                } catch (IOException e) {
                    System.err.println(GameMessages.CLIENT_ERROR + e.getMessage());
                    removePlayer(this);
                }

            }
            /*players.add(this);
            sendMessage(Winner.TITLE);
            sendMessage(GameMessages.WELCOME_MESSAGE);
            name = askName();

            sendMessage(GameMessages.COMMAND_HELP);

            if (players.size() < MAX_PLAYERS) {
                sendMessage(GameMessages.WAITING_FOR_PLAYER_JOIN);
            }

            while (in.hasNext()) {
                try {
                    // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    message = in.nextLine();
                    if (isCommand(message)) {
                        dealWithCommand(message);
                        continue;
                    }
                    if (message.equals("/mes")) {
                        sendMessage("Empty message");
                        continue;
                    }

                    broadcast(message);

                } catch (IOException e) {
                    System.err.println(GameMessages.CLIENT_ERROR + e.getMessage());
                    removePlayer(this);
                } finally {
                    removePlayer(this);
                }
            }*/
        }

        public void sendMessage(String message) {
            out.println(message);
            out.flush();
        }

        private void askName() {
            sendMessage(GameMessages.ENTER_NAME);
            name = in.nextLine();
            sendMessage("Hi, " + name);
        }

        private boolean isCommand(String message) {
            return message.startsWith("/");
        }

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

        public void setChosenCard(Card chosenCard) {
            this.chosenCard = chosenCard;
        }

        private void quitGame() {
            try {
                playerSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}