import java.util.*;

public class Shots implements Iterable<Shot> {
    private List<Shot> aShots;

    /**
     * @pre pPosition != null
     */
    public boolean contains(Position pPosition) {
        for (int i = 0; i < aShots.size(); i++) {
            if (aShots.get(i).getPosition() == pPosition) {
                return true;
            }
        }
        return false;
    }

    /**
     * @pre pPosition != null && pShotResult != null
     * @pre aShots.contain(pPosition) != false
     */
    public void addShot(Position pPosition, ShotResult pShotResult) {
        aShots.add(new Shot(pPosition, pShotResult));
    }

    /** Returns a copy of the boats array as an Iterable<T> */
    public Iterable<Shot> getBoats() {
        return new ArrayList<Shot>(aShots);
    }

    public Iterator<Shot> iterator() {
        return aShots.iterator();
    }

}
