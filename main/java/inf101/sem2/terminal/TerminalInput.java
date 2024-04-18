package inf101.sem2.terminal;

import java.util.Scanner;
import java.util.function.Function;

import inf101.sem2.player.AbstractPlayer;

/**
 * A class containing helper methods for reading input from a Scanner
 *
 * @author Martin Vatshelle - martin.vatshelle@uib.no
 */
public class TerminalInput {

	/**
	 * This method reads an int and makes sure a valid int is read.
	 * The name parameter could e.g. be "Player name" and would be used to
	 * print an error message when invalid input is given.
	 *
	 * @param sc          - the Scanner to read from
	 * @param description - The type of int to read
	 * @return a non empty name
	 */
	public static int readInt(Scanner sc) {
		Function<String,Integer> f = Integer::parseInt;
		return read(sc, f, "Integer");
	}

	/**
	 * Reads the next token from a Scanner();
	 *
	 * @param sc
	 * @return
	 */
	public static String readString(Scanner sc) {
		Function<String,String> f = (x) -> x;
		return read(sc, f, "Token");
	}

	/**
	 * This method reads a name and makes sure the name read is not empty.
	 * The name parameter could e.g. be "Player name" and would be used to
	 * print an error message when invalid input is given.
	 *
	 * @param sc   - the Scanner to read from
	 * @param name - The type of name
	 * @return a non empty name
	 */
	public static String readName(Scanner sc, String name) {
		Function<String,String> f = AbstractPlayer::validateName;
		return read(sc, f, name);
	}

	public static String readName(Scanner sc) {

		return readName(sc, "Name");
	}

	/**
	 * Reads in a specified input from a Scanner
	 * (typically the keyboard but not always)
	 * A Function is given as input to check if the input found in the Scanner
	 * is valid and convert it from String to the right return type.
	 * The converter should throw an Exception if input is invalid.
	 *
	 * @param <T>       - the return type of the reading
	 * @param sc        - the Scanner to read from
	 * @param converter - Function to check and convert input
	 * @param name      - This String is used to print error message
	 * @return
	 */
	private static <T> T read(Scanner sc, Function<String,T> converter, String name) {
		T out = null;
		while(out == null) {
			try {
				out = converter.apply(sc.next());
			} catch (Exception e) {
				out = null;
				System.err.println("Not a valid " + name + ", try again.");
			}
		}
		return out;
	}
}
