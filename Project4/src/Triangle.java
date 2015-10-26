import java.awt.Point;
import java.awt.Color;

/**
 * Triangle class that represents a triangle shape numerically.
 * @author Alejandro Guzman
 * @version 08/1/2015
 */
public class Triangle extends ConvexPolygon {
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
		super(new Point[] 
				{(Point) a.clone(),
				(Point) b.clone(),
				(Point) c.clone()}, color, filled);
	}

	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex a.
	 */
	public Point getVertexA() {
		return super.getVertex(0);
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexA(Point point) {
		super.setVertex(0, point);;
	}
	
	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex b.
	 */
	public Point getVertexB() {
		return super.getVertex(1);
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexB(Point point) {
		super.setVertex(1, point);;
	}
	
	/**
	 * Gets a specific vertex of the triangle.
	 * @return vertex c.
	 */
	public Point getVertexC() {
		return super.getVertex(2);
	}
	
	/**
	 * Sets a specific vertex of the triangle.
	 * @param point the vertex to set.
	 */
	public void setVertexC(Point point) {
		super.setVertex(2, point);;
	}
}
