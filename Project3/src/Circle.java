import java.awt.Color;
import java.awt.Point;

/**
 * Circle class that represents a circle object numerically.
 * @author Alejandro Guzman
 * @version 07/31/15
 */
public class Circle implements Shape {
	private double radius;
	private java.awt.Point position;
	private java.awt.Color color;
	private boolean filled;
	/**
	 * Initializes the state of a Circle with its respective properties.
	 * @param radius the distance from an edge of a circle to the origin.
	 * @param position the Point (x,y) of a corner of a circle such that the circle is inscribed in a square.
	 * @param color the color of the Circle.
	 * @param filled the state that determines if the circle is colored or not.
	 */
	public Circle(double radius, java.awt.Point position, java.awt.Color color, boolean filled) {
		this.radius = radius;
		this.position = (java.awt.Point) position.clone();
		this.color = color;
		this.filled = filled;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	@Override
	public Color getColor() {
		return this.color;
	}
	
	@Override
	public void setColor(Color color) {		
		this.color = color;
	}
	
	@Override
	public boolean getFilled() {
		return this.filled;
	}
	
	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	@Override
	public Point getPosition() {
		return (Point) this.position.clone();
	}
	
	@Override
	public void setPosition(Point position) {
		this.position = (Point) position.clone();
	}
	
	@Override
	public void move(Point delta) {
		this.position.x += delta.x;
		this.position.y += delta.y;
	}
	
	/**
	 * Determines if two objects of the same class are equal to each other.
	 * @param other the other object to compare with this.
	 * @return true if they are equal false otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Circle otherObject = (Circle) other;
		return approx(this.radius, otherObject.radius) && 
				this.color.equals(otherObject.color) &&
				this.position.equals(otherObject.position) &&
				this.filled == otherObject.filled;
		
	}
	
	private boolean approx(double a, double b) {
		final double EPSILON = 0.00000001;

		return Math.abs(a - b) < EPSILON;
	}
}
