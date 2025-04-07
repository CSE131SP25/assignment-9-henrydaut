package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.0;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private BodySegment head =  new BodySegment(.5,.5,SEGMENT_SIZE);
	private int counter;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		this.segments = new LinkedList<>();
		segments.add(head);
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {

			for (int i=(segments.size()-1); i>0; i--) {
				BodySegment priorSegment = segments.get(i-1);
				BodySegment currentSegment = segments.get(i);
				currentSegment.setX(priorSegment.getX());
				currentSegment.setY(priorSegment.getY());
			}

		head.setX(head.getX()+deltaX);
		head.setY(head.getY()+deltaY);

	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment b: segments) {
			b.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		double distanceX = f.getX() - head.getX();
		double distanceY = f.getY() - head.getY();
		double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		if (distance <= (f.getFoodSize()+head.getSize())) {
			BodySegment last = segments.getLast();
			BodySegment addition = new BodySegment(last.getX()-(2*deltaX),last.getY()-(2*deltaY), SEGMENT_SIZE);
			segments.addLast(addition);
			counter++;
			return true;
		} else {
			return false;
		}
	}
	public int getCounter() {
		return counter;
	}
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if (head.getX() > (1.0-head.getSize()) || head.getX() < (0+head.getSize()) || head.getY() > (1.0-head.getSize()) || head.getY() < (0+head.getSize())) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean selfCollision() {
		if (segments.size()>4) {
			for (int i=(segments.size()-1); i>3; i--) {
				BodySegment currentSegment = segments.get(i);
				double distanceX = head.getX() - currentSegment.getX();
				double distanceY = head.getY() - currentSegment.getY();
				double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
				if(distance <= (2*SEGMENT_SIZE)){
					return true;
				} else {
					return false;
				}
			}
		} 
		return false;

	}
}
