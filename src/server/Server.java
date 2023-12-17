package server;

import game.GuessWhoGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ExecutorService service;
    private ServerSocket serverSocket;
    //private List<GuessWhoGame> gameList;
    private static int PORT = 8080;

    public Server() {
        //gameList = new LinkedList<>();
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        service = Executors.newSingleThreadExecutor();
        System.out.println(ServerMessages.SERVER_START + port);

        GuessWhoGame game = new GuessWhoGame(this);
        service.execute(game);
        System.out.println(ServerMessages.GAME_CREATED);

        while (serverSocket.isBound()) {
            if (!game.isGameFull()){
                game.acceptPlayer(serverSocket.accept());
                System.out.println(ServerMessages.PLAYER_ADDED);
            }
        }
    }


    private void createGame() {
        GuessWhoGame game = new GuessWhoGame(this);
        //gameList.add(game);
        service.execute(game);
    }
}
