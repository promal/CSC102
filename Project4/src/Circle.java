/**
 * Circle class that represents a circle object numerically.
 * @author Alejandro Guzman
 * @version 07/31/15
 */
public class Circle extends Ellipse {
	/**
	 * Initializes the state of a Circle with its respective properties.
	 * @param radius the distance from an edge of a circle to the origin.
	 * @param position the Point (x,y) of a corner of a circle such that the circle is inscribed in a square.
	 * @param color the color of the Circle.
	 * @param filled the state that determines if the circle is colored or not.
	 */
	public Circle(double radius, java.awt.Point position, java.awt.Color color, boolean filled) {
		super(radius, radius, position, color, filled);
	}	
		
	public double getRadius() {
		return super.getSemiMinorAxis();
	}
	
	public void setRadius(double radius) {
		super.setSemiMinorAxis(radius);
		super.setSemiMajorAxis(radius);
	}
	
	@Override
	public void setSemiMajorAxis(double radius) {
		super.setSemiMajorAxis(radius);
		super.setSemiMinorAxis(radius);
	}
	
	@Override
	public void setSemiMinorAxis(double radius) {
		super.setSemiMinorAxis(radius);
		super.setSemiMajorAxis(radius);
	}
	
} 
