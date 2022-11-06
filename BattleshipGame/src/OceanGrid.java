public class OceanGrid extends Grid {
    /** @pre pShot != null */
    protected char displayShotState(Shot pShot) {
        if (pShot.getShotResult() == ShotResult.HIT){
            return 'X';
        } else if (pShot.getShotResult() == ShotResult.MISS){
            return 'o';
        }
        return ' ';
    }

    /** @pre pPos != null */
    protected char displayPositionState(Position pPos) {
        if (aPlayer.positionIsOccupied(pPos)) { // is a boat on field
            return aPlayer.getBoatTypeByPosition(pPos);
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
