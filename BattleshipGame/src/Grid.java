public class Grid {
    public void printBaseGrid() {

        // print basic grid layout (later replace by looping through positions?)
        for (int y = 0; y < 10; y++){
            System.out.print(y + "|");
            for (int x = 0; x < 10; x++){
                char c = displayPositionState(x, y); // get the char to portray field -> overridden by subclasses
                System.out.print(c + "|");
            }
            System.out.println(y);
        }
    }

    private char displayPositionState(int x, int y) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
