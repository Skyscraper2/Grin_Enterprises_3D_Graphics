package gabrielsUtilities;

/** StringCheckingNotes
 * 
 * @author lundquistg
 *
 *This whole class is full of various methods for equally spacing Strings of separate length. It doesn't format
 * everything for you yet, but if you need to line up a bunch of Strings in a .txt file or the console this is the
 * way to go.
 * 
 *I'm not working on anything right now in this class, but it probably will be updated.
 *
 */

public class Spacing {
	
	public static int setMaxNumberOfSpacesArray(String[] toBeSpaceds, int minSpaces) {
		int toBeSpacedsLength = toBeSpaceds.length;
//debug	System.out.println(toBeSpacedsLength);
		int indexOfMax = 0;
		
		for (int i = 0; i < toBeSpacedsLength; i++) {
			if (toBeSpaceds[i].length() > toBeSpaceds[indexOfMax].length()) indexOfMax = i;
		}
		
		return (toBeSpaceds[indexOfMax].length() + minSpaces);
	}
	
	public static String setNumberOfSpaces(String toBeSpaced, int totalCharacters) {
		String spaces = "";
//debug	System.out.println(totalSpace + " - " + name.length() + " =");
		
		int numSpaces;
		
		if (!StringChecking.setCheckForNull(toBeSpaced)) numSpaces = totalCharacters - toBeSpaced.length();
		else numSpaces = totalCharacters - 4;
		
//debug	System.out.println(numSpaces);
		
		for (int i = 0; i < numSpaces; i++) {
			spaces += " ";
		}
		
//debug	System.out.println("|" + spaces + "|");
		return spaces;
	}
	
}
