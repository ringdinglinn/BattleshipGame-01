
import java.util.regex.*;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        aGrid = new OceanGrid(this); // circular reference!
    }

    public void hasWon(){
        System.out.println("Human has won!!!");
    }

    /** Asks user to place a bomb */
    public void setBomb() {
        while (true) {
            TerminalIO.writeLine("Please place a bomb: ");
            String input = TerminalIO.readLine();

            // Validate coordinate
            if (!validateCoordinateInputString(input)) {
                System.out.println("Please try again");
            } else {
                // convert coordinate string into Position object
                String[] inputStrings = input.split("");
                int x = Position.Letter.getOrdinalOfLetter(inputStrings[0]);
                int y = Integer.parseInt(inputStrings[1]);
                Position shotPos = Position.get(x, y);

                if (!isNewShot(shotPos)) {
                    System.out.println("You already placed a bomb here..");
                } else {
                    ShotResult result = getShotResult(shotPos);
                    if (result != ShotResult.MISS) {
                        TerminalIO.writeLine("You hit something!");
                        aShots.addShot(shotPos, result);
                        if (result == ShotResult.SUNK) {
                            updateShots();
                        }
                        updateGrid();
                    } else {
                        aShots.addShot(shotPos, ShotResult.MISS);
                        updateGrid();
                        TerminalIO.writeLine("You missed!");
                        break;
                    }
                }
            }
        }
    }

    protected void updateGrid(){
        aOpponent.printGrid();
        printGrid();
    }

    /** @pre boat != null */
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
            System.out.println("Nice! Boat placed");
        }
    }

    /* Returns whether a coordinate matches the regex pattern [A-J][0-9] */
    /** @pre pCoordinate != null */
    private boolean validateCoordinateInputString(String pCoordinate) {
        String pattern = "[A-J][0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pCoordinate);
        return m.find();
    }

    /** @pre pInput != null */
    private boolean validateBoatInputString(String pInput) {
        String pattern = "[A-J][0-9],[A-J][0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pInput);
        return m.find();
    }

    /* Returns whether the boat placement is valid */
    /** @pre boat != null */
    /** @pre startPos != null */
    /** @pre endPos != null */
    private boolean validateBoatInput(Position startPos, Position endPos, Boat boat) {
        if (startPos == null || endPos == null)
            return false;

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

    /** @pre input != null */
    /** @pre validateBoatInputString(input) == true */
    private Tuple<Position, Position> parseInput(String input) {
        String[] coordinates = input.split(",");
        if (coordinates.length > 2) {
            return new Tuple<Position, Position>(null, null);
        }

        // is correct format
        if (validateBoatInputString(input)) {
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

            return new Tuple<Position, Position>(startPos, endPos);
        }
        return new Tuple<Position, Position>(null, null);
    }
}
