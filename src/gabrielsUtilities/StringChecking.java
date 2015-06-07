package gabrielsUtilities;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**StringChecking Notes
 * 
 * @author lundquistg
 *
 *So this is a class of my own making, full of methods for checking if Strings match other Strings or if they are
 * part of an array, or if they are null, or whatever.
 * 
 *Right now I need to work on two things:
 * putting in all the debug stuff
 * finishing setMakeNotNull
 * 
 *This whole class is useful because it minimizes errors and all that jazz.
 * 
 */

public class StringChecking {
	
	public static int INPUT_DIALOG = 1;
	public static int SCANNER_NEXT = 2;
	
	public static int MESSAGE_DIALOG = 1;
	public static int SYSTEM_PRINTLN = 2;
	
	public static int PARSE_INTEGER = 3;
	public static int PARSE_BOOLEAN = 4;
	public static int PARSE_FLOAT = 5;
	public static int PARSE_DOUBLE = 6;
	public static int PARSE_LONG = 7;
	
	private static void getOutput(int methodOfOutput, String message) {
		switch (methodOfOutput) {
			case 1: JOptionPane.showMessageDialog(null, message);
				break;
			case 2: System.out.println(message);
				break;
		}
	}
	
	private static String getInput(int methodOfInput, int methodOfOutput, String message, Scanner inStream) {
		switch (methodOfInput) {
			case 1: return (String) JOptionPane.showInputDialog(message);
			case 2: getOutput(methodOfOutput, message);
				return inStream.nextLine();
		}
		
		return "Error: methodOfInput not entered correctly";
	}
	
	public static String[] setMakeMatchArray(String message, Object[] testIfMatches, Object[][] testIfMatches2,
			Object[][][] testIfMatches3, int amountOfDimensions, int methodOfInput, int methodOfOutput, Scanner inStream) {
		
		String toMatch = getInput(methodOfInput, methodOfOutput, message, inStream);
		int testIfMatchesLength;
		int testIfMatchesLength2;
		int testIfMatchesLength3;
		switch (amountOfDimensions) {
		
			case 1:
				testIfMatchesLength = testIfMatches.length;
				
				for (int i = 0; i < testIfMatchesLength; i++) 
					if (toMatch.equals(testIfMatches[i])) 
						return new String[]{toMatch, i + ""};
				break;
			
			case 2:
				testIfMatchesLength = testIfMatches2.length;
				testIfMatchesLength2 = testIfMatches2[0].length;
				
				for (int i = 0; i < testIfMatchesLength; i++) 
					for (int n = 0; n < testIfMatchesLength2; n++)
						if (toMatch.equals(testIfMatches2[i][n])) 
							return new String[]{toMatch, i + "", n + ""};
				break;
			
			case 3:
				testIfMatchesLength = testIfMatches3.length;
				testIfMatchesLength2 = testIfMatches3[0].length;
				testIfMatchesLength3 = testIfMatches3[0][0].length;
				
				for (int i = 0; i < testIfMatchesLength; i++) 
					for (int n = 0; n < testIfMatchesLength2; n++)
						for (int d = 0; d < testIfMatchesLength3; d++)
							if (toMatch.equals(testIfMatches3[i][n][d])) 
								return new String[]{toMatch, i + "", n + "", d + ""};
				break;
		}
		
		getOutput(methodOfOutput, "Enter a string in the array, please");
		
		return setMakeMatchArray(message, testIfMatches, testIfMatches2, testIfMatches3, amountOfDimensions, methodOfInput,
				methodOfOutput, inStream);
	}
	
//working on this	
	public static String setMakeNotNull(String message, int methodOfInput, int methodOfOutput, Scanner inStream) {
		if (setCheckForNull(message)) {
			message = getInput(methodOfInput, methodOfOutput, "Enter SOMETHING", inStream);
			return setMakeNotNull(message, methodOfInput, methodOfOutput, inStream);
		} else 
			return message;
	}
	
	public static boolean setCheckForNull(String message) {
		try {
			message.equals(null);
			return false;
		} catch (NullPointerException nooo) {
			return true;
		}
	}
	
	public static String setMakeMatchFormat(String toMatch, int methodOfParsing, int methodOfInput, int methodOfOutput,
			Scanner inStream) {
		
		if (setCheckForNull(toMatch)) {
			toMatch = getInput(methodOfInput, methodOfOutput, "Enter SOMETHING", inStream);
			return setMakeMatchFormat(toMatch, methodOfParsing, methodOfInput, methodOfOutput, inStream);
		} else if (!setMatchFormat(toMatch, methodOfParsing)) {
			switch (methodOfParsing) {
				case 3: toMatch = getInput(methodOfInput, methodOfOutput, "Enter an INTEGER", inStream);
					break;
				case 4: toMatch = getInput(methodOfInput, methodOfOutput, "Enter a BOOLEAN", inStream);
					break;
				case 5: toMatch = getInput(methodOfInput, methodOfOutput, "Enter a FLOAT", inStream);
					break;
				case 6: toMatch = getInput(methodOfInput, methodOfOutput, "Enter a DOUBLE", inStream);
					break;
				case 7: toMatch = getInput(methodOfInput, methodOfOutput, "Enter a FLOAT", inStream);
					break;
			} return setMakeMatchFormat(toMatch, methodOfParsing, methodOfInput, methodOfOutput, inStream);
		} else 
			return toMatch;
		
	}
	
	public static boolean setMatchFormat(String toMatch, int methodOfParsing) {
		
		try {
			if (toMatch.equals(null)) return false;
		} catch (NullPointerException oohhh) {
			return false;
		}
		
		try {
			
			switch (methodOfParsing) {
				case 3: Integer.parseInt(toMatch);
					break;
				case 4: Boolean.parseBoolean(toMatch);
					break;
				case 5: Float.parseFloat(toMatch);
					break;
				case 6: Double.parseDouble(toMatch);
					break;
				case 7: Long.parseLong(toMatch);
					break;
			} return true;
			
		} catch (NumberFormatException haugh) {
			return false;
		}
		
	}
	
	public static String setMakeMatchInterval(String toMatch, int methodOfInput, int methodOfOutput, Scanner inStream,
			int minimum, int maximum) {
		
		int toMatchNum = Integer.parseInt(setMakeMatchFormat(toMatch, PARSE_INTEGER, methodOfInput, methodOfOutput,
				inStream));
		
		if (toMatchNum < minimum || toMatchNum > maximum) {
			toMatch = getInput(methodOfInput, methodOfOutput, "Enter a number BETWEEN " + (minimum - 1) + " AND "
					+ (maximum + 1), inStream);
			return setMakeMatchInterval(toMatch, methodOfInput, methodOfOutput, inStream, minimum, maximum);
		} else 
			return toMatch;
		
	}
	
}
