import java.util.*;

public class Game {
    private List<Player> players = new ArrayList<Player>();

    public Game() {

        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();

        players.add(computerPlayer);
        players.add(humanPlayer);

        for ( Player player : players ){
            player.printGrid();
        }
    }

    public void runGame() {

    }
}
