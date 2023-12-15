package game;

import server.Server;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame {

    private ExecutorService service;
    private final List<PlayerHandler> clients;

    public GuessWhoGame() {
        service = Executors.newFixedThreadPool(2);
    }
}