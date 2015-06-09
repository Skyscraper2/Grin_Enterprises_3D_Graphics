package graphics;

public class BasicMovingPerson1 
		extends Person {
	
	public final static double maxSpeed = 1.0;
	public final static double maxAngleSpeed = Math.PI / 32.0;
	
	public BasicMovingPerson1() {
		super();

		System.out.println("default BasicMovingPerson1 initialized");
		
	}
	
	public BasicMovingPerson1(int width, int height, double vertFOV, double horiFOV, double startingVertViewAngle,
			double startingHoriViewAngle, Point startingLocation, Space spaceViewed, double startingXVel,
			double startingYVel, double startingZVel, double startingHoriAngleVel, double startingVertAngleVel) {
		
		super(width, height, vertFOV, horiFOV, startingVertViewAngle, startingHoriViewAngle, startingLocation, 
				spaceViewed, startingXVel, startingYVel, startingZVel, startingHoriAngleVel, startingVertAngleVel);
		
		System.out.println("BasicMovingPerson1 initialized");
		
	}
	
	public void moveLeft() {
		setZVel(-maxSpeed);
	}
	
	public void moveRight() {
		setZVel(maxSpeed);
	}
	
	public void moveUp() {
		setYVel(maxSpeed);
	}
	
	public void moveDown() {
		setYVel(-maxSpeed);
	}
	
	public void moveForward() {
		setXVel(maxSpeed);
	}
	
	public void moveBackward() {
		setXVel(-maxSpeed);
	}
	
	public void stopLeftOrRight() {
		setZVel(0);
	}

	public void stopUpOrDown() {
		setYVel(0);
	}
	
	public void stopForwardOrBackward() {
		setXVel(0);
	}
	
}
