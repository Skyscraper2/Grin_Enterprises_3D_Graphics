package viewer;

import graphics.BasicMovingPerson1;
import graphics.Person;
import graphics.Point;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Total BS
 * 
 * @author Gabriel
 * 
 * Not total. But definitely a placeholder.
 * 
 */
public class BasicViewer1 
		extends Applet
		implements Runnable, KeyListener {
	
	BasicMovingPerson1 person;
	
	public void init() {
		setSize(600, 600);
		setFocusable(true);
		person = new BasicMovingPerson1();
		person.addViewSpaceContainedPoint(new Point(10, 0, 10));
	}
	
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	} public void stop() {};
	
	public void paint(Graphics artist) {
		
		artist.drawChars(new char[]{'h'}, 0, 1, 300, 300);
		
		double[][] pointCoords = person.getPointCoords();
		int pointCoordsLength = pointCoords.length;
		
		for (int i = 0; i < pointCoordsLength; i++) {
			System.out.println((int) pointCoords[i][Person.HORIZONTAL] + " " + (int) pointCoords[i][Person.VERTICAL]);
			artist.drawRect((int) pointCoords[i][Person.HORIZONTAL], (int) pointCoords[i][Person.VERTICAL], 50, 50);
		}
		
	}
	
	public void run() {
		
		while(true) {
			
			repaint();
			
			person.runPerson();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException ee) {
				ee.printStackTrace();
			}
		}
		
	}
	
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
		
		if (keyCode == KeyEvent.VK_W) {
			person.moveForward();
		} else if (keyCode == KeyEvent.VK_S) {
			person.moveBackward();
		} else if (keyCode == KeyEvent.VK_A) {
			person.moveLeft();
		} else if (keyCode == KeyEvent.VK_D) {
			person.moveRight();
		} else if (keyCode == KeyEvent.VK_Q) {
			person.moveDown();
		} else if (keyCode == KeyEvent.VK_E) {
			person.moveUp();
		}
		
	}
	
	public void keyReleased(KeyEvent event) {
		int keyCode = event.getKeyCode();
		
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S) {
			person.stopForwardOrBackward();
		} else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
			person.stopLeftOrRight();
		} else if (keyCode == KeyEvent.VK_Q || keyCode == KeyEvent.VK_E) {
			person.stopUpOrDown();
		}
		
	}
	
	public void keyTyped(KeyEvent event) {}
	
}
