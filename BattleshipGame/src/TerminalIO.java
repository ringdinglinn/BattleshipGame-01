import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TerminalIO {

    /** Reads from console */
    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /** Writes to console */
    public static String writeLine(String aMessage) {
        System.out.println(aMessage);
        return aMessage;
    }
}
