public class OceanGrid extends Grid {
    protected char displayShotState(Shot shot) {
        if (shot.getShotResult() == ShotResult.HIT){ // get shot
            return 'X';
        } else if (shot.getShotResult() == ShotResult.MISS){
            return 'o';
        }
        return ' ';
    }

    protected char displayPositionState(Position currentPosition) {
        if (aPlayer.positionIsOccupied(currentPosition)) { // is a boat on field
            return aPlayer.getBoatTypeByPosition(currentPosition);
        } else {
            return ' ';
        }
    }

    public OceanGrid(Player pPlayer){
        super(pPlayer);
    }
    protected void drawName(){
        System.out.println("===== OCEAN GRID =====");
    }

    protected void drawDivisionLine(int pWidth){
        // prints nothing
    }
}
