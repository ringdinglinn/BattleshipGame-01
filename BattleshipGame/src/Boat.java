import java.sql.Array;
import java.util.*;

public class Boat implements Iterable<Position>{
    private final int aLength;
    private final char aLetter;
    private Position aStartPos;
    private Position aEndPos;
    private boolean isPlaced = false;

    /** Returns true if the boat is placed */
    public boolean getIsPlaced(){
        return isPlaced;
    }

    public void place(){
        isPlaced = true;
    }

    public Boat(int pLength, char pLetter) {
        this.aLength = pLength;
        this.aLetter = pLetter;
    }

    /** @pre pStartPos != null && pEndPos != null */
    public void setPositions(Position pStartPos, Position pEndPos){
        assert pStartPos != null && pEndPos != null;
        this.aStartPos = pStartPos;
        this.aEndPos = pEndPos;
    }

    public boolean isHit(Position shot){
        return shot.within(aStartPos, aEndPos);
    }

    public int getLength() {
        return aLength;
    }

    public char getLetter() {
        return aLetter;
    }

    public Iterator<Position> iterator(){
        List<Position> positions = new ArrayList<Position>();

        if (aStartPos.getX() == aEndPos.getX()) {
            for (int x = aStartPos.getX(); x <= aEndPos.getX(); x++) {
                positions.add(Position.get(x, aStartPos.getY()));
            }
        } else {
            for (int x = aStartPos.getX(); x <= aEndPos.getX(); x++) {
                positions.add(Position.get(x, aStartPos.getY()));
            }
        }

        return positions.iterator();
    }

    // public Boat get(int pLength, char pLetter) {
    // return new Boat(pLength, pLetter);
    // }
}
