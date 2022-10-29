public class Grid {

    public void printBaseGrid() {
        for (int y = 0; y < 10; y++){
            System.out.print(y + "|");
            for (int x = 0; x < 10; x++){
                char c = displayPositionState(x, y);
                System.out.print(c + "|");
            }
            System.out.println(y);
        }
    }

    protected char displayPositionState(int x, int y){
        return ' ';
    }
}
