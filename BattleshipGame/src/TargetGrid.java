public class TargetGrid extends Grid {
    /** @pre shot != null */
    protected char displayShotState(Shot pShot) {
        if (pShot.getShotResult() == ShotResult.HIT){
            return 'X';
        } else if (pShot.getShotResult() == ShotResult.MISS){
            return 'o';
        } else if (pShot.getShotResult() == ShotResult.SUNK) {
            return aPlayer.getBoatTypeByPosition(pShot.getPosition());
        }
        return ' ';
    }

    /** @pre pPos != null */
    protected char displayPositionState(Position pPos) {
        if (aPlayer.isHidden()) {
            return ' ';
        } else {
            if (aPlayer.positionIsOccupied(pPos)) { // is a boat on field
                return aPlayer.getBoatTypeByPosition(pPos);
            } else {
                return ' ';
            }
        }
    }

    public TargetGrid(Player pPlayer){
        super(pPlayer);
    }

    @Override
    protected void drawDivisionLine(int pWidth) {
        System.out.println("");
        System.out.print("-");
        for (int x = 0; x <= pWidth; x++){
            System.out.print("--");
        }
        System.out.println("");
        System.out.println("");
    }

    @Override
    protected void drawName(){
        System.out.println("===== TARGET GRID =====");
    }
}
