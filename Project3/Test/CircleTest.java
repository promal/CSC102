import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class CircleTest {
	private static double EPSILON = 0.00000001;

	@Test
	public void testCircleImplementsShape() {
		assertTrue(Shape.class.isAssignableFrom(Circle.class));
	}
	
	/**
	 * Test the Circle constructor and the get, set, and move methods.
	 */
	@Test
	public void testCircleConstructor() {
		int x = 4;
		int y = 4;
		double radius = 2.0;
		java.awt.Point position = new java.awt.Point(x,y);
		java.awt.Color color = new java.awt.Color(255);
		boolean filled = false;
		Circle c = new Circle(radius, position, color, filled);
		
		assertEquals(radius, c.getRadius(), EPSILON);
		assertEquals(position, c.getPosition());
		assertEquals(color, c.getColor());
		assertEquals(filled, c.getFilled());
		
		c.setColor(Color.BLACK);
		c.setFilled(true);
		c.setPosition(new java.awt.Point(2,2));
		c.setRadius(5.0);
		
		assertNotEquals(radius, c.getRadius(), EPSILON);
		assertNotEquals(position, c.getPosition());
		assertNotEquals(color, c.getColor());
		assertNotEquals(filled, c.getFilled());
		
		x = 2;
		y = 2;
		radius = 5.0;
		position = new java.awt.Point(x,y);
		color = Color.BLACK;
		filled = true;
		
		assertEquals(radius, c.getRadius(), EPSILON);
		assertEquals(position, c.getPosition());
		assertEquals(color, c.getColor());
		assertEquals(filled, c.getFilled());
		
		x = 4;
		y = 4;
		c.move(position);
		position = new java.awt.Point(x,y);
		assertEquals(position, c.getPosition());
		
	}
	
	@Test
	public void testArea() {
		int x = 4;
		int y = 4;
		double radius = 2.0;
		double expectedArea = Math.PI * radius * radius;
		java.awt.Point position = new java.awt.Point(x,y);
		java.awt.Color color = new java.awt.Color(255);
		boolean filled = false;
		Circle c = new Circle(radius, position, color, filled);
		
		assertEquals(expectedArea, c.getArea(), EPSILON);
		
		radius = 4.5;
		c.setRadius(radius);
		expectedArea = Math.PI * radius * radius;
		
		assertEquals(expectedArea, c.getArea(), EPSILON);

		

	}
	
	@Test
	public void testEquals() {
		int x = 4;
		int y = 4;
		int x1 = 5;
		int y1 = 5;
		
		double radius = 2.0;
		double radius1 = 4.0;
		
		java.awt.Point position = new java.awt.Point(x,y);
		java.awt.Point position1 = new java.awt.Point(x1,y1);
		
		java.awt.Color color = new java.awt.Color(255);
		java.awt.Color color1 = new java.awt.Color(255);

		boolean filled = false;
		boolean filled1 = false;

		Circle c = new Circle(radius, position, color, filled);
		Circle c1 = new Circle(radius1, position1, color1, filled1);
		Circle c2 = new Circle(radius, position, color, filled);

		assertFalse(c.equals(c1));
		assertTrue(c.equals(c2));

	}

}
