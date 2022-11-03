public class TargetGrid extends Grid {
    protected char displayPositionState(int x, int y) {
        return ' ';
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
