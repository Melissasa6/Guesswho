package server;

import game.GuessWhoGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class that creates the server, starts a game and waits for players
 * When a player arrives his socket will be sent to the game
 */
public class Server {

    private ExecutorService service;

    public ServerSocket serverSocket;
    private static final int PORT = 8080;
    /**
     * Constructor method
     */
    public Server() {
    }

    /** Main method of the class Server...*/
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Starts the server, creating a server socket and accepting players
     * @param port The port number on which the server will listen for incoming messages
     * @throws IOException if an error occurs while starting the server
     */
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        service = Executors.newSingleThreadExecutor();
        System.out.println(ServerMessages.SERVER_START + port);

        GuessWhoGame game = new GuessWhoGame();
        service.execute(game);
        System.out.println(ServerMessages.GAME_CREATED);

        while (serverSocket.isBound()) {
            if (!game.isGameFull()){
                game.acceptPlayer(serverSocket.accept());
                System.out.println(ServerMessages.PLAYER_ADDED);
            }
        }
    }
}
