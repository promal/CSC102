import java.awt.Point;
import java.awt.Color;

/**
 * Triangle class that represents a triangle shape numerically.
 * @author Alejandro Guzman
 * @version 08/1/2015
 */
public class Triangle implements Shape {
	private Point a;
	private Point b;
	private Point c;
	private Color color;
	private boolean filled;
	
	/**
	 * Triangle constructor that represents the numerical representation of 
	 * a triangle numerical with specified parameters. Note that the java.awt.Point 
	 * objects represent the three vertices of the triangle in the specified 
	 * order, i.e., a, b, c, and that the point represented by the parameter 
	 * a represents the position of the triangle.
	 * @param a a vertex of a triangle that represents the position of the triangle.
	 * @param b a vertex of a triangle.
	 * @param c a vertex of a triangle.
	 * @param color the color of a triangle.
	 * @param filled the state in terms of the triangle being filled with color or not.
	 */
	public Triangle(java.awt.Point a, java.awt.Point b, 
			java.awt.Point c, java.awt.Color color, boolean filled) {
		this.a = (Point) a.clone();
		this.b = (Point) b.clone();
		this.c = (Point) c.clone();
		this.color = color;
		this.filled = filled;
	}
	
	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex a.
	 */
	public Point getVertexA() {
		return (Point) this.a.clone();
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexA(Point point) {
		this.a = (Point) point.clone();
	}
	
	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex b.
	 */
	public Point getVertexB() {
		return (Point) this.b.clone();
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexB(Point point) {
		this.b = (Point) point.clone();
	}
	
	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex c.
	 */
	public Point getVertexC() {
		return (Point) this.c.clone();
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexC(Point point) {
		this.c = (Point) point.clone();
	}

	/**
	 * Test whether two triangle objects are equal to each other
	 * based on the state of their respective object.
	 * @param other the other object to test against this.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Triangle otherObject = (Triangle) other;
		return this.a.equals(otherObject.a) &&
				this.b.equals(otherObject.b) &&
				this.c.equals(otherObject.c) &&
				this.color.equals(otherObject.color) &&
				this.filled == otherObject.filled;
	}
	
	@Override
	public double getArea() {
		// The following web site was used to calculate the area of a triangle.
		// http://www.mathwords.com/a/area_triangle.htm
		double distanceA = Math.sqrt(Math.pow((this.b.x - this.c.x), 2) + Math.pow((this.b.y - this.c.y), 2));
		double distanceB = Math.sqrt(Math.pow((this.a.x - this.c.x), 2) + Math.pow((this.a.y - this.c.y), 2));
		double distanceC = Math.sqrt(Math.pow((this.a.x - this.b.x), 2) + Math.pow((this.a.y - this.b.y), 2));
		double s = (distanceA + distanceB + distanceC) / 2;
		double k = Math.sqrt(s * (s - distanceA) * (s - distanceB) * (s - distanceC));
		return k;
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
		return (Point) a.clone();
	}

	@Override
	public void setPosition(Point position) {
		int distanceX = position.x - this.a.x;
		int distanceY = position.y - this.a.y;
		this.a = (Point) position.clone();
		this.b.x += distanceX;
		this.b.y += distanceY;
		this.c.x += distanceX;
		this.c.y += distanceY;
	}

	@Override
	public void move(Point delta) {
		int distanceX = delta.x;
		int distanceY = delta.y;
		this.a.x += distanceX;
		this.a.y += distanceY;
		this.b.x += distanceX;
		this.b.y += distanceY;
		this.c.x += distanceX;
		this.c.y += distanceY;
	}
}
