package game;

import game.Ascii_art.Winner;
import game.commands.Command;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame implements Runnable{

    private Server server;
    private ExecutorService service;
    private final List<PlayerHandler> players;
    private final int MAX_PLAYERS = 2;
    private boolean isGameStarted;
    private boolean isGameEnded;

    public GuessWhoGame(Server server) {
        this.server = server;
        service = Executors.newFixedThreadPool(MAX_PLAYERS);
        players = new CopyOnWriteArrayList<>();
        isGameStarted = false;
        isGameEnded = false;
    }

    @Override
    public void run() {
        if (canGameStart()) {
            isGameStarted = true;
            while (!isGameEnded) {
                playTurn();
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

    public boolean canGameStart() {
        return isGameFull();
    }

    public void playTurn() {

    }



























































































    private void addPlayer(PlayerHandler playerHandler) {
        players.add(playerHandler);
        playerHandler.sendMessage(Winner.TITLE);
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }

    private void broadcast(String name, String message) {
        players.stream()
                .filter(handler -> !handler.getName().equals(name))
                .forEach(handler -> handler.sendMessage(name + ": " + message));
    }

    public void removePlayer(PlayerHandler clientConnectionHandler) {
        players.remove(clientConnectionHandler);

    }

    public Optional<PlayerHandler> getClientByName(String name) {
        return players.stream()
                .filter(clientConnectionHandler -> clientConnectionHandler.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public PlayerHandler getOpponent(PlayerHandler player) {
        if (players.get(0).equals(player)) {
            return players.get(1);
        }
        return players.get(0);
    }

    public class PlayerHandler implements Runnable {

        private String name;
        private String message;
        private Socket playerSocket;
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

        /*private void quitGame() {
            try {
                playerSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

    }

}