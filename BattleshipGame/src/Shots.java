import java.util.*;

public class Shots {
    private Map<String, ShotResult> aShots = Collections.emptyMap();;

    public Map<String, ShotResult> getShots() {
        return aShots;
    }

    /**
     * @param pPosition   accepts only valid positions
     * @param pShotResult accepts ShotResult enum
     */
    public void addShot(String pPosition, ShotResult pShotResult) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
