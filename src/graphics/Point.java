package graphics;

public class Point {
	
	double xCoord;
	double yCoord;
	double zCoord;
	Point[] connections;
	
	public Point() {
		xCoord = 0.0;
		yCoord = 0.0;
		zCoord = 0.0;
		connections = new Point[0];
	}
	
	public Point(double x, double y, double z, Point[] connectedPoints) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
		connections = connectedPoints;
	}

	public Point(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
		connections = new Point[0];
	}
	
	public double getX() {
		return xCoord;
	}
	
	public double getY() {
		return yCoord;
	}
	
	public double getZ() {
		return zCoord;
	}
	
	public void setX(double x) {
		xCoord = x;
	}

	public void setY(double y) {
		yCoord = y;
	}

	public void setZ(double z) {
		zCoord = z;
	}
	
	public Point[] getConnectedPoints() {
		return connections;
	}
	
	public Point getConnectedPoint(int index) {
		return connections[index];
	}
	
	public static Point[] addToArrayEnd(Point[] pre, Point toAdd) {
		
		int preLength = pre.length;
		Point[] post = new Point[preLength + 1];
		
		for (int i = 0; i < preLength; i++) 
			post[i] = pre[i];
		
		post[preLength] = toAdd;
		
		return post;
	}
	
	public static Point[] removeFromArray(Point[] pre, Point toRemove) {
		
		int preLength = pre.length;
		Point[] post = new Point[preLength - 1];
		
		int i;
		for (i = 0; i + 1 < preLength && !pre[i].equals(toRemove); i++) 
			post[i] = pre[i];
		for (; i + 1 < preLength; i++) 
			post[i] = pre[i + 1];
		
		return post;
		
	}
	
}
