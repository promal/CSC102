import java.awt.Point;

/**
 * Rectangle class that represents a rectangle shape numerically.
 * @author Alejandro Guzman
 * @version 08/1/2015
 */
public class Rectangle extends ConvexPolygon {
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
		super(new Point[] {(Point) position.clone(), 
				new Point(position.x + width, position.y), 
				new Point(position.x + width, position.y + height), 
				new Point(position.x, position.y + height)},
				color, filled);
	}
	
	public int getHeight() {
		Point lowerLeft = super.getVertex(0);
		Point bottomRight = super.getVertex(3);
		return bottomRight.y - lowerLeft.y;
	}
	
	public void setHeight(int heightLength) {
		int differenceHeight = heightLength - this.getHeight();
		Point lowerLeft = super.getVertex(2);
		Point bottomRight = super.getVertex(3);
		lowerLeft.translate(0, differenceHeight);
		bottomRight.translate(0, differenceHeight);
		super.setVertex(2, lowerLeft);
		super.setVertex(3, bottomRight);
	}
	
	public int getWidth() {
		Point lowerLeft = super.getVertex(0);
		Point bottomLeft = super.getVertex(1);
		return bottomLeft.x - lowerLeft.x;
	}
	
	public void setWidth(int widthLength) {
		int differenceWidth = widthLength - this.getWidth();
		Point lowerLeft = super.getVertex(1);
		Point bottomRight = super.getVertex(2);
		lowerLeft.translate(differenceWidth, 0);
		bottomRight.translate(differenceWidth, 0);
		super.setVertex(1, lowerLeft);
		super.setVertex(2, bottomRight);
	}
	
	/**
	 * This method will throw an exception every time someone tries to change
	 * the shape of the rectangle.
	 * @throws UnsupportedOperationException this is to prevent someone from
	 * changing a Rectangle object to a non Rectangle shape.
	 */
	@Override
	public void setVertex(int index, Point vertex) {
		throw new UnsupportedOperationException();
	}
}
