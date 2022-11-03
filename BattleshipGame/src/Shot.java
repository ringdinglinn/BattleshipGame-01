public class Shot {
    private Position aPosition;
    private ShotResult aShotResult;

    Shot(Position pPosition, ShotResult pShotResult) {
        aPosition = pPosition;
        aShotResult = pShotResult;
    }

    public Position getPosition() {
        return aPosition;
    }

    public ShotResult getShotResult() {
        return aShotResult;
    }

    public void setShotResult(ShotResult pResult) {
        aShotResult = pResult;
    }

}
