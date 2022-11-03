
import java.util.regex.*;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        aGrid = new OceanGrid();
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

        if (!validateBoatInput(input, boat)) {
            System.out.println("Please try again");
            setBoat(boat);
        }

        // TODO: place boat

        System.out.println("Nice! Boat placed");
    }

    /* Returns whether a coordinate matches the regex pattern [A-J][0-9] */
    private boolean validateCoordinateInput(String pCoordinate) {
        String pattern = "[A-J][0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pCoordinate);
        return m.find();

    }

    /* Returns whether the boat placement is valid */
    private boolean validateBoatInput(String input, Boat boat) {
        boolean isValid = false;

        String[] coordinates = input.split(",");
        if (coordinates.length > 2) {
            return false;
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

            // is horizontal or vertical
            if (x1 == x2 || y1 == y2) {
                System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);

                // is of correct length
                if ((x1 == x2 && y2 - y1 + 1 == boat.getLength()) || (y1 == y2 && x2 - x1 + 1 == boat.getLength())) {
                    System.out.println("correct Length");
                    boat.setPositions(Position.get(x1, y1), Position.get(x2, y2));

                    boolean collidesWithBoats = boatCollidesWithBoats(boat);
                    System.out.println(collidesWithBoats);
                    if (!collidesWithBoats) {
                        isValid = true;
                        boat.place();
                    }
                }
            }
        }
        return isValid;
    }

    public boolean boatCollidesWithBoats(Boat boat) {
        // doesn't collide with boats
        boolean collidesWithBoats = false;
        for (Position position : boat) {
            if (aBoats.positionIsOccupied(position))
                collidesWithBoats = true;
        }

        if (collidesWithBoats) {
            boat.setPositions(null, null);
        }

        return collidesWithBoats;
    }
}
