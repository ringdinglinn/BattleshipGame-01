import java.util.*;

public abstract class Player {
    protected Grid aGrid;
    /** Boats that still need to be place */
    protected List<Boat> aPlaceableBoats;
    /** Placed boats */
    protected List<Boat> aBoats;
    /** Shots that have been fired */
    protected Shots aShots;

    public void printGrid() {
        aGrid.printBaseGrid();
        // Copy elements from iterable to aPlaceableBoats list
        new Boats().getBoats().forEach(aPlaceableBoats::add);
        aBoats = new ArrayList<Boat>(new Boats().getSize());
        aShots = new Shots();
    }

    public void setBomb() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /** Returns all shots made by a player */
    public Iterator<Position> getShots() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /** Returns all boats of a player */
    public Iterator<Position> getBoats() {
        throw new UnsupportedOperationException("not implemented yet");
    }

}