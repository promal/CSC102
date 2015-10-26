import static org.junit.Assert.*;

import org.junit.Test;


public class RectangleTest {
	private static double EPSILON = 0.00000001;

	/**
	 * Aside from testing the constructor it also test the get and set
	 * methods of the rectangle class.
	 */
	@Test
	public void testRectangleConstructor() {
		int posX = 5;
		int posY = 30;
		int expectedWidth = 10;
		int expectedHeight = 20;
		boolean expectedFilled = false;
		java.awt.Point expectedPosition = new java.awt.Point(posX, posY);
		java.awt.Color expectedColor = new java.awt.Color(2);
		
		Rectangle r = new Rectangle(expectedWidth, expectedHeight, 
						expectedPosition, expectedColor, expectedFilled);
		assertEquals(expectedWidth, r.getWidth());
		assertEquals(expectedHeight, r.getHeight());
		assertEquals(expectedPosition, r.getPosition());
		assertEquals(expectedColor, r.getColor());
		assertEquals(expectedFilled, r.getFilled());
		
		posX = 25;
		posY = 40;
		expectedWidth = 15;
		expectedHeight = 30;
		expectedFilled = true;
		expectedPosition = new java.awt.Point(posX, posY);
		expectedColor = new java.awt.Color(10);
		
		r.setColor(expectedColor);
		r.setFilled(expectedFilled);
		r.setHeight(expectedHeight);
		r.setPosition(expectedPosition);
		r.setWidth(expectedWidth);
		
		assertEquals(expectedWidth, r.getWidth());
		assertEquals(expectedHeight, r.getHeight());
		assertEquals(expectedPosition, r.getPosition());
		assertEquals(expectedColor, r.getColor());
		assertEquals(expectedFilled, r.getFilled());
	}
	
	@Test
	public void testMove() {
		int posX = 5;
		int posY = 30;
		int expectedWidth = 10;
		int expectedHeight = 20;
		boolean expectedFilled = false;
		java.awt.Point expectedPosition = new java.awt.Point(posX, posY);
		java.awt.Color expectedColor = new java.awt.Color(2);
		
		Rectangle r = new Rectangle(expectedWidth, expectedHeight, 
						expectedPosition, expectedColor, expectedFilled);
		
		r.move(expectedPosition);
		assertEquals(new java.awt.Point(posX + posX, posY + posY), r.getPosition());
	}
	
	@Test
	public void testRectangleImplementsShape() {
		assertTrue(Shape.class.isAssignableFrom(Rectangle.class));
	}
	
	@Test
	public void testEquals() {
		int posX = 5;
		int posY = 30;
		int expectedWidth = 10;
		int expectedHeight = 20;
		boolean expectedFilled = false;
		java.awt.Point expectedPosition = new java.awt.Point(posX, posY);
		java.awt.Color expectedColor = new java.awt.Color(2);
		
		Rectangle r = new Rectangle(expectedWidth, expectedHeight, 
						expectedPosition, expectedColor, expectedFilled);
		
		Rectangle r1 = new Rectangle(expectedWidth + 5, expectedHeight + 5, 
				expectedPosition, expectedColor, expectedFilled);
		
		assertFalse(r.equals(r1));
		
		r1.setWidth(expectedWidth);
		r1.setHeight(expectedHeight);
		
		assertTrue(r.equals(r1));
	}
	
	@Test
	public void testArea() {
		int posX = 5;
		int posY = 30;
		int expectedWidth = 10;
		int expectedHeight = 20;
		double expectedArea = expectedWidth * expectedHeight;
		boolean expectedFilled = false;
		java.awt.Point expectedPosition = new java.awt.Point(posX, posY);
		java.awt.Color expectedColor = new java.awt.Color(2);
		
		Rectangle r = new Rectangle(expectedWidth, expectedHeight, 
						expectedPosition, expectedColor, expectedFilled);
		assertEquals(expectedArea, r.getArea(), EPSILON);
	}

}
