package game;

import game.Ascii_art.Colors;

public class Card {

    private final String characterName;
    private final Colors hairColor;
    private final Colors eyeColor;
    private final Colors shirtColor;
    private final boolean glasses;
    private String asciiArt;

    /**
     * The constructor method that accepts 6 parametrs
     * @param characterName represents the name of the character
     * @param hairColor represents the hair colour of the character
     * @param eyeColor represents the eye colour of the character
     * @param shirtColor represents the shirt colour of the character
     * @param glasses represents the presence or not of glasses
     * @param asciiArt represents the art of the characters
     */
    public Card(String characterName, Colors hairColor, Colors eyeColor, Colors shirtColor, boolean glasses, String asciiArt){
        this.characterName = characterName;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.shirtColor = shirtColor;
        this.glasses = glasses;
        this.asciiArt = asciiArt;
    }

    public String getCharacterName() {
        return characterName;
    }
    public Colors getHairColor() {
        return hairColor;
    }
    public Colors getEyeColor() {
        return eyeColor;
    }
    public Colors getShirtColor() {
        return shirtColor;
    }
    public boolean getGlasses(){
        return glasses;
    }
    public String getAsciiArt() {
        return asciiArt;
    }

    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }
}