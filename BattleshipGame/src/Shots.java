import java.util.*;

public class Shots implements Iterable<Shot> {
    private List<Shot> aShots = new ArrayList<>();

    /** @pre pPos != null */
    public boolean contains(Position pPosition) {
        for (int i = 0; i < aShots.size(); i++) {
            if (aShots.get(i).getPosition() == pPosition) {
                return true;
            }
        }
        return false;
    }

    /**
     * @pre pPos != null 6& pShotResult != null
     * @pre contains(pPosition) == false
     */
    public void addShot(Position pPosition, ShotResult pShotResult) {
        aShots.add(new Shot(pPosition, pShotResult));
    }

    /** Returns a copy of the boats array as an Iterable<T> */
    public Iterable<Shot> getShots() {
        return new ArrayList<Shot>(aShots);
    }

    // TODO: add method to check if a given boat is sunk

    public Iterator<Shot> iterator() {
        return aShots.iterator();
    }

    /** @pre contains(pPos)
     *  @pre pPos != null */
    public Shot getShotAtPosition(Position pPos){
        for (Shot shot: aShots){
            if (shot.getPosition().equals(pPos)) return shot;
        }
        return null;
    }

}
