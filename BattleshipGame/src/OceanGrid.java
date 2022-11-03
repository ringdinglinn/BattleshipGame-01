public class OceanGrid extends Grid {
    protected char displayPositionState(int x, int y) {
        return ' ';
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
