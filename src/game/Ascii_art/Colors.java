package game.Ascii_art;

/**
 * Colors that are available to be used by the cards to create the characters
 */

public enum Colors {

    RESET("", "\u001B[0m"),
    YELLOW("yellow", "\u001B[93m"),
    GREEN("green", "\u001B[32m"),
    BLUE("blue", "\u001B[34m"),
    RED("red", "\u001B[31m"),
    ORANGE("orange", "\u001B[38;5;208m"),
    PINK("pink", "\u001B[38;5;206m"),
    BROWN("brown", "\u001B[38;5;94m"),
    GRAY("gray", "\u001B[38;5;240m"),
    PURPLE("purple", "\u001B[35m");
    private final String colour;
    private final String asciiCode;

    /**
     * Method constructor of the enum colors that accept two arguments
     * @param colour represents a human-readable color name
     * @param acsColour represents that colour in the console
     */

    Colors(String colour, String acsColour){
        this.colour = colour;
        this.asciiCode = acsColour;
    }

    public String getAsciiCode() {
        return asciiCode;
    }

    /**
     *
     * @return the human-readable color name
     */
    @Override
    public String toString(){
        return this.colour;
    }
}
