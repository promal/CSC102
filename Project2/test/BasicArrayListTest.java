import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class BasicArrayListTest {

	@Test
	public void testDefaultCapacity() {
		assertEquals(BasicArrayList.DEFAULT_CAPACITY, 10);
	}
	
	@Test
	public void testBasicArrayListImplementsBasicList() {
		assertTrue(BasicList.class.isAssignableFrom(BasicArrayList.class));
	}
	
	@Test
	public void testDefaultBasicArrayListConstructor() {
		BasicArrayList list = new BasicArrayList();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testNoSuchElementException() {
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		
		try
		{
			l1.indexOf(new Integer(40));
			fail();
		}
		catch (java.util.NoSuchElementException e) {
			
		}
		
		try
		{
			l1.indexOf(new Integer(-30));
			fail();
		}
		catch (java.util.NoSuchElementException e) {
			
		}
	}
	
	@Test
	public void testIndexOutOfBoundsException() {
		BasicArrayList l1 = new BasicArrayList();
		
		try
		{
			l1.add(15, new Integer(5));
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try
		{
			l1.add(-1, new Integer(1));
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try
		{
			l1.get(-1);
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try
		{
			l1.get(11);
			fail();
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testBasicArrayListConstructor() {
		BasicArrayList l1 = new BasicArrayList(5);
		assertEquals(l1.size(), 0);
		assertEquals(l1.capacity(), 10);
		assertTrue(l1.capacity() != 5);

		BasicArrayList l2 = new BasicArrayList(20);
		assertEquals(l2.size(), 0);
		assertEquals(l2.capacity(), 20);
		assertTrue(l2.capacity() == 20);
	}
	
	@Test
	public void testAddOneParameter() {
		int index;

		Object[] expectedData = new Object[15];
		BasicArrayList l1 = new BasicArrayList(15);
		
		assertEquals(l1.capacity(), 15);

		for (index = 0; index < 3; index++) {
			l1.add(new Integer(index));
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 3);
		//assertArrayEquals(l1.getData(), expectedData);
		
		for (index = 3; index < 6; index++) {
			l1.add(new Integer(index));
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 6);
		//assertArrayEquals(l1.getData(), expectedData);

		for (index = 6; index < 15; index++) {
			l1.add(new Integer(index));
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 15);
		//assertArrayEquals(l1.getData(), expectedData);
		
		Object[] dest = new Object[expectedData.length * 2];
		System.arraycopy(expectedData, 0, dest, 0, expectedData.length);
		expectedData = dest;
		
		for (index = 15; index < 30; index++) {
			l1.add(new Integer(index));
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 30);
		//assertArrayEquals(l1.getData(), expectedData);
		assertEquals(l1.capacity(), 30);

	}
	
	@Test
	public void testAddTwoParameter() {
		int index;

		Object[] expectedData = new Object[15];
		BasicArrayList l1 = new BasicArrayList(15);
		
		assertEquals(l1.capacity(), 15);

		for (index = 0; index < 3; index++) {
			try
			{
				l1.add(index, new Integer(index));
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println(e);
			}
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 3);
		//assertArrayEquals(l1.getData(), expectedData);
		
		for (index = 3; index < 6; index++) {
			try
			{
				l1.add(index, new Integer(index));
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println(e);
			}
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 6);
		//assertArrayEquals(l1.getData(), expectedData);

		for (index = 6; index < 15; index++) {
			try
			{
				l1.add(index, new Integer(index));
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println(e);
			}
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 15);
		//assertArrayEquals(l1.getData(), expectedData);
		
		Object[] dest = new Object[expectedData.length * 2];
		System.arraycopy(expectedData, 0, dest, 0, expectedData.length);
		expectedData = dest;
		
		for (index = 15; index < 30; index++) {
			try
			{
				l1.add(index, new Integer(index));
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println(e);
			}
			expectedData[index] = new Integer(index);
		}
		
		assertEquals(l1.size(), 30);
		//assertArrayEquals(l1.getData(), expectedData);
		assertEquals(l1.capacity(), 30);
		
		dest = new Object[expectedData.length * 2];
		System.arraycopy(expectedData, 0, dest, 0, expectedData.length);
		expectedData = dest;
		
		try
		{
			l1.add(30, new Integer(30));
			expectedData[30] = new Integer(30);
		}
		catch (IndexOutOfBoundsException e) {
			fail();
		}
		
		assertEquals(l1.size(), 31);
		//assertArrayEquals(l1.getData(), expectedData);
		assertEquals(l1.capacity(), 60);
	}
	
	@Test
	public void testContains() {
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		l1.add(new Integer(45));
		l1.add(new Integer(55));
		
		assertTrue(l1.contains(new Integer(45)));
		assertTrue(l1.contains(new Integer(25)));
		assertFalse(l1.contains(new Integer(15)));
		assertFalse(l1.contains(new Integer(-20)));

	}
	
	@Test
	public void testClear() {
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		l1.add(new Integer(45));
		l1.add(new Integer(55));
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		l1.add(new Integer(45));
		l1.add(new Integer(55));
		
		assertEquals(l1.size(), 8);
		assertEquals(l1.capacity(), 10);
		
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		l1.add(new Integer(45));
		l1.add(new Integer(55));
		
		assertEquals(l1.size(), 12);
		assertEquals(l1.capacity(), 20);
		
		l1.clear();
		
		assertEquals(l1.size(), 0);
		assertEquals(l1.capacity(), 20);
	}
	
	@Test
	public void testGet() {
		Object testValue;
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		
		try
		{
			testValue = l1.get(0);
			assertEquals(testValue, new Integer(25));
			
			testValue = l1.get(1);
			assertEquals(testValue, new Integer(35));
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testIndexOf() {
		int testValue;
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		
		try
		{
			testValue = l1.indexOf(new Integer(25));
			assertEquals(testValue, 0);
			
			testValue = l1.indexOf(new Integer(35));
			assertEquals(testValue, 1);
		}
		catch (java.util.NoSuchElementException e) {
			
		}
	}
	
	@Test
	public void testSet() {
		Object testValue;
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		
		try
		{
			testValue = l1.set(0, new Integer(35));
			assertEquals(testValue, new Integer(25));
			
			testValue = l1.set(1, new Integer(45));
			assertEquals(testValue, new Integer(35));
			
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testRemove() {
		Object testValue;
		BasicArrayList l1 = new BasicArrayList();
		l1.add(new Integer(25));
		l1.add(new Integer(35));
		
		try
		{
			testValue = l1.remove(0);
			assertEquals(testValue, new Integer(25));
			
			testValue = l1.remove(0);
			assertEquals(testValue, new Integer(35));
			
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
}
