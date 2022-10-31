public class Position {
    private final String x;
    private final String y;

    /**
     * 
     * @param x Only valid input [A-J]
     * @param y Only valid input [0-9]
     */
    public Position(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
