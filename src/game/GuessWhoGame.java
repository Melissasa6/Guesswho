package game;

import game.Ascii_art.Winner;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame implements Runnable{

    private Server server;
    private ExecutorService service;
    private final List<PlayerHandler> clients;
    private int MAX_PLAYERS = 2;
    private boolean isGameStarted;
    private boolean isGameEnded;

    public GuessWhoGame(Server server) {
        this.server = server;
        service = Executors.newFixedThreadPool(2);
        clients = new CopyOnWriteArrayList<>();
        isGameStarted = false;
        isGameEnded = false;
    }

    @Override
    public void run() {
        while (true) {
            if (canGameStart()) {

            }
        }
    }

    public boolean isGameFull(){
        return clients.size() == MAX_PLAYERS;
    }

    public void acceptPlayer(Socket playerSocket) {
        PlayerHandler player = new PlayerHandler(playerSocket);
        clients.add(player);
        service.submit(player);
    }

    public boolean canGameStart() {
        return isGameFull();
    }

    public void playTurn() {

    }
































































































    public class PlayerHandler implements Runnable {

        private String name;
        private Socket playerSocket;
        private PrintWriter out;
        private BufferedReader in;
        private Card[] cardList;
        private Card chosenCard;


        public PlayerHandler(Socket playerSocket) {
            this.playerSocket = playerSocket;
            try {
                out = new PrintWriter(playerSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            sendMessage(Winner.TITLE);
            sendMessage(GameMessages.WELCOME_MESSAGE);
            name = askName();

            sendMessage(GameMessages.COMMAND_HELP);

            if (clients.size() < MAX_PLAYERS) {
                sendMessage(GameMessages.WAITING_FOR_PLAYER_JOIN);
            }
            if (clients.size() == MAX_PLAYERS) {
                sendMessage(GameMessages.WAITING_FOR_PLAYER_NAME);
            }
        }

        private void sendMessage(String message) {
            out.println(message);
            out.flush();
        }

        private String askName() {
            sendMessage(GameMessages.ENTER_NAME);
            String userInput = null;
            try {
                userInput = in.readLine();
                if (userInput.length() < 3) {
                    sendMessage("Invalid name.");
                    askName();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return userInput;
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