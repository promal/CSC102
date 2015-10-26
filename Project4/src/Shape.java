import java.awt.Color;

/**
 * Shape interface that defines the common operations for a Circle,
 * Rectangle, Triangle, and ConvexPolygon.
 * @author Alejandro Guzman
 * @version 07/31/15
 */

public abstract class Shape implements Comparable<Shape> {
	private Color color;
	private boolean filled;
	
	public Shape(Color color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	/**
	 * Calculates and returns the area of the shape.
	 * @return the area of the shape.
	 */
	public abstract double getArea();
	
	/**
	 * Returns the color of the shape.
	 * @return the color of the shape.
	 */
	public java.awt.Color getColor() {
		return this.color;
	}
	
	/**
	 * Sets the color of the shape.
	 * @param color the color of the shape.
	 */
	public void setColor(java.awt.Color color) {
		this.color = color;
	}
	
	/**
	 * Gets the filled state of the shape.
	 * @return true if the shape is filled with color, otherwise false.
	 */
	public boolean getFilled() {
		return this.filled;
	}
	
	/**
	 * Sets the filled state of the shape to the specified value.
	 * @param filled the state of the shape.
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/**
	 * Gets the current position of the object.
	 * @return the current position of the shape.
	 */
	public abstract java.awt.Point getPosition();
	
	/**
	 * Changes the position of the shape to the specified position.
	 * @param position the Point were to move the shape.
	 */
	public abstract void setPosition(java.awt.Point position);
	
	/**
	 * Moves the shape by the x and y amounts.
	 * @param delta the amount to move the shape.
	 */
	public abstract void move(java.awt.Point delta);
	
	/**
	 * A negative value when a's class name is less that b's class name or, when the names are equal, when a's area is less than b's area.
	 * Zero when a's class name equals b's class name and a's area is approximately equal to b's area (+/- 0.0001).
	 * A positive value when a's class name is greater than b's class name or, when the names are equal, when a's area is greater than b's area.
	 * @return see documentation.  
	 */
	public int compareTo(Shape otherShape) {
		String thisClassName = this.getClass().getName();
		String otherClassName = otherShape.getClass().getName();
		if (thisClassName.compareTo(otherClassName) < 0 || 
				(thisClassName.compareTo(otherClassName) == 0 && this.getArea() < otherShape.getArea())) {
			return -1;
		} else if (thisClassName.compareTo(otherClassName) > 0 || 
				(thisClassName.compareTo(otherClassName) == 0 && this.getArea() > otherShape.getArea())) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Shape otherObject = (Shape) other; 
		
		return this.color.equals(otherObject.color) &&
				this.filled == otherObject.filled;
	}
}
