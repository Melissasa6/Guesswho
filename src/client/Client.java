package client;

import java.io.*;
import java.net.Socket;

/**
 * Class that creates a remote client to join a server
 */
public class Client {

    /**
     * Main method of the class Client
     */
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start("localhost", 8080);
        } catch (IOException e) {
            System.out.println("Connection closed...");
        }

    }

    /**
     * Starts player connection in the specified port
     * Read and send messages to the server
     * @param host represents the IP address from the server
     * @param port represents the port number on which the server is waiting for connections.
     * Create a new thread to send messages to the server
     * @throws IOException if an error occurs  while creating the client socket
     */

    private void start(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(new PlayerInput(out, socket)).start();
        String line;
        while (( line = in.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
    }


    /**
     * PlayerInput Inner class implements the interface Runnable
     */
    private class PlayerInput implements Runnable {
        private BufferedWriter out;
        private Socket playerSocket;
        private BufferedReader in;


        /**
         * Constructor method to initialize the class
         */
        public PlayerInput(BufferedWriter out, Socket playerSocket) {
            this.out = out;
            this.playerSocket = playerSocket;
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }

        /**
         * Reads the input in console from the player
         */
        @Override
        public void run() {

            while (!playerSocket.isClosed()) {
                try {
                    String line = in.readLine();

                    out.write(line);
                    out.newLine();
                    out.flush();


                    if (line.equalsIgnoreCase("/quit")) {
                        playerSocket.close();
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Something went wrong with the server. Connection closing...");
                    try {
                        playerSocket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
