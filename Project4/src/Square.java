import java.awt.Point;
import java.awt.Color;

public class Square extends Rectangle {
	public Square(int sideLength, Point position,
			Color color, boolean filled) {
		super(sideLength, sideLength, position, color, filled);
	}
	
	public int getSize() {
		return (int) super.getHeight();
	}
	
	/**
	 * This method ensures that the Square does not have uneven sides.
	 * @param newSideLength the length of one side of a Square.
	 */
	public void setSize(int newSideLength) {
		super.setWidth(newSideLength);
		super.setHeight(newSideLength);
	}
	
	@Override
	public void setHeight(int newHeightLength) {
		this.setSize(newHeightLength);
	}
	
	@Override
	public void setWidth(int newWidthLength) {
		this.setSize(newWidthLength);
	}
}
