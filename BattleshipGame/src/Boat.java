import java.util.*;

public class Boat implements Iterable<Position> {
    private final int aLength;
    private final char aLetter;
    private Position aStartPos;
    private Position aEndPos;
    private int hitsCounter = 0;
    private boolean isSunk = false;

    /** Returns true if the boat is placed */
    public boolean isPlaced(){
        return aStartPos != null && aEndPos != null;
    }

    public Boat(int pLength, char pLetter) {
        this.aLength = pLength;
        this.aLetter = pLetter;
    }

    /** @pre pStartPos != null && pEndPos != null */
    public void setPositions(Position pStartPos, Position pEndPos) {
        assert pStartPos != null && pEndPos != null;
        this.aStartPos = pStartPos;
        this.aEndPos = pEndPos;
    }

    /** @pre shot != null */
    /** @pre this.isPlaced == true; */
    public ShotResult isHit(Position shot) {
        return shot.within(aStartPos, aEndPos) ? ShotResult.HIT : ShotResult.MISS;
    }

    /** @pre this.isPlaced == true; */
    public ShotResult evaluateIsSunk() {
        hitsCounter += 1;
        if (hitsCounter == aLength){
            isSunk = true;
            return ShotResult.SUNK;
        } else {
            return ShotResult.HIT;
        }
    }

    /** @pre this.isPlaced == true; */
    public boolean getIsSunk(){
        return isSunk;
    }

    public int getLength() {
        return aLength;
    }

    public char getLetter() {
        return aLetter;
    }

    /** @pre this.isPlaced == true; */
    public Iterator<Position> iterator(){
        return Position.getPositionsFromTo(aStartPos, aEndPos);
    }
    // public Boat get(int pLength, char pLetter) {
    // return new Boat(pLength, pLetter);
    // }
}
