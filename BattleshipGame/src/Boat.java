public class Boat {
    private final int aLength;
    private final char aLetter;
    private Position aStartPos;
    private Position aEndPos;

    /** Returns true if the boat is placed */
    public boolean getIsPlaced(){
        return aStartPos != null && aEndPos != null;
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

    // public Boat get(int pLength, char pLetter) {
    // return new Boat(pLength, pLetter);
    // }
}
