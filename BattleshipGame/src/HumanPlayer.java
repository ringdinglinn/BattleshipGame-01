public class HumanPlayer extends Player {
    public HumanPlayer() {
        aGrid = new OceanGrid();
    }

    /**
     * Computer player doesnt require that method as it sets everything during
     * initalisation
     */
    public void setBoat(Boat pBoat) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /** Returns whether all boats have been set */
    public boolean isAllSet() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
