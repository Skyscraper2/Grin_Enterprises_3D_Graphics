package graphics;

public class Perspective {

	/** getPos
	 * 
	 * theoretically should only be used by getVertPos and getHoriPos, which is why it's protected
	 * 
	 * all those doubles are for my sake, so debugging is easier; will change once these are set
	 * 
	 * @param pACoord
	 * @param pBCoord
	 * @param viewPointACoord
	 * @param viewPointBCoord
	 * @param viewAngle
	 * @param FOVAngle
	 * @param screenLength
	 * @return the distance of the point from the side of the frame; depends on what the other methods give it
	 * 
	 */
	protected double getPos(double pACoord, double pBCoord, double viewPointACoord, double viewPointBCoord,
			double viewAngle, double FOVAngle, int screenLength) {
		
		double angleFromViewAbsolute = Math.atan((pBCoord - viewPointBCoord) / (pACoord - viewPointACoord));
		double angleFromViewangle = (viewAngle + FOVAngle) - angleFromViewAbsolute;
		double distanceFromViewpoint = Math.sqrt(
				Math.pow(pACoord - viewPointACoord, 2.0) + Math.pow(pBCoord - viewPointBCoord, 2.0)
		);
		double distanceFromViewline = distanceFromViewpoint * Math.sin(angleFromViewangle);
		double distanceOfViewline = distanceFromViewpoint * Math.cos(angleFromViewangle);
		double lengthFrame = distanceOfViewline * Math.tan(FOVAngle);
		
		System.out.println("((" + lengthFrame + " / 2) + " + distanceFromViewline + ") * (" + screenLength + " / " 
				+ lengthFrame + ")");
		
		return ((lengthFrame / 2) + distanceFromViewline) * (screenLength / lengthFrame);
		
	}
	
	/** checkViewingAngleContinuous
	 * 
	 * the idea behind this one is it allows you to roll over angles
	 * make sure in implementation to change both upper and lower angles (chose to do it this way for efficiency)
	 * 
	 * @param lowerAngle
	 * @return lowerAngle if it's fine; lowerAngle + 2π is it's below zero; lowerAngle - 2π if it's above 2π
	 * 
	 */
	public double checkViewAngleContinuous(double lowerAngle) {
		double tau = 2 * Math.PI;
		
		if (lowerAngle < 0) 
			return lowerAngle += tau;
		
		else if (lowerAngle >= tau) 
			return lowerAngle -= tau;
		
		else 
			return lowerAngle;
		
	}
	
	/** checkViewAngleLimited
	 * 
	 * this just makes sure the use can't go above a certain angle
	 * 
	 * might also change this so that if they're at a certain angle they just can't move their mouse
	 * 
	 * make sure in implementation to change both upper and lower angles (chose to do it this way for efficiency)
	 * 
	 * @param lowerAngle
	 * @param fovAngle
	 * @param lowerLimit
	 * @param upperLimit
	 * @return lowerAngle if it's between the limits; the limit if it's above or below said limit
	 * 
	 */
	public double checkViewAngleLimited(double lowerAngle, double fovAngle, double lowerLimit, double upperLimit) {
		
		if (lowerAngle < lowerLimit - fovAngle) 
			return lowerAngle = lowerLimit - fovAngle;
		
		else if (lowerAngle > upperLimit - fovAngle) 
			return lowerAngle = upperLimit - fovAngle;
		
		else 
			return lowerAngle;
		
	}
	
}
