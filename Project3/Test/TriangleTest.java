import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleTest {
	private static double EPSILON = 0.00000001;

	@Test
	public void testTriangleConstructor() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTriangleImplementsShape() {
		assertTrue(Shape.class.isAssignableFrom(Triangle.class));
	}
}
