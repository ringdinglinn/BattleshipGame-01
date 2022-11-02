import java.util.*;

public class Boats implements Iterable<Boat> {
    private final Boat[] aBoats = {
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

    private final int aSize = aBoats.length;

    /** Returns size of boats array */
    public int getSize() {
        return aSize;
    }

    /** Returns a copy of the boats array as an Iterable<T> */
    public Iterable<Boat> getBoats() {
        return new ArrayList<Boat>(Arrays.asList(aBoats));
    }

    public Iterator<Boat> iterator() {
        return Arrays.stream(aBoats).iterator();
    }

}
