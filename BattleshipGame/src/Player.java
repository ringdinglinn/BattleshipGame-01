import java.util.*;

public abstract class Player {
    protected Grid aGrid;
    /** Boats that still need to be place */
    protected Boats aBoats = new Boats();
    /** Shots that have been fired */
    protected Shots aShots = new Shots();

    public void printGrid() {
        aGrid.printBaseGrid();
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

    protected void setBoat(Boat boat) {

    }

    public void setBomb() {

    }

    public boolean isNewShot(Position pShotPos) {
        // Make sure shot is unique
        for (Shot shot : aShots) {
            if (shot.getPosition().equals(pShotPos)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHit(Position pShotPos) {
        // Check if shot hit a boat
        for (Boat boat : aBoats) {
            if (boat.isHit(pShotPos)) {
                aShots.addShot(pShotPos, ShotResult.HIT);
                return true;
            }
        }
        aShots.addShot(pShotPos, ShotResult.MISS);
        return false;

    }

    protected boolean boatCollidesWithBoats(Position pStart, Position pEnd){
        // doesn't collide with boats
        boolean collidesWithBoats = false;
        Iterator<Position> itr = Position.getPositionsFromTo(pStart, pEnd);

        while (itr.hasNext()){
            if (aBoats.positionIsOccupied(itr.next())) collidesWithBoats = true;
        }

        return collidesWithBoats;
    }

    public boolean positionIsOccupied(Position pPos){
        return aBoats.positionIsOccupied(pPos);
    }

    public char getBoatTypeByPosition(Position pPos) {
        return aBoats.getBoatTypeByPosition(pPos);
    }

}