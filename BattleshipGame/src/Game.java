import java.util.*;

public class Game {
    private List<Player> players = new ArrayList<Player>();
    private Turn aTurn = new Turn();

    public Game() {

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();

        players.add(computerPlayer);
        players.add(humanPlayer);

        humanPlayer.setOpponent(computerPlayer);
        computerPlayer.setOpponent(humanPlayer);
    }

    private class Turn {
        private int aTurns;

        public Turn() {
            aTurns = 0;
        }

        public void incrementTurn() {
            aTurns += 1;
        }

        public int getTurn() {
            return aTurns;
        }
    }

    public void play() {
        updateGrids();
        // Allow everyone to place boats
        for (Player player : players) {
            player.setBoats();
        }
        updateGrids();

        // play the game :)
        while (true) {
            int turn = aTurn.getTurn() % players.size();
            players.get(turn).setBomb();
            if (evaluateGameState()) {
                break;
            }
            aTurn.incrementTurn();
        }
    }

    private boolean evaluateGameState(){
        for (Player player : players) {
            if (player.allBoatsDestroyed()) {
                player.getOpponent().hasWon();
                return true;
            }
        }
        return false;
    }

    private void updateGrids(){
        for (Player player : players) {
            player.printGrid();
        }
    }
}
