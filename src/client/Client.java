package client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start("localhost", 8080);
        } catch (IOException e) {
            System.out.println("Connection closed...");
        }

    }

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

    private class PlayerInput implements Runnable {
        private BufferedWriter out;
        private Socket playerSocket;
        private BufferedReader in;

        public PlayerInput(BufferedWriter out, Socket playerSocket) {
            this.out = out;
            this.playerSocket = playerSocket;
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }

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
