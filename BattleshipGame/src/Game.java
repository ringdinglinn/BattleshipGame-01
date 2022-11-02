import java.util.*;

public class Game {
    private List<Player> players = new ArrayList<Player>();
    private Turn aTurn = new Turn();

    public Game() {

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();

        players.add(computerPlayer);
        players.add(humanPlayer);

        for (Player player : players) {
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

    public void play() {
        // TODO: initialize player boards

        // turn = aTurn.getTurn() % players.size();
        // play game
        // while (true) {
        // for (Player player : players) {
        // code
        // }
        // }

        // throw new UnsupportedOperationException("not implemented yet");

        for (Player player : players) {
            player.setBoats();
        }
    }

}
