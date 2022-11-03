
import javax.sql.ConnectionPoolDataSource;
import java.util.Iterator;
import java.util.regex.*;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        aGrid = new OceanGrid(this); // circular reference!
    }

    /** Returns whether all boats have been set */
    public boolean isAllSet() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /** Asks user to place a bomb */
    public void setBomb() {
        TerminalIO.writeLine("Please place a bomb: ");
        String input = TerminalIO.readLine();

        // Validate coordinate
        if (!validateCoordinateInput(input)) {
            System.out.println("Please try again");
            setBomb();
        }

        // convert coordinate string into Position object
        String[] inpuStrings = input.split("");
        int x = Position.Letter.getOrdinalOfLetter(inpuStrings[0]);
        int y = Position.Letter.getOrdinalOfLetter(inpuStrings[1]);
        Position shotPos = Position.get(x, y);

        if (!isNewShot(shotPos)) {
            System.out.println("You already placed a bomb here..");
            setBomb();
        }

        if (isHit(shotPos)) {
            TerminalIO.writeLine("You hit something!");
            setBomb();
        }

        TerminalIO.writeLine("You missed!");
    }

    protected void setBoat(Boat boat) {
        TerminalIO.writeLine("Please enter coordinates of start and end of " + boat.getLetter() + ", "
                + boat.getLength() + " fields");
        String input = TerminalIO.readLine();

        Position startPos = parseInput(input).first;
        Position endPos = parseInput(input).second;

        if (!validateBoatInput(startPos, endPos, boat)) {
            System.out.println("Please try again");
            setBoat(boat);
        } else {
            boat.setPositions(startPos, endPos);
            printGrid();
            System.out.println("Nice! Boat placed");
        }
    }

    /* Returns whether a coordinate matches the regex pattern [A-J][0-9] */
    private boolean validateCoordinateInput(String pCoordinate) {
        String pattern = "[A-J][0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pCoordinate);
        return m.find();

    }

    /* Returns whether the boat placement is valid */
    private boolean validateBoatInput(Position startPos, Position endPos, Boat boat) {
        if (startPos == null || endPos == null) return false;

        boolean isValid = false;

        // is vertical or horizontal
        if (Position.verticallyAligned(startPos, endPos) || Position.horizontallyAligned(startPos, endPos)) {
            // is correct length
            if (Position.distance(startPos, endPos) == boat.getLength()) {
                // doesn't collide with other boats
                boolean collidesWithBoats = boatCollidesWithBoats(startPos, endPos);
                isValid = !collidesWithBoats;
            }
        }

        return isValid;
    }

    private Tuple<Position, Position> parseInput(String input) {
        String[] coordinates = input.split(",");
        if (coordinates.length > 2) {
            return new Tuple<Position, Position>(null, null);
        }

        // is correct format
        if (validateCoordinateInput(coordinates[0]) && validateCoordinateInput(coordinates[1])) {
            char[] inputs = {
                    input.charAt(0),
                    input.charAt(1),
                    input.charAt(3),
                    input.charAt(4)
            };

            int y1 = inputs[1] - 48;
            int y2 = inputs[3] - 48;

            int x1 = Position.Letter.getOrdinalOfLetter(String.valueOf(inputs[0]));
            int x2 = Position.Letter.getOrdinalOfLetter(String.valueOf(inputs[2]));

            Position startPos = Position.get(x1, y1);
            Position endPos = Position.get(x2, y2);

            return new Tuple<Position,Position>(startPos, endPos);
        }
        return new Tuple<Position, Position>(null, null);
    }
}
