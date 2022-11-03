import java.util.*;

public class Boats implements Iterable<Boat> {
    private final List<Boat> aBoats = Arrays.asList(
            new Boat(6, 'C'),
            new Boat(4, 'B'),
            new Boat(4, 'B'),
            new Boat(3, 'S'),
            new Boat(3, 'S'),
            new Boat(3, 'S'),
            new Boat(2, 'P'),
            new Boat(2, 'P'),
            new Boat(2, 'P'),
            new Boat(2, 'P'));

    /** Returns size of boats array */
    public int getSize() {
        return aBoats.size();
    }

    /** Returns a copy of the boats array as an Iterable<T> */
    public Iterable<Boat> getBoats() {
        return new ArrayList<Boat>(aBoats);
    }

    public Iterator<Boat> iterator() {
        return aBoats.iterator();
    }

    public boolean positionIsOccupied(Position pPos) {
        boolean isOccupied = false;

        for (Boat boat : aBoats) {
            if (boat.isPlaced()){
                for (Position position : boat) {
                    if (pPos.equals(position)) isOccupied = true;
                }
            }
        }
        return  isOccupied;
    }

    /** @pre positionIsOccupied(pPos) == true */
    public char getBoatTypeByPosition(Position pPos) {
        char letter = ' ';

        for (Boat boat : aBoats) {
            if (boat.isPlaced()){
                for (Position position : boat) {
                    if (pPos.equals(position)) letter = boat.getLetter();
                }
            }
        }

        return letter;
    }

    public Boat getBoatByPosition(Position pPos) {
        for (Boat boat : aBoats) {
            if (boat.isPlaced()){
                for (Position position : boat) {
                    if (pPos.equals(position)) return boat;
                }
            }
        }
        return null;
    }

    public boolean allBoatsDestroyed() {
        for (Boat boat : aBoats) {
            if (!boat.getIsSunk()) {
                return false;
            }
        }
        return true;
    }
}
