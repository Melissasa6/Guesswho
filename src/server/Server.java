package server;

import game.GuessWhoGame;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ServerSocket serverSocket;
    private GuessWhoGame game;
    private int connectedPlayers;
    private static int PORT = 8080;
    private int MAX_PLAYERS = 2;

    public Server() {
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.printf(ServerMessages.SERVER_START, port);

        while (serverSocket.isBound()) {

        }

    }

    private void createGame() {
        //create an instance of GuessWho game class
    }

    public void acceptConnection(int numberOfConnections) throws IOException {
        Socket clientSocket = serverSocket.accept();
        ClientConnectionHandler clientConnectionHandler = new ClientConnectionHandler(clientSocket);

    }

    public class ClientConnectionHandler implements Runnable {

        private String name;
        private final Socket clientSocket;
        private final BufferedWriter out;
        private String message;

        public ClientConnectionHandler(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.out = new BufferedWriter(new OutputStreamWriter((clientSocket.getOutputStream())));
        }

        @Override
        public void run() {

        }
    }
}
