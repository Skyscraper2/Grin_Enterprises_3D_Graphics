package graphics;

public class Point {
	
	int xCoord;
	int yCoord;
	int zCoord;
	Point[] connections;
	
	public Point() {
		xCoord = 0;
		yCoord = 0;
		zCoord = 0;
	}
	
	public Point(int x, int y, int z, Point[] connectedPoints) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
		connections = connectedPoints;
	}
	
	public int getX() {
		return xCoord;
	}
	
	public int getY() {
		return yCoord;
	}
	
	public int getZ() {
		return zCoord;
	}
	
	public Point[] getConnectedPoints() {
		return connections;
	}
	
	public Point getPoint(int index) {
		return connections[index];
	}
	
}
