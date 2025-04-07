package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		x = Math.random()*0.8 + 0.1;
		y = Math.random()*0.8 + 0.1;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static double getFoodSize() {
		return FOOD_SIZE;
	}

	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(230,83,54);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
}
