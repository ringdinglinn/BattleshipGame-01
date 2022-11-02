import java.util.*;

public class Position {
    private final int aX;
    private final int aY;

    /**
     * 
     * @pre x >= 0 && x <= 9
     * @pre y >= 0 && y <= 9
     */
    public Position(int pX, int pY) {
        aX = pX;
        aY = pY;
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
     *  @pre pPos1.getX() < pPos2.getY() || pPos2.getY() < pPos.getY() */
    public boolean within(Position pPos1, Position pPos2) {
        assert pPos1 != null && pPos2 != null;

        if (pPos1.getX() == pPos2.getX()){ // vertical
            return (pPos1.getY() <= aY && pPos2.getY() >= aY) && aX == pPos1.getX();
        } else if (pPos1.getX() == pPos2.getX()){ // horizontal
                return (pPos1.getX() <= aX && pPos2.getX() >= aX) && aY == pPos1.getY();
        } else {
            return false;
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
