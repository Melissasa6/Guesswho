package game;

public enum Colors {

    BROWN("brown"),
    BLACK("black"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    RED("red"),
    WHITE("white");

    private final String colour;

    Colors(String colour){
        this.colour = colour;
    }

    @Override
    public String toString(){
        return this.colour;
    }
}
