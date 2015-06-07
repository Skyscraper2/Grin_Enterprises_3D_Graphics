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
	
	public Point[] getConnectedPoints() {
		return connections;
	}
	
	public Point getConnectedPoint(int index) {
		return connections[index];
	}
	
}
