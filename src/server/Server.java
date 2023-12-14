package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private ExecutorService service;
    private final List<ClientConnectionHandler> clients;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
    }

    public void start(int port) {

        try {
            serverSocket = new ServerSocket();
            service = Executors.newFixedThreadPool(2);
            int numberOfConnections = 0;
            System.out.printf(Messages.SERVER_START, port);

            while (true) {
                acceptConnection(numberOfConnections);
                ++numberOfConnections;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createGuessWho() {
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

    public static void main(String[] args) {

    }
}
