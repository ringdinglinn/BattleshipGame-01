public class TargetGrid extends Grid {
    protected char displayShotState(Shot shot) {
        if (shot.getShotResult() == ShotResult.HIT){ // get shot
            return 'X';
        } else if (shot.getShotResult() == ShotResult.MISS){
            return 'o';
        } else if (shot.getShotResult() == ShotResult.SUNK) {
            return aPlayer.getBoatTypeByPosition(shot.getPosition());
        }
        return ' ';
    }

    protected char displayPositionState(Position currentPosition) {
        if (aPlayer.isHidden()) {
            return ' ';
        } else {
            if (aPlayer.positionIsOccupied(currentPosition)) { // is a boat on field
                return aPlayer.getBoatTypeByPosition(currentPosition);
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
