package gabrielsUtilities;

public class Randomizer {
	
	public static String RandomUnicodeString(int length) {
		String randomString = "";
		
		for (int i = 0; i < length; i++) 
			randomString += (char) ((int) (Math.random() * 65502) + 33);
		
		
		return randomString;
	}
	
}
