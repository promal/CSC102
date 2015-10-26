/**
 * This implementation is a sample of the structure you will follow for all of
 * the SUnit tests you write this quarter.
 *
 * @author Alejandro Guzman
 * @version 01/23/2014 - Initial revision.
 */
public class BasicLinkedListTest {
	public static class SUnit {
		private static int countTest = 0;
		private static int countFailedTest = 0;;

		/**
		 * The number of tests performed.
		 * 
		 * @return countPassTest the number of tests that were performed.
		 */
		public static int testsRun() {
			return countTest;
		}

		/**
		 * The number of test failed.
		 * 
		 * @return the number of failed test.
		 */
		public static int testsFailed() {
			return countFailedTest;
		}

		/**
		 * Test method add in BasicLinkedList
		 */
		public static boolean testAdd(BasicList<Integer> testList) {
			countTest++;
			boolean flag = true;
			
			java.util.LinkedList<Integer> list = 
					new java.util.LinkedList<Integer>();
			
			// Expected values
			for (int i = 0; i < 5; i++) {
				list.add(new Integer(i));
			}
			
			// Compare values
			for (int i = 0; i < 5; i++) {
				flag &= list.get(i).equals(testList.get(i));
			}
			
			if (!flag) {
				countFailedTest++;
			}
			
			return flag;
		}
		
		/**
		 * Test method add with index and element parameter
		 */
		public static boolean testAddParamters(BasicList<Integer> testList) {
			countTest++;
			boolean flag = true;
			
			java.util.LinkedList<Integer> list = 
					new java.util.LinkedList<Integer>();
			
			// Expected values
			for (int i = 0; i < 10; i++) {
				list.add(new Integer(i));
			}
			
			list.add(5, new Integer(20));
			list.add(6, new Integer(25));
			list.add(7, new Integer(30));
			list.add(8, new Integer(35));
			list.add(14, new Integer(39));
			list.add(0, new Integer(100));
			
			// Compare values
			for (int i = 0; i < list.size(); i++) {
				try 
				{
					flag &= list.get(i).equals(testList.get(i));
				} 
				catch (IndexOutOfBoundsException e) {
					countFailedTest++;
					return false;
				}
		
		
			}
			
			if (!flag) {
				countFailedTest++;
			}
			
			return flag;
		}
		
		/**
		 * Test if the list is empty after construction.
		 * @param testList the list to test against.
		 * @return true if list is empty false otherwise.
		 */
		public static boolean testEmptyConstructor(BasicList<Integer> testList) {
			countTest++;
			boolean flag = true;
			flag &= (new java.util.LinkedList<Integer>().size() == testList.size());
			if (!flag) { countFailedTest++; }
			return flag;
		}
		
		/**
		 * Test if the list represents an empty list when clearing.
		 * @param testList the list to test against.
		 * @return true if the list is cleared false otherwise.
		 */
		public static boolean testClear(BasicList<Integer> testList) {
			countTest++;
			boolean flag = true;
			
			java.util.LinkedList<Integer> list = 
					new java.util.LinkedList<Integer>();
			// Expected values
			for (int i = 0; i < 10; i++) {
				list.add(new Integer(i));
			}
			
			list.add(5, new Integer(20));
			list.add(6, new Integer(25));
			list.add(7, new Integer(30));
			list.add(8, new Integer(35));
			list.add(14, new Integer(39));
			list.add(0, new Integer(100));
			
			list.clear();
			
			flag &= (list.size() == testList.size());
			
			if (!flag) { countFailedTest++; }

			return flag;
		}
		

	}

	// This value represents the epsilon value to use with the following method:
	//
	// SUnit.assertEquals(double expect, double actual, double espilon)
	//
	// The correct value to use is problem-specific so be sure to change it
	// as necessary.
	private static final double E = 0.000001;

	/**
	 * Calls all test methods - place all of your tests or, better yet, all of
	 * your calls to methods that contain the tests here. Placing all of the
	 * tests in a method other than main allows different programs to make use
	 * of the tests.
	 */
	public static void testAll() {
		testEmptyConstructor();
		testAddOneParameter();
		testAddTwoParameter();
		testClear();
		
	}

	public static void testEmptyConstructor() {
		boolean flag = true;
		System.out.print("testEmptyConstructor");
		BasicList<Integer> list = new BasicLinkedList<Integer>();
		flag &= SUnit.testEmptyConstructor(list);
		pass(flag);
	}
	
	public static void testAddOneParameter() {
		boolean flag = true;
		System.out.print("testAddOneParameter");
		BasicList<Integer> list = new BasicLinkedList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		
		flag &= SUnit.testAdd(list);
		pass(flag);
		
	}
	
	public static void testAddTwoParameter() {
		boolean flag = true;
		System.out.print("testAddTwoParameter");
		BasicList<Integer> list = new BasicLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		list.add(5, new Integer(20));
		list.add(6, new Integer(25));
		list.add(7, new Integer(30));
		list.add(8, new Integer(35));
		list.add(14, new Integer(39));
		list.add(0, new Integer(100));

		flag &= SUnit.testAddParamters(list);
		pass(flag);
	}
	
	public static void testClear() {
		boolean flag = true;
		System.out.print("testClear");
		BasicList<Integer> list = new BasicLinkedList<Integer>();
		
		list.add(new Integer(0));
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		
		list.clear();
		
		flag &= SUnit.testClear(list);
		pass(flag);
		
	}
	
	public static void pass(boolean pass) {
		if (pass) {
			System.out.println(" Passed");
		} else {
			System.out.println(" Failed");
		}
	}
	/**
	 * Sample test method to use as a model for you actual test methods - be
	 * sure to choose meaningful names to make your code readable!
	 */
	public static void testSampleMethod() {
		// This is where you would develop test inputs, call the method being
		// tested, and use the SUnit methods to verify the results.
		

	}

	/**
	 * DO NOT MODIFY THIS METHOD! Calls testAll to run all tests and report the
	 * number of tests that were run and how many failed. Not putting the tests
	 * in main allows them to be run by another program if and when desired.
	 * 
	 * @param args
	 *            Any arguments specified when the program was run.
	 */
	public static void main(String[] args) {
		// Run all the tests...
		testAll();

		// Display number of tests run and how many failed...
		System.out.println("SUnit: " + SUnit.testsRun() + " tests run, "
				+ SUnit.testsFailed() + " tests failed");
	}
}
