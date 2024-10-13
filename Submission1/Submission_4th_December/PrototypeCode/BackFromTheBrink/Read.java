package BackFromTheBrink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * asks the user for input
 *
 */
public class Read {

	/**
	 * takes the string of what data required and asks user for input, returns as string
	 * @param label
	 * @return
	 */
	public static String read( String label ) {

		System.out.println( "\nProvide " + label + ":" );

		System.out.print( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}
}
