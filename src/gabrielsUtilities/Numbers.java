package gabrielsUtilities;

public interface Numbers {
	
	public default double roundToDecimals(double mathematical, int amountOfDecimals) {
		return (((int) (mathematical * (Math.pow(10.0, amountOfDecimals))) + 0.0) / (Math.pow(10.0, amountOfDecimals)));
	}
	
}
