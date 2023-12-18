package game;

import game.Ascii_art.Colors;

public class Card {
    /*
    Properties of each game.Character:
    - Name
    - Hair color
    - Shirt color
    - Eye color
    - Glasses
    - Hat
    - Mustache
    - Smiling
     */

    private final String characterName;
    private final Colors shirtColor;
    private final Colors hairColor;
    private final Colors eyeColor;
    private final boolean glasses;
    private final boolean mustache;

    public Card(String characterName, Colors hairColor, Colors shirtColor, Colors eyeColor, boolean glasses, boolean hat, boolean mustache, boolean smile){
        this.characterName = characterName;
        this.hairColor = hairColor;
        this.shirtColor = shirtColor;
        this.eyeColor = eyeColor;
        this.glasses = glasses;
        this.mustache = mustache;
    }

    public String getCharacterName() {
        return characterName;
    }
    public Colors getHairColor() {
        return hairColor;
    }
    public Colors getShirtColor() {
        return shirtColor;
    }
    public Colors getEyeColor() {
        return eyeColor;
    }
    public boolean getGlasses(){
        return glasses;
    }
    public boolean getMustache(){
        return mustache;
    }
}