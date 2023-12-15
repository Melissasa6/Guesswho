package game;

import server.Server;

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

    public void broadcast() {

    }

    public class PlayerHandler implements Runnable {

        private String name;
        private Socket playerSocket;
        private Character[] characterList;
        private Character chosenCharacter;


        public PlayerHandler(Socket playerSocket) {
            this.playerSocket =playerSocket;
        }

        @Override
        public void run() {

        }
    }
    @Override
    public void run() {
        while (true) {
            if (canGameStart()) {




            }
        }
    }
}