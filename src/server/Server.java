package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private ExecutorService service;
    private final List<ClientConnectionHandler> clients;

    public void start(int port) {

        try {
            serverSocket = new ServerSocket();
            service = Executors.newCachedThreadPool();
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

    }


    public static void main(String[] args) {

    }
}
