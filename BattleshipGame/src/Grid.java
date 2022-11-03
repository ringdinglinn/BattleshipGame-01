public abstract class Grid {
    private final int aHeight = 10;
    private final int aWidth = 10;
    protected final Player aPlayer;

    public Grid(Player pPlayer){
        aPlayer = pPlayer;
    }

    public void printBaseGrid() {
        drawName();

        // print basic grid layout (later replace by looping through positions?)
        for (int y = -2; y <= aHeight + 2; y++) {
            boolean isInField = y > -1 && y < aHeight;
            boolean isLetters = y == -2 || y == aHeight + 1;
            boolean isLastLine = y == aHeight + 2;
            if (isInField) {
                System.out.print(y + "|");
                for (int x = 0; x < aWidth; x++) {
                    Position currentPosition = Position.get(x,y);
                    if (aPlayer.getOpponent().isNewShot(currentPosition)){ // is shot on field
                        System.out.print(displayPositionState(currentPosition));
                    } else {
                        Shot shot = aPlayer.getOpponent().aShots.getShotAtPosition(currentPosition);
                        System.out.print(displayShotState(shot));
                    }

                    System.out.print("|");
                }
                System.out.print(y);
            } else if (isLetters) {
                System.out.print(" ");
                for (int x = 0; x < aWidth; x++) {
                    System.out.print(" " + Position.Letter.getNameByOrdinal(x));
                }
            } else if (!isLastLine) {
                System.out.print(" +");
                for (int x = 0; x < aWidth; x++) {
                    System.out.print("-+");
                }
            } else {
                System.out.print("=");
                for (int x = 0; x <= aWidth; x++) {
                    System.out.print("==");
                }
            }
            System.out.println("");
        }
        drawDivisionLine(aWidth);
    }

    abstract void drawDivisionLine(int pWidth);

    abstract void drawName();

    abstract char displayShotState(Shot shot);
    abstract char displayPositionState(Position currentPosition);
}
