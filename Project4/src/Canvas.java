import java.util.ArrayList;

public class Canvas {
	private ArrayList<Shape> canvas;
	
	/**
	 * Default Constructor to create the canvas for the shapes.
	 */
	public Canvas() {
		this.canvas = new ArrayList<Shape>();
	}
	
	/**
	 * Adds objects which implement the Shape interface to the end of the Canvas's java.util.ArrayList<Shape> instance variable.
	 * @param shape the shape to be added to the canvas.
	 */
	public void add(Shape shape) {
		this.canvas.add(shape);
	}
	
	/**
	 * Removes the Shape at the specified index and returns a reference to it or null if the index is out-of-bounds. 
	 * @param index the location to remove the shape.
	 * @return the shape or null if index is out of bounds.
	 */
	public Shape remove(int index) {
		return (index < 0 || index >= this.canvas.size()) ? null : this.canvas.remove(index);
	}
	
	/**
	 * Return the ith Shape object from Canvas. 
	 * @param index the location of the ith shape.
	 * @return the Shape at location index.
	 */
	public Shape get(int index) {
		return this.canvas.get(index);
	}
	
	/**
	 * The number of Shapes contained by the Canvas. 
	 * @return the number of shapes on the canvas.
	 */
	public int size() {
		return this.canvas.size();
	}
	
	/**
	 * Gets a list of circles in the Canvas.
	 * @return all of the Circle objects contained in the Canvas.
	 */
	public ArrayList<Circle> getCircles() {
		ArrayList<Circle> listOfCircles = new ArrayList<Circle>();
		for (int index = 0; index < this.canvas.size(); index++) {
			Shape e =  this.canvas.get(index);
			if (e instanceof Circle && e.getClass() == Circle.class) {
				listOfCircles.add((Circle) e);
			}
		}
		return listOfCircles;
	}
	
	/**
	 * Gets a list of rectangles in the Canvas.
	 * @return all of the rectangles objects contained in the Canvas.
	 */
	public ArrayList<Rectangle> getRectangles() {
		ArrayList<Rectangle> listOfRectangles = new ArrayList<Rectangle>();
		for (int index = 0; index < this.canvas.size(); index++) {
			Shape e = this.canvas.get(index);
			if (e instanceof Rectangle && e.getClass() == Rectangle.class) {
				listOfRectangles.add((Rectangle) e);
			}
		}
		return listOfRectangles;
	}
	
	/**
	 * Gets a list of triangles in the Canvas.
	 * @return all of the triangles objects contained in the Canvas.
	 */
	public ArrayList<Triangle> getTriangles() {
		ArrayList<Triangle> listOfTriangles = new ArrayList<Triangle>();
		for (int index = 0; index < this.canvas.size(); index++) {
			Shape e = this.canvas.get(index);
			if (e instanceof Triangle && e.getClass() == Triangle.class) {
				listOfTriangles.add((Triangle) e);
			}
		}
		return listOfTriangles;
	}
	
	/**
	 * Gets a list of convexPolygon in the Canvas.
	 * @return all of the convexPolygon objects contained in the Canvas.
	 */
	public ArrayList<ConvexPolygon> getConvexPolygons() {
		ArrayList<ConvexPolygon> listOfConvexPolygon = new ArrayList<ConvexPolygon>();
		for (int index = 0; index < this.canvas.size(); index++) {
			Shape e = this.canvas.get(index);
			if (e instanceof ConvexPolygon && e.getClass() == ConvexPolygon.class) {
				listOfConvexPolygon.add((ConvexPolygon) e);
			}
		}
		return listOfConvexPolygon;
	}
	
	/**
	 * All Shape objects in the Canvas that match the specified java.awt.Color.
	 * @return list of shapes that match specified color. 
	 */
	public ArrayList<Shape> getShapesByColor(java.awt.Color color) {
		ArrayList<Shape> listOfShapeColor = new ArrayList<Shape>();
		for (int index = 0; index < this.canvas.size(); index++) {
			Shape e = this.canvas.get(index);
			if (e.getColor().equals(color)) {
				listOfShapeColor.add(e);
			}
		}
		return listOfShapeColor;
	}
	
	/**
	 * The sum of the area of all Shape objects in the Canvas.
	 * @return sum of all the areas.
	 */
	public double getAreaOfAllShapes() {
		double sum = 0;
		for (int index = 0; index < this.canvas.size(); index++) {
			sum += this.canvas.get(index).getArea();
		}
		return sum;
	}
}
