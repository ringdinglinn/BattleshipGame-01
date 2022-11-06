import java.util.*;

public abstract class Player {
    protected Grid aGrid;
    /** Boats that still need to be place */
    protected Boats aBoats = new Boats();
    /** Shots that have been fired */
    protected Shots aShots = new Shots();
    protected Player aOpponent;

    public void printGrid() {
        aGrid.printBaseGrid();
    }

    public void setOpponent(Player pOpponent) {
        aOpponent = pOpponent;
    }

    public Player getOpponent() {
        return aOpponent;
    }

    /** Returns all shots made by a player */
    public Iterable<Shot> getShots() {
        return aShots.getShots();
    }

    /** Returns all boats of a player */
    public Iterable<Boat> getBoats() {
        return aBoats.getBoats();
    }

    public void setBoats() {
        for (Boat boat : aBoats) {
            setBoat(boat);
        }
    }

    /** @pre boat != null */
    protected void setBoat(Boat boat) {

    }

    public void setBomb() {

    }

    /** @pre pPos != null */
    public boolean isNewShot(Position pShotPos) {
        // Make sure shot is unique
        for (Shot shot : aShots) {
            if (shot.getPosition().equals(pShotPos)) {
                return false;
            }
        }
        return true;
    }

    /** @pre pPos != null */
    public ShotResult getShotResult(Position pShotPos) {
        // Check if shot hit a boat
        for (Boat boat : aOpponent.aBoats) {
            if (boat.isHit(pShotPos) == ShotResult.HIT) {
                // checks if boat is sunk
                // makes boat evaluate if sunk
                return boat.evaluateIsSunk();
            }
        }
        return ShotResult.MISS;
    }

    protected void updateShots() {
        for (Shot shot : aShots) {
            if (shot.getShotResult() == ShotResult.HIT) {
                if (aOpponent.getBoatAtPosition(shot.getPosition()).getIsSunk()) shot.setShotResult(ShotResult.SUNK);
            }
        }
    }

    /**
     * Returns true if boat placement coordinates intersect with a already placed
     * boat
     */
    protected boolean boatCollidesWithBoats(Position pStart, Position pEnd) {
        // doesn't collide with boats
        boolean collidesWithBoats = false;
        Iterator<Position> itr = Position.getPositionsFromTo(pStart, pEnd);

        while (itr.hasNext()) {
            if (aBoats.positionIsOccupied(itr.next()))
                collidesWithBoats = true;
        }

        return collidesWithBoats;
    }

    public boolean positionIsOccupied(Position pPos){
        return aBoats.positionIsOccupied(pPos);
    }

    public char getBoatTypeByPosition(Position pPos) {
        return aBoats.getBoatTypeByPosition(pPos);
    }

    public Boat getBoatAtPosition(Position pPos) {
        return aBoats.getBoatByPosition(pPos);
    }

    public boolean allBoatsDestroyed(){
        return aBoats.allBoatsDestroyed();
    }

    abstract void hasWon();

    protected void updateGrid(){
        printGrid();
        aOpponent.printGrid();
    }

    protected boolean isHidden(){
        return false;
    }
}