import java.util.*;

public abstract class Player {
    protected Grid aGrid;
    /** Boats that still need to be place */
    protected Boats aBoats;
    /** Shots that have been fired */
    protected Shots aShots;

    public void printGrid() {
        aGrid.printBaseGrid();
        // Copy elements from iterable to aPlaceableBoats list
        aBoats = new Boats();
        aShots = new Shots();
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