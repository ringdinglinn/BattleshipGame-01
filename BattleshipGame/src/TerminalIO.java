import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalIO {

    /** Reads from console */
    public String readLine() throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        return reader.readLine();
    }

    /** Writes to console */
    public String writeLine(String aMessage) {
        System.out.println(aMessage);
        return aMessage;
    }
}
