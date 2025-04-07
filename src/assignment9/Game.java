package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake s;
	private Food f;
	public Game() {
		StdDraw.enableDoubleBuffering();
		s = new Snake();
		f = new Food();
		
	}
	
	public void play() {
		while (s.isInbounds()==true &&  s.selfCollision()==false) {
			int dir = getKeypress();
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			s.changeDirection(dir);
			s.move();
			if(s.eatFood(f)==true) {
				f = new Food();
			}
			updateDrawing();
		}
		StdDraw.setPenColor(200, 0, 0);
		StdDraw.text(.5, .5, "FAILURE");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		f.draw();
		s.draw();
		StdDraw.text( .1, .9, "Score: " + s.getCounter());
		StdDraw.pause(30);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
