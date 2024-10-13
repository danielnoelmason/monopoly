package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author danielmason
 * UI class handles inputs and outputs
 */
public class UI {

	/**
	 * Takes the string of what data required and asks user for input, returns as
	 * string
	 *
	 * @param label
	 * @return value
	 */
	public static String read(String label) {
		System.out.println("\nProvide " + label + ":");
		System.out.print(">");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String value = null;
		try {
			value = input.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		while (value.isEmpty()) {
			System.out.println("Provide Choice:");
			System.out.print(">");
			try {
				value = input.readLine();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return value;
	}

	/**
	 * Checks input for yes or no
	 * 
	 * @param label
	 * @return choice
	 */
	public static boolean yesNo(String label) {
		out(label);
		String choice = read("Enter Y/N:	(1/2 for testing purposes)");
		while (!(choice.contains("y") || choice.contains("Y") || choice.contains("n") || choice.contains("N")
				|| choice.contains("1")))
			choice = read("Enter Y/N");

		if (choice.contains("y") || choice.contains("Y") || choice.contains("1"))
			return true;
		if (choice.contains("n") || choice.contains("N") || choice.contains("2"))
			return false;

		return false;

	}

	/**
	 * Prints message
	 * 
	 * @param message
	 */
	public static void out(String message) {
		System.out.println(message);
	}

}
