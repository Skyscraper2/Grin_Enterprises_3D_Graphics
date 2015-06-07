package graphics;

public class Person 
		extends View {
	
	private double xVel;
	private double yVel;
	private double zVel;
	
	private double horiAngleVel;
	private double vertAngleVel;
	
	public Person() {
		xVel = 0;
		yVel = 0;
		zVel = 0;
		horiAngleVel = 0;
		vertAngleVel = 0;
	}
	
	public Person(int width, int height, double vertFOV, double horiFOV, double startingVertViewAngle,
			double startingHoriViewAngle, Point startingLocation, Space spaceViewed, double startingXVel,
			double startingYVel, double startingZVel, double startingHoriAngleVel, double startingVertAngleVel) {
		
		super(width, height, vertFOV, horiFOV, startingVertViewAngle, startingHoriViewAngle, startingLocation, 
				spaceViewed);
		
		xVel = startingXVel;
		yVel = startingYVel;
		zVel = startingZVel;
		horiAngleVel = startingHoriAngleVel;
		vertAngleVel = startingVertAngleVel;
		
	}
	
	public void runPerson() {
		
		viewPoint.setX(viewPoint.getX() + xVel);
		viewPoint.setY(viewPoint.getY() + yVel);
		viewPoint.setZ(viewPoint.getZ() + zVel);
		
		horiViewAngle += horiAngleVel;
		vertViewAngle += vertAngleVel;
		
	}
	
	public void setXVel(double vel) {
		xVel = vel;
	}
	
	public void setYVel(double vel) {
		yVel = vel;
	}

	public void setZVel(double vel) {
		zVel = vel;
	}
	
	public void setHoriAngleVel(double angleVel) {
		horiAngleVel = angleVel;
	}
	
	public void setVertAngleVel(double angleVel) {
		vertAngleVel = angleVel;
	}
	
	public double getXVel() {
		return xVel;
	}

	public double getYVel() {
		return yVel;
	}

	public double getZVel() {
		return zVel;
	}
	
	public double getHoriAngleVel() {
		return horiAngleVel;
	}

	public double getVertAngleVel() {
		return vertAngleVel;
	}
	
}
