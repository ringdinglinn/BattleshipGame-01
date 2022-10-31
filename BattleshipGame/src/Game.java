import java.util.*;

public class Game {
    private List<Player> players = new ArrayList<Player>();
    private Turn aTurn = new Turn();

    public Game() {

        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();

        players.add(computerPlayer);
        players.add(humanPlayer);

        for ( Player player : players ){
            player.printGrid();
        }
    }

    private class Turn {
        private int aTurns;

        public Turn() {
            aTurns = 0;
        }

        public void incrementTurn() {
            aTurns = +1;
        }

        public int getTurn() {
            return aTurns;
        }
    }
}
