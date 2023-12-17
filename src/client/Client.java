package client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private boolean isPlayerTurn;

    public Client() {
        this.isPlayerTurn = false;
    }

    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.start("localhost", 8080); //change to constant variables
        } catch (IOException e) {
            System.out.println("Disconnected.");
        }
        //client.readMessage();
    }


    private void start(String host, int port) throws IOException {
        clientSocket = new Socket(host,port);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        new Thread(new PlayerInput(out)).start();
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        clientSocket.close();

        //out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    private void readMessage() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        try {
            String inputFromServer = in.readLine();
            if (inputFromServer == null){
                System.out.println("You have been disconnected...");
                return;
            }
            System.out.println(inputFromServer);
            readMessage();
        } catch (IOException e) {
            throw new RuntimeException("No message");
        }
    }


    private class PlayerInput implements Runnable {
        private PrintWriter out;
        private BufferedReader in;

        public PlayerInput(PrintWriter out) {
            this.out = out;
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }
        @Override
        public void run() {
            while (!clientSocket.isClosed()) {
                while (!clientSocket.isClosed()) {
                    try {
                        String line = in.readLine();

                        out.println(line);
                        out.flush();

                        if (line.equals("/quit")) {
                            clientSocket.close();
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        System.out.println("Something went wrong with the server. Connection closing...");
                        try {
                            clientSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }}
        }
    }
}