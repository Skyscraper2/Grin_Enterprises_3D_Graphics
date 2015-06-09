package graphics;

/** Space notes
 * 
 * @author lundquistg
 * 
 * One corner is 0, 0, 0; there are no ngeative values
 * (at least that's how it'll be for now)
 *
 */
public class Space {
	
	private int xLimit;
	private int yLimit;
	private int zLimit;
	private Point[] containedPoints;
	
	public Space() {
		xLimit = 100;
		yLimit = 100;
		zLimit = 100;
		containedPoints = new Point[0];
	}
	
	public Space(int width, int height, int breadth) {
		xLimit = width;
		yLimit = height;
		zLimit = breadth;
		containedPoints = new Point[0];
	}
	
	public Space(int width, int height, int breadth, Point[] pointsInSpace) {
		xLimit = width;
		yLimit = height;
		zLimit = breadth;
		containedPoints = pointsInSpace;
	}
	
	public int getWidth() {
		return xLimit;
	}
	
	public int getHeight() {
		return yLimit;
	}
	
	public int getBreadth() {
		return zLimit;
	}
	
	public Point[] getContainedPoints() {
		return containedPoints;
	}
	
	public Point getContainedPoint(int index) {
		return containedPoints[index];
	}
	
	public void addContainedPoint(Point containedPoint) {
		containedPoints = Point.addToArrayEnd(containedPoints, containedPoint);
	}
	
	public void removeContainedPoint(Point containedPoint) {
		containedPoints = Point.removeFromArray(containedPoints, containedPoint);
	}
	
}
