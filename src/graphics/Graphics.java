package graphics;

public class Graphics {
	
	private int screenWidth; //width of the screen you're displaying on to convert to
	private int screenHeight; //height of the screen you're displaying on to convert to
	private double xFOVAngle; //half the angle of the horizontal FOV, just because half comes up more
	private double yFOVAngle; //half the angle of the vertical FOV, just because half comes up more
	private Point viewPoint; //the point from which the lines of the view radiate
	
	public Graphics() {
		screenWidth = 600;
		screenHeight = 600;
		xFOVAngle = 5 * Math.PI / 12; //remember, half the angle
		setYFOVAngle();
		viewPoint = new Point(); //'cos default is at 0, 0, 0
	}
	
	public void setYFOVAngle() {
		yFOVAngle = xFOVAngle * (screenHeight / screenWidth);
	}
	
}
