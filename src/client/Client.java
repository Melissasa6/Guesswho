package client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private BufferedWriter output;
    private BufferedReader input;
    private BufferedReader keyboardReader;

    public static void main(String[] args) {
        Client client = new Client();

        client.connectingToServer();
        client.readMessage();
    }

    private void connectingToServer() {
        try {
            this.clientSocket = new Socket("localhost",8080);
            start();
        } catch (IOException e) {
            System.out.println("Not Connected.");
        }

    }

    private void start() throws IOException {
        this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        this.keyboardReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void readMessage() {
        try {
            String inputFromServer = input.readLine();
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

    private String keyboardReader() {
        try {
            return keyboardReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}