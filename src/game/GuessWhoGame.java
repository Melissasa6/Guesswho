package game;

import game.Ascii_art.Winner;
import game.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuessWhoGame implements Runnable{

    private ExecutorService service;
    private final List<PlayerHandler> players;
    private final int MAX_PLAYERS = 2;
    private boolean isGameStarted;
    private boolean isGameFinished;

    public GuessWhoGame() {
        service = Executors.newFixedThreadPool(MAX_PLAYERS);
        players = new ArrayList<>();
        isGameStarted = false;
        isGameFinished = false;
    }

    @Override
    public void run() {
        while (!isGameFinished) {
            if (checkIfGameCanStart() && !isGameStarted) {
                startGame();
            }
            if (isGameStarted) {
                playRound();
            }
        }
        finishGame();
    }

    public boolean isGameFull(){
        return players.size() == MAX_PLAYERS;
    }

    public void acceptPlayer(Socket playerSocket) {
        PlayerHandler player = new PlayerHandler(playerSocket);
        service.submit(player);
    }

    private synchronized boolean checkIfGameCanStart() {
        return isGameFull() && (players.get(0).getName() != null) && (players.get(1).getName() != null);
    }
    private void startGame() {
        System.out.println("Game started...");
        this.isGameStarted = true;
        choosePlayerCard();
        broadcast(GameMessages.START_GAME);
    }

    public void playRound() {
        for (PlayerHandler player : players) {

            PlayerHandler opponent = player.getOpponent();

            player.sendMessage(GameMessages.PLAYER_TURN);
            opponent.sendMessage(String.format(GameMessages.OPPONENT_TURN, player.getName()));
            while (true) {
                if (player.getMessage() == null || opponent.getMessage() == null) {
                    continue;
                }
                String answer;
                if (player.getMessage().equals("/question") || player.getMessage().equals("/guess")) {
                    answer = opponent.getMessage();
                    if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }
        }
    }

    private void addPlayer(PlayerHandler playerHandler) {
        players.add(playerHandler);
        playerHandler.sendMessage(Winner.TITLE);
        playerHandler.sendMessage(GameMessages.COMMAND_HELP);
    }

    public void broadcast(String message) {
        players.forEach(playerHandler -> playerHandler.sendMessage(message));
    }

    private void choosePlayerCard() {
        Random rand = new Random();
        PlayerHandler player1 = players.get(0);
        PlayerHandler player2 = players.get(1);
        player1.setChosenCard(player1.cardList.get(rand.nextInt(player1.cardList.size() - 1)));
        player2.setChosenCard(player2.cardList.get(rand.nextInt(player2.cardList.size() - 1)));
    }

    public void removePlayer(PlayerHandler clientConnectionHandler) {
        players.remove(clientConnectionHandler);
    }

    public Optional<PlayerHandler> getClientByName(String name) {
        return players.stream()
                .filter(clientConnectionHandler -> clientConnectionHandler.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public void finishGame() {
        players.forEach(PlayerHandler::quitGame);
    }

    public class PlayerHandler implements Runnable {

        private String name;
        private String message;
        public Socket playerSocket;
        private PrintWriter out;
        private Scanner in;
        private List<Card> cardList;
        private Card chosenCard;

        public PlayerHandler(Socket playerSocket) {
            this.playerSocket = playerSocket;
            try {
                out = new PrintWriter(playerSocket.getOutputStream(), true);
                in = new Scanner(playerSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            cardList = BoardFactory.characterList();
        }

        @Override
        public void run() {
            addPlayer(this);
            askName();
            if (players.size() < MAX_PLAYERS) {
                sendMessage(GameMessages.WAITING_FOR_PLAYER_JOIN);
            }

            try {
                in = new Scanner(playerSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (in.hasNext()) {
                try {

                    message = in.nextLine();
                    if (isCommand(message)) {
                        dealWithCommand(message);
                        continue;
                    }
                    if (message.equals("")) {
                        System.out.println("Empty message");
                        // continue;
                    }

                    sendMessageToOpponent(message);

                } catch (IOException e) {
                    System.err.println(GameMessages.CLIENT_ERROR + e.getMessage());
                    removePlayer(this);
                }

            }
        }

        public void sendMessage(String message) {
            out.println(message);
            out.flush();
        }

        public PlayerHandler getOpponent() {
            if (players.get(0).equals(this)) {
                return players.get(1);
            }
            return players.get(0);
        }
        public void sendMessageToOpponent(String message) {
            getOpponent().out.println(name + ": " + message);
            out.flush();
        }

        private void askName() {
            sendMessage(GameMessages.ENTER_NAME);
            name = in.nextLine();
            sendMessage("Hi, " + name);
        }

        private boolean isCommand(String message) {
            return message.startsWith("/");
        }

        private void dealWithCommand(String message) throws IOException {
            String description = message.split(" ")[0];
            Command command = Command.getCommandFromDescription(description);

            command.getHandler().handleCommands(GuessWhoGame.this, this);
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }

        public Card getChosenCard() {
            return chosenCard;
        }

        public Scanner getIn() {
            return in;
        }

        public void setChosenCard(Card chosenCard) {
            this.chosenCard = chosenCard;
        }

        private void quitGame() {
            try {
                playerSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}