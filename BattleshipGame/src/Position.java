import java.util.*;

public class Position {
    private final int aX;
    private final int aY;

    private static int GRIDSIZE = 10;
    private static Position[][] aPositions = new Position[GRIDSIZE][GRIDSIZE];

    static {
        for (int x = 0; x < GRIDSIZE; x++){
            for (int y = 0; y < GRIDSIZE; y++){
                aPositions[x][y] = new Position(x,y);
            }
        }
    }

    /**
     * 
     * @pre x >= 0 && x <= 9
     * @pre y >= 0 && y <= 9
     */
    private Position(int pX, int pY) {
        aX = pX;
        aY = pY;
    }

    public static Position get(int pX, int pY){
        return aPositions[pX][pY];
    }

    public int getX() {
        return aX;
    }

    public int getY() {
        return aY;
    }

    public boolean equals(Position pPos) {
        return aX == pPos.getX() && aY == pPos.getY();
    }

    public int hashCode() {
        return Objects.hash(aX, aY);
    }

    /** @pre pPos1 != null && pPos2 != null;
     *  @pre pPos1.getX() < pPos2.getY() || pPos2.getY() < pPos.getY(); */
    public boolean within(Position pPos1, Position pPos2) {
        assert pPos1 != null && pPos2 != null;

        if (horizontallyAligned(pPos1, pPos2)){ // vertical
            return (pPos1.getY() <= aY && pPos2.getY() >= aY) && aX == pPos1.getX();
        } else if (verticallyAligned(pPos1, pPos2)){ // horizontal
                return (pPos1.getX() <= aX && pPos2.getX() >= aX) && aY == pPos1.getY();
        } else {
            return false;
        }
    }

    /** @pre pStart.getX() == pEnd.getX() || pStart.getY() == pEnd.getY();
     * @pre pStart != null && pEnd != null */
    public static Iterator<Position> getPositionsFromTo(Position pStart, Position pEnd){
        List<Position> positions = new ArrayList<Position>();

        if (horizontallyAligned(pStart, pEnd)) {
            for (int x = pStart.getX(); x <= pEnd.getX(); x++) {
                positions.add(Position.get(x, pStart.getY()));
            }
        } else {
            for (int y = pStart.getY(); y <= pEnd.getY(); y++) {
                positions.add(Position.get(pStart.getX(), y));
            }
        }

        return positions.iterator();
    }

    /** @pre pStart != null && pEnd != null; */
    public static boolean horizontallyAligned(Position pStart, Position pEnd) {
        return pStart.getY() == pEnd.getY();
    }

    /** @pre pStart != null && pEnd != null; */
    public static boolean verticallyAligned(Position pStart, Position pEnd) {
        return pStart.getX() == pEnd.getX();
    }

    /** @pre pStart.getX() == pEnd.getX() || pStart.getY() == pEnd.getY();
     * @pre pStart != null && pEnd != null */
    public static int distance(Position pStart, Position pEnd) {
        if (horizontallyAligned(pStart, pEnd)) {
            return pEnd.getX() - pStart.getX() + 1;
        } else  {
            return pEnd.getY() - pStart.getY() + 1;
        }
    }

    public enum Letter {
        A, B, C, D, E, F, G, H, I, J;

        public static int getOrdinalOfLetter(String input){
            int index = -1;
            for (Position.Letter letter : Position.Letter.values()) {
                if (letter.toString().equals(String.valueOf(input))) {
                    index = letter.ordinal();
                }
            }
            return index;
        }
    }
}
