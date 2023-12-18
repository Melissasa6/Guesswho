package game.Ascii_art;

public enum Colors {

    RESET("", "\u001B[0m"),
    YELLOW("yellow", "\u001B[33m"),
    GREEN("green", "\u001B[32m"),
    BLUE("blue", "\u001B[34m"),
    RED("red", "\u001B[31m"),
    PURPLE("purple", "\u001B[35m");
    private final String colour;
    private final String asciiCode;

    Colors(String colour, String acsColour){
        this.colour = colour;
        this.asciiCode = acsColour;
    }

    public String getAsciiCode() {
        return asciiCode;
    }

    @Override
    public String toString(){
        return this.colour;
    }
}