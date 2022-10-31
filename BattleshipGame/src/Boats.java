import java.util.*;

public class Boats {
    private final Boat[] boats = {
            new Boat(6, 'C'),
            new Boat(4, 'B'),
            new Boat(4, 'B'),
            new Boat(3, 'S'),
            new Boat(3, 'S'),
            new Boat(3, 'S'),
            new Boat(2, 'P'),
            new Boat(2, 'P'),
            new Boat(2, 'P'),
            new Boat(2, 'P')
    };

    private final int aSize = boats.length;

    /** Returns size of boats array */
    public int getSize() {
        return aSize;
    }

    /** Returns a copy of the boats array as an Iterable<T> */
    public Iterable<Boat> getBoats() {
        return new ArrayList<Boat>(Arrays.asList(boats));
    }

    // ! Im not sure if this class should have the allSunk() method. I think this
    // ! belongs to player

}
