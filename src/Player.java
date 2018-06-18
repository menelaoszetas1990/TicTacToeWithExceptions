public class Player {
    // private variable to keep the players name
    private String playerName;

    // special constructor to insert the player's name
    public Player( String name) {
        this.playerName = name;
    }

    // overriding toString method so we show the player's name instead
    @Override
    public String toString() {
        return playerName;
    }
}
