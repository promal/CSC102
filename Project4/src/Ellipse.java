import java.awt.Point;
import java.awt.Color;

public class Ellipse extends Shape {
	private double semiMajorAxis;
	private double semiMinorAxis;
	private Point position;
	
	public Ellipse(double semiMajorAxis, double semiMinorAxis,
			Point position, Color color, boolean filled) {
		super(color, filled);
		this.position = (Point) position.clone();
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
	}
	
	public double getSemiMajorAxis() {
		return this.semiMajorAxis;
	}
	
	/**
	 * Sets the ellipses major axis to the specified value. If the new value
	 * is less than the current minor axis then the new value becomes the
	 * minor axis value and the old (larger) minor axis value becomes the
	 * major axis value.
	 * @param newMajorAxis the longer axis of an ellipse, passing through its foci.
	 */
	public void setSemiMajorAxis(double newMajorAxis) {
		if (newMajorAxis < this.semiMinorAxis) {
			this.semiMajorAxis = this.semiMinorAxis;
			this.semiMinorAxis = newMajorAxis;
		} else {
			this.semiMajorAxis = newMajorAxis;
		}
	}
	
	public double getSemiMinorAxis() {
		return this.semiMinorAxis;
	}
	
	/**
	 * sets the ellipses minor axis to the specified value. If the 
	 * new value is more than the current major axis then the new 
	 * value becomes the major axis value and the old (smaller) 
	 * major axis value becomes the minor axis value.
	 * @param newMinorAxis
	 */
	public void setSemiMinorAxis(double newMinorAxis) {
		if (newMinorAxis > this.semiMajorAxis) {
			this.semiMinorAxis = this.semiMajorAxis;
			this.semiMajorAxis = newMinorAxis;
		} else {
			this.semiMinorAxis = newMinorAxis;
		}
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
	
	@Override
	public double getArea() {
		return Math.PI * this.semiMajorAxis * this.semiMinorAxis;
	}
	
	@Override
	public Point getPosition() {
		return (Point) this.position.clone();
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		
		Ellipse other = (Ellipse) otherObject;
		return other.position.equals(this.position) &&
				this.testMinorAndMajorAxis(other.semiMinorAxis,
						other.semiMajorAxis);
	}
	
	private boolean testMinorAndMajorAxis(double minor, double major)  {
		final double EPSILON = 0.00000001;
		return Math.abs(this.semiMajorAxis - major) < EPSILON &&
				Math.abs(this.semiMinorAxis - minor) < EPSILON;
	}
}
