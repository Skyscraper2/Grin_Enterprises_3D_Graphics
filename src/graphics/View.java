package graphics;

/** Notes on View
 * 
 * In code: vert and hori refer to the 2D image; x, y, and z refer to the 3D space
 * 
 * I'm hesitant to put limits like this on it, but what's gonna have to happen is you can only go
 * a certain max angle up or down. 
 * 
 * Hm y'know what
 * 
 * I'll keep the method for continuous rotation generic, and just apply it as necessary
 * maybe in a child to this or something
 * 
 * there will be a problem with drawing points that are off screen. 
 * The thing is, if I want to draw polygons, sometimes the associated points will be off-screen
 * hopefully the thing can still get coordinates for stuff that's off screen.
 * We'll see
 * 
 * @author lundquistg
 * 
 */
public class View
		extends Perspective {
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	
	protected int screenWidth; //width of the screen you're displaying on to convert to
	protected int screenHeight; //height of the screen you're displaying on to convert to
	protected double vertFOVAngle; //half the angle of the horizontal FOV, just because half comes up more
	protected double horiFOVAngle; //half the angle of the vertical FOV, just because half comes up more
	protected double vertViewAngle; //the angle above the xz-plane that the center of the view is
	protected double horiViewAngle; //the angle in front of the xy-plane that the center of the view is
//n/m	protected double sideViewAngle; //the angle to the side of the yz-plane that the center of the view is
	protected Point viewPoint; //the point from which the lines of the view radiate
	protected Space viewSpace; //the space the view is viewing
	
	public View() {
		screenWidth = 600;
		screenHeight = 600;
		vertFOVAngle = 5 * Math.PI / 12; //remember, half the angle
		horiFOVAngle = vertFOVAngle * (screenHeight / screenWidth);;
		vertViewAngle = 0;
		horiViewAngle = Math.PI / 4;
//n/m		sideViewAngle = 0;
		viewPoint = new Point(); //'cos default is at 0, 0, 0
		viewSpace = new Space();
	}
	
	/** View
	 * 
	 * @param width
	 * @param height
	 * @param vertFOV
	 * @param horiFOV
	 * @param startingVertViewAngle
	 * @param startingHoriViewAngle
	 * @param startingLocation
	 * @param spaceViewed
	 */
	public View(int width, int height, double vertFOV, double horiFOV, double startingVertViewAngle, 
			double startingHoriViewAngle, /*double startingSideViewAngle, */Point startingLocation, 
			Space spaceViewed) {
		screenWidth = width;
		screenHeight = height;
		vertFOVAngle = vertFOV;
		horiFOVAngle = horiFOV;
		vertViewAngle = startingVertViewAngle;
		horiViewAngle = startingHoriViewAngle;
//n/m		sideViewAngle = startingSideViewAngle;
		viewPoint = startingLocation;
		viewSpace = spaceViewed;
	}

	public Space getViewSpace() {
		return viewSpace;
	}
	
	public void addViewSpaceContainedPoint(Point pointToAdd) {
		viewSpace.addContainedPoint(pointToAdd);
	}
	
	public void removeViewSpaceContainedPoint(Point pointToRemove) {
		viewSpace.removeContainedPoint(pointToRemove);
	}
	
	/** getPointCoords
	 * 
	 * For now doesn't really distinguish between points on screen and not on screen; not sure if that'll just
	 * work out through the math or if we'll have to code more
	 * 
	 * @return a two-dimensional double array of the points' coordinates on screen.
	 * 
	 */
	public double[][] getPointCoords() {
		Point[] pointsInSpace = viewSpace.getContainedPoints();
		int pointsInSpaceLength = pointsInSpace.length;
		double[][] pointCoords = new double[pointsInSpaceLength][2];
		
		for (int i = 0; i < pointsInSpaceLength; i++) {
			pointCoords[i][HORIZONTAL] = getHoriPos(pointsInSpace[i]);
			pointCoords[i][VERTICAL] = getVertPos(pointsInSpace[i]);
			System.out.println(pointCoords[i][HORIZONTAL] + " " + pointCoords[i][VERTICAL]);
		}
		
		return pointCoords;
	}
	
	/** getHoriPos
	 * 
	 * this could alllll be deleted, but it's for my sake, debugging and all that
	 * honestly I could also structure both getHoriPos and getVertPos so that there's just one getPos method
	 * with all the actual math and those methods just give that math one the values
	 * 
	 * hmmm actually that should still work because if I get an exception it'll show the path thru the others
	 * and I can put sysouts in those
	 * 
	 * I'ma do that
	 * 
	 * okay NOW it jsut gives getPos x and z coordinates and returns what it gets
	 * 
	 * @param p
	 * @return the distance of p from the right edge of the screen (inconvenient, I know; may change)
	 * 
	 */
	public double getHoriPos(Point p) {
		return getPos(p.getX(), p.getZ(), viewPoint.getX(), viewPoint.getZ(), horiViewAngle, horiFOVAngle, 
				screenWidth);
	}
	
	/** getVertPos
	 * 
	 * just gives getPos x and y coordinates and returns what it gets 
	 * 
	 * @param p
	 * @return the distance of p from the bottom edge of the screen (inconvenient, I know; may change)
	 * 
	 */
	public double getVertPos(Point p) {
		return getPos(p.getX(), p.getY(), viewPoint.getX(), viewPoint.getY(), vertViewAngle, vertFOVAngle, 
				screenHeight);
	}
	
}
