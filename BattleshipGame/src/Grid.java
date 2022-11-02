public class Grid {
    private final int aHeight = 10;
    private final int aWidth = 10;

    public void printBaseGrid() {

        // print basic grid layout (later replace by looping through positions?)
        for (int y = 0; y < aHeight; y++) {
            System.out.print(y + "|");
            for (int x = 0; x < aWidth; x++) {
                char c = displayPositionState(x, y); // get the char to portray field -> overridden by subclasses
                System.out.print(c + "|");
            }
            System.out.println(y);
        }
    }

    public char displayPositionState(int x, int y) {
        return ' ';
        // throw new UnsupportedOperationException("not implemented yet");
    }
}
