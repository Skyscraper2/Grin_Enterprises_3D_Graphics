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
	
	public Space() {
		xLimit = 100;
		yLimit = 100;
		zLimit = 100;
	}
	
	public Space(int width, int height, int breadth) {
		xLimit = width;
		yLimit = height;
		zLimit = breadth;
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
	
}
