import static org.junit.Assert.*;

import org.junit.Test;


public class FractionTest {
	public final double EPSILON = 0.00000001;
	
	@Test
	public void testIllegalArgumentException() {
		try
		{
			Fraction f1 = new Fraction(1, 0);
			fail();
		}
		catch (IllegalArgumentException e) {
			
		}
	}
	
	/**
	 * Test the default construct of the Fraction class and 
	 * in addition both the getNumerator and getDenominator method. 
	 */
	@Test
	public void testFractionDefaultConstructor() {
		Fraction f1 = new Fraction();
		int expectedNumerator = 0;
		int expectedDenominator = 1;
		assertEquals(f1.getNumerator(), expectedNumerator);
		assertEquals(f1.getDenominator(), expectedDenominator);
	}
	
	@Test
	public void testFractionNumeratorConstructor() {
		int expectedNumerator = 10;
		Fraction f1 = new Fraction(expectedNumerator);
		int expectedDenominator = 1;
		assertEquals(f1.getNumerator(), expectedNumerator);
		assertEquals(f1.getDenominator(), expectedDenominator);
	}
	
	
	@Test
	public void testFractionNumeratorDenominatorConstructor() {
		int expectedNumerator = 2;
		int expectedDenominator = 3;
		try
		{
			Fraction f1 = new Fraction(10, 15);
			assertEquals(f1.getNumerator(), expectedNumerator);
			assertEquals(f1.getDenominator(), expectedDenominator);
			
			expectedNumerator = -2;
			f1 = new Fraction(10, -15);
			assertEquals(f1.getNumerator(), expectedNumerator);
			assertEquals(f1.getDenominator(), expectedDenominator);
			
			expectedNumerator = 2;
			expectedDenominator = 3;
			f1 = new Fraction(-10, -15);
			assertEquals(f1.getNumerator(), expectedNumerator);
			assertEquals(f1.getDenominator(), expectedDenominator);
			
			expectedNumerator = 3;
			expectedDenominator = 1;
			f1 = new Fraction(30, 10);
			assertEquals(f1.getNumerator(), expectedNumerator);
			assertEquals(f1.getDenominator(), expectedDenominator);
		}
		catch (IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testEquals() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(3, 9);
		Fraction f3 = new Fraction();
		Fraction f4 = new Fraction(0, 1);
		
		assertTrue(f1.equals(f2));
		assertTrue(f3.equals(f4));
		assertFalse(f1.equals(f3));
		assertFalse(f2.equals(f4));
	}
	
	@Test
	public void testToString() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(3, 5);
		Fraction f3 = new Fraction(5, 1);
		Fraction f4 = new Fraction();
		
		assertEquals("1/3", f1.toString());
		assertEquals("3/5", f2.toString());
		assertEquals("5", f3.toString());
		assertEquals("0", f4.toString());
	}
	
	@Test
	public void testValue() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(2, 9);
		Fraction f3 = new Fraction(1, 2);
		
		assertEquals(0.33333333, f1.value(), EPSILON);
		assertEquals(0.22222222, f2.value(), EPSILON);
		assertEquals(0.5, f3.value(), EPSILON);
		
	}
	
	@Test
	public void testAdd() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(6, 3);
		Fraction f3 = new Fraction(7, 2);
		
		Fraction f = f1.add(f2);
		assertEquals(new Fraction(7,3), f);
		
		f = f1.add(f1);
		assertEquals(new Fraction(2,3), f);
		
		f = f2.add(f2);
		assertEquals(new Fraction(4,1), f);
		
		f = f1.add(f3);
		assertEquals(new Fraction(23,6), f);
	}
	
	@Test
	public void testMult() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(6, 3);
		Fraction f3 = new Fraction(7, 2);
		
		Fraction f = f1.mul(f1);
		assertEquals(new Fraction(1, 9), f);
		
		f = f1.mul(f2);
		assertEquals(new Fraction(6,9), f);
		
		f = f2.mul(f3);
		assertEquals(new Fraction(42,6), f);
		
		f = f2.mul(f2);
		assertEquals(new Fraction(4,1), f);
	}
	
	@Test
	public void testSub() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(6, 3);
		Fraction f3 = new Fraction(7, 2);
		
		Fraction f = f1.sub(f2);
		assertEquals(new Fraction(-5,3), f);
		
		f = f1.sub(f1);
		assertEquals(new Fraction(0,3), f);
		
		f = f2.sub(f2);
		assertEquals(new Fraction(0,1), f);
		
		f = f1.sub(f3);
		assertEquals(new Fraction(-19,6), f);
	}
	
	@Test
	public void testDiv() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(1, 4);
		Fraction f3 = new Fraction(1, 6);
		
		Fraction f = f1.div(f2);
		assertEquals(new Fraction(8,3), f);
		
		f = f1.div(f1);
		assertEquals(new Fraction(1,1), f);
		
		f = f2.div(f3);
		assertEquals(new Fraction(6,4), f);
		
		f = f1.div(f3);
		assertEquals(new Fraction(12,3), f);
	}
}
