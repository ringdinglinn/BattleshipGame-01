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
        // Allow everyone to place boats
        for (Player player : players) {
            player.setBoats();
        }

        // play the game :)
        while (true) {
            int turn = aTurn.getTurn() % players.size();
            players.get(turn).setBomb();
            aTurn.incrementTurn();
        }
    }

}
