import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        aGrid = new TargetGrid(this); // circular reference
    }
    private boolean isHidden = true;

    public void hasWon(){
        System.out.println("Computer has won!!!");
        isHidden = true;
    }

    /** Returns when there is a miss */
    public void setBomb() {
        System.out.println("set bomb (computer player)");
        while(true){
            System.out.println("in while loop (computer player)");
            int x = new Random().nextInt(10);
            int y = new Random().nextInt(10);

            Position shotPos = Position.get(x, y);

            if (isNewShot(shotPos)) {
                ShotResult result = getShotResult(shotPos);
                if (result != ShotResult.MISS) {
                    TerminalIO.writeLine("You hit something!");
                    aShots.addShot(shotPos, result);
                    if (result == ShotResult.SUNK) {
                        updateShots();
                    }
                    updateGrid();
                } else {
                    aShots.addShot(shotPos, ShotResult.MISS);
                    updateGrid();
                    TerminalIO.writeLine("You missed!");
                    break;
                }
            }
        }
    }

    protected void setBoat(Boat boat) {
        int coinflip = new Random().nextInt(2);

        if (coinflip == 0) {
            // generates all possible starting positions for vertical placement
            List<Position> possibleStartPos = new ArrayList<Position>();
            for (int y = 0; y <= 10 - boat.getLength(); y++) {
                for (int x = 0; x < 10; x++) {
                    possibleStartPos.add(Position.get(x, y));
                }
            }
            setAtRandomPosition(true, boat, possibleStartPos);

        } else {
            // generates all possible starting positions for horizontal placement
            List<Position> possibleStartPos = new ArrayList<Position>();
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x <= 10 - boat.getLength(); x++) {
                    possibleStartPos.add(Position.get(x, y));
                }
            }
            setAtRandomPosition(false, boat, possibleStartPos);
        }
    }

    /** Is bound to set a boat at a correct position */
    private void setAtRandomPosition(Boolean isVertical, Boat boat, List<Position> pPossibleStartPos) {
        int n = pPossibleStartPos.size();

        // select random startPos
        int randomStartIndex = new Random().nextInt(n);

        Position startPos = pPossibleStartPos.get(randomStartIndex);
        Position endPos;
        if (isVertical) {
            endPos = Position.get(startPos.getX(), startPos.getY() + boat.getLength() - 1);
        } else {
            endPos = Position.get(startPos.getX() + boat.getLength() - 1, startPos.getY());
        }

        // places boat until no collision occurs
        if (boatCollidesWithBoats(startPos, endPos)) {
            setAtRandomPosition(isVertical, boat, pPossibleStartPos);
        } else {
            boat.setPositions(startPos, endPos);
        }
    }

    protected boolean isHidden() {
        return isHidden;
    }

}
