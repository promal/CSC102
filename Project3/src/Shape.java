/**
 * Shape interface that defines the common operations for a Circle,
 * Rectangle, Triangle, and ConvexPolygon.
 * @author Alejandro Guzman
 * @version 07/31/15
 */
public interface Shape {
	/**
	 * Calculates and returns the area of the shape.
	 * @return the area of the shape.
	 */
	double getArea();
	
	/**
	 * Returns the color of the shape.
	 * @return the color of the shape.
	 */
	java.awt.Color getColor();
	
	/**
	 * Sets the color of the shape.
	 * @param color the color of the shape.
	 */
	void setColor(java.awt.Color color);
	
	/**
	 * Gets the filled state of the shape.
	 * @return true if the shape is filled with color, otherwise false.
	 */
	boolean getFilled();
	
	/**
	 * Sets the filled state of the shape to the specified value.
	 * @param filled the state of the shape.
	 */
	void setFilled(boolean filled);
	
	/**
	 * Gets the current position of the object.
	 * @return the current position of the shape.
	 */
	java.awt.Point getPosition();
	
	/**
	 * Changes the position of the shape to the specified position.
	 * @param position the Point were to move the shape.
	 */
	void setPosition(java.awt.Point position);
	
	/**
	 * Moves the shape by the x and y amounts.
	 * @param delta the amount to move the shape.
	 */
	void move(java.awt.Point delta);
}
