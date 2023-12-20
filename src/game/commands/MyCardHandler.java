package game.commands;

import game.GuessWhoGame;

public class MyCardHandler implements CommandHandler{
    @Override
    public void handleCommands(GuessWhoGame game, GuessWhoGame.PlayerHandler playerHandler) throws NullPointerException {
        //TODO quando houver imagem nas propriedades da Card, chamar essa propriedade para imprimir

        playerHandler.sendMessage(playerHandler.getChosenCard().getCharacterName());
    }
}
