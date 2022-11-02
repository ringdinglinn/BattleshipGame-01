import java.util.*;
import java.util.regex.*;

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

    // TODO: design by contract
    /**  */
    public void setBomb() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    protected void placeSingleBoat(Boat boat) {
        TerminalIO.writeLine("Please enter coordinates of start and end of " + boat.getLetter() + ", " + boat.getLength() + " fields");
        String input = TerminalIO.readLine();

        if (validateBoatInput(input, boat)) {
            System.out.println("nice!");
        } else {
            System.out.println("Please try again");
            placeSingleBoat(boat);
        }
    }

    private boolean validateBoatInput(String input, Boat boat) {
        boolean isValid = false;
        String pattern = "[A-J][0-9],[A-J][0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        // is correct format
        if (m.find()){
            String result = m.group(0);

            char[] inputs = {
                result.charAt(0),
                result.charAt(1),
                result.charAt(3),
                result.charAt(4)
            };

            int y1 = inputs[1] - 48;
            int y2 = inputs[3] - 48;

            int x1 = Position.Letter.getOrdinalOfLetter(String.valueOf(inputs[0]));
            int x2 = Position.Letter.getOrdinalOfLetter(String.valueOf(inputs[2]));

            // is horizontal or vertical
            if (x1 == x2 || y1 == y2) {
                isValid = true;
                System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);

                // is of correct length
                if ((x1 == x2 && x2 - x1 == boat.getLength()) || (y1 == y2 && y2 - y1 == boat.getLength())) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
}
