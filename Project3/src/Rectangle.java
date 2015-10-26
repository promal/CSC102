import java.awt.Color;
import java.awt.Point;

/**
 * Rectangle class that represents a rectangle shape numerically.
 * @author Alejandro Guzman
 * @version 08/1/2015
 */
public class Rectangle implements Shape {
	private int width;
	private int height;
	private java.awt.Point position;
	private java.awt.Color color;
	private boolean filled;
	
	/**
	 * Constructs a numerical representation of a rectangle with the 
	 * specified construction parameters.
	 * @param width the distance in terms of length of a rectangle.
	 * @param height the distance in terms of height of a rectangle.
	 * @param position the position of the lower left corner.
	 * @param color the color of the rectangle.
	 * @param filled determines whether the shape is colored or not.
	 */
	public Rectangle(int width, int height, java.awt.Point position, 
		java.awt.Color color, boolean filled) {
		this.width = width;
		this.height = height;
		this.position = (Point) position.clone();
		this.color = color;
		this.filled = filled;
	}
	
	/**
	 * Gets the width of the rectangle.
	 * @return the width of the rectangle.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Sets the width of the rectangle.
	 * @param width the new width of the rectangle.
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the height of the rectangle.
	 * @return the height of the rectangle.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Sets the height of the rectangle.
	 * @param height the new height of the rectangle.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Rectangle otherObject = (Rectangle) other;
		return this.width == otherObject.width &&
				this.height == otherObject.height &&
				this.position.equals(otherObject.position) &&
				this.color.equals(otherObject.color) &&
				this.filled == otherObject.filled;
	}

	@Override
	public double getArea() {
		return this.width * this.height;
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
		return (java.awt.Point) this.position.clone();
	}

	@Override
	public void setPosition(Point position) {
		this.position = (java.awt.Point) position.clone();
	}

	@Override
	public void move(Point delta) {
		this.position.x += delta.x;
		this.position.y += delta.y;
	}
}
