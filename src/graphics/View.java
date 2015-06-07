package graphics;

/** Notes on View
 * 
 * @author lundquistg
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
 * 
 *
 */
public class View
		extends Perspective {
	
	private int screenWidth; //width of the screen you're displaying on to convert to
	private int screenHeight; //height of the screen you're displaying on to convert to
	private double vertFOVAngle; //half the angle of the horizontal FOV, just because half comes up more
	private double horiFOVAngle; //half the angle of the vertical FOV, just because half comes up more
	private double vertViewAngle; //the angle above the xz-plane that the center of the view is
	private double horiViewAngle; //the angle in front of the xy-plane that the center of the view is
	private Point viewPoint; //the point from which the lines of the view radiate
	
	public View() {
		screenWidth = 600;
		screenHeight = 600;
		vertFOVAngle = 5 * Math.PI / 12; //remember, half the angle
		horiFOVAngle = vertFOVAngle * (screenHeight / screenWidth);;
		vertViewAngle = 0;
		horiViewAngle = Math.PI / 4;
		viewPoint = new Point(); //'cos default is at 0, 0, 0
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
	 */
	public View(int width, int height, double vertFOV, double horiFOV, double startingVertViewAngle,
			double startingHoriViewAngle, Point startingLocation) {
		screenWidth = width;
		screenHeight = height;
		vertFOVAngle = vertFOV;
		horiFOVAngle = horiFOV;
		vertViewAngle = startingVertViewAngle;
		horiViewAngle = startingHoriViewAngle;
		viewPoint = startingLocation;
	}
	
	/** getHoriPos
	 * 
	 * @param p
	 * @return the distance of p from the right edge of the screen (inconvenient, I know; may change)
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
	 */
	public double getHoriPos(Point p) {
		return getPos(p.getX(), p.getZ(), viewPoint.getX(), viewPoint.getZ(), horiViewAngle, horiFOVAngle, 
				screenWidth);
	}
	
	/** getVertPos
	 * 
	 * @param p
	 * @return the distance of p from the bottom edge of the screen (inconvenient, I know; may change)
	 * 
	 * just gives getPos x and y coordinates and returns what it gets 
	 * 
	 */
	public double getVertPos(Point p) {
		return getPos(p.getX(), p.getY(), viewPoint.getX(), viewPoint.getY(), vertViewAngle, vertFOVAngle, 
				screenHeight);
	}
	
}
