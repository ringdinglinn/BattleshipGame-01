public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        aGrid = new TargetGrid(this); // circular reference
    }

    /**  */
    public void setBomb() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    protected void setBoat(Boat boat) {

    }

}
