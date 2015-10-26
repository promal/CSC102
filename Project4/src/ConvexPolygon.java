import java.awt.Point;
import java.awt.Color;
import java.util.Arrays;

public class ConvexPolygon extends Shape {
	private Point[] vertices;
	
	/**
	 * Default constructor with vertices of the convex polygon, 
	 * with a predefined color and a condition that determines whether the shape is colored. 
	 * @param vertices the vertex (vertices[0] is the vertex).
	 * @param color the color.
	 * @param filled the state that determines if the polygon is filled with its color.
	 * @precondition array of vertices pass in will be full; there will be a Point reference in every location from index zero up to its length-1.
	 * @precondition the vertices must be provided in counter-clockwise order.
	 * @precondition polygon must not be closed. The first and last point are not the same point (no duplicate points).
	 */
	public ConvexPolygon(Point[] vertices, Color color, boolean filled) {
		super(color, filled);
		final int ARRAY_LENGTH = vertices.length;
		this.vertices = new Point[ARRAY_LENGTH];
		for (int i = 0; i < ARRAY_LENGTH; i++) { this.vertices[i] = new Point(vertices[i]); }
	}
	
	/**
	 * Gets the specified vertex.
	 * @param index the location of the vertex to get.
	 * @return the vertex at position index.
	 */
	public Point getVertex(int index) {
		return (Point) this.vertices[index].clone();
	}
	
	/**
	 * Sets the specified vertex at position index.
	 * @param index the location where to place the new vertex.
	 * @param vertex the new vertex to place at position index.
	 */
	public void setVertex(int index, Point vertex) {
		this.vertices[index] = (Point) vertex.clone();
	}
	
	/**
	 * Checks to see that two ConvexPolygons are equal in terms of their instance fields.
	 * @return true if the this object and otherObject are equal in terms of content.
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}

		ConvexPolygon other = (ConvexPolygon) otherObject;
		return Arrays.deepEquals(this.vertices, other.vertices);
	}
	
	@Override
	public double getArea() {
		// http://www.mathwords.com/a/area_convex_polygon.htm
		double area = 0.5;
		double left = 0; // left side of determinant see web page
		double right = 0; // right side of determinant see web page
		for (int index = 0; index < this.vertices.length - 1; index++) {
			left += this.vertices[index].x * this.vertices[index + 1].y;
			right += this.vertices[index].y * this.vertices[index + 1].x;
		}
		
		left += this.vertices[this.vertices.length - 1].x * this.vertices[0].y;
		right += this.vertices[this.vertices.length - 1].y * this.vertices[0].x;
		area *= (left - right);
		return (area < 0) ? Math.abs(area) : area;
	}

	@Override
	public Point getPosition() {
		return (Point) this.vertices[0].clone();
	}

	@Override
	public void setPosition(Point position) {
		int posX = position.x - this.vertices[0].x;
		int posY = position.y - this.vertices[0].y;
		this.vertices[0] = (Point) position.clone();
		for (int index = 1; index < this.vertices.length; index++) {
			this.vertices[index].x += posX;
			this.vertices[index].y += posY;
		}
	}

	@Override
	public void move(Point delta) {
		for (int index = 0; index < this.vertices.length; index++) {
			this.vertices[index].x += delta.x;
			this.vertices[index].y += delta.y;
		}
	}
	
}
