import java.util.Arrays;

/**
 * We define a basic array list that will perform some of the basic operations
 * that are define the BasicList interface that is defined. We will use an array
 * to store the contents of our data. While this class can be implemented as a generic class
 * we opted not to therefore users of this class must cast the return values to their respective
 * value. For instance, if Rectangle objects are stored we must cast to Rectangle. Note this array list
 * class can store any type therefore it is recommended that users of this class store only of one type.  
 * @author Alejandro Guzman
 * @version 07/11/15
 */
public class BasicArrayList implements BasicList {
	/* Static Fields */
	public static final int DEFAULT_CAPACITY = 10;
	
	/* Private fields */
	private Object[] list;
	private int logicalSize;
	
	/**
	 * Default constructor - initializes the list to have a capacity equal to the DEFAULT_CAPACITY and a logical size of zero.
	 */
	public BasicArrayList() {
		this.list = new Object[DEFAULT_CAPACITY];
		this.logicalSize = 0;
	}
	
	/**
	 * Constructor - initializes the list to have the specified capacity (but never less than the DEFAULT_CAPACITY) and a logical size of 0.
	 * @param capacity The capacity of the list. In other words, the size to allocate for your internal array.
	 */
	public BasicArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		this.logicalSize = 0;
		this.list = new Object[capacity];
	}
	
	public int size() {
		return this.logicalSize;
	}
	
	/**
	 * This method should not be here because it breaks the integrity of the data. However,
	 * for testing purposes we will use it afterwards it will be commented out.
	 * @return the contents that are currently stored in the array.
	 */
//	public Object[] getData() {
//		return this.list;
//	}
	
	/**
	 * This method is just used for testing purposes. Gets the size of the array.
	 * @return The length of the array.
	 */
	public int capacity() {
		return this.list.length;
	}

	@Override
	public void add(int index, Object element) throws IndexOutOfBoundsException {
		checkBoundsExclusive(index);

		if (this.logicalSize == this.list.length) {
			resizeArray();
		}
			
		if (this.list[index] == null) {
			this.list[index] = element;
		} 
		else {
			// shift to the right
			for (int shiftPosition = this.logicalSize; shiftPosition > index; shiftPosition--) {
				this.list[shiftPosition] = this.list[shiftPosition - 1];
			}
			this.list[index] = element;
		}
		this.logicalSize++;
	}

	@Override
	public void add(Object element) {
		if (this.logicalSize >= this.list.length) {
			resizeArray();
		}
		this.list[this.logicalSize] = element;
		this.logicalSize++;
	}

	@Override
	public void clear() {
		this.logicalSize = 0;
	}

	@Override
	public boolean contains(Object element) {
		for (int index = 0; index < this.list.length; index++) {
			if ((this.list[index] != null && element != null) && this.list[index].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		checkBoundsInclusive(index);		
		return this.list[index];
	}

	@Override
	public int indexOf(Object element) {
		for (int index = 0; index < this.logicalSize; index++) {
			if (this.list[index].equals(element)) {
				return index;
			}
		}
		throw new java.util.NoSuchElementException();
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		checkBoundsInclusive(index);
		Object removeElement = this.list[index];
		for (int pos = index + 1; pos < this.logicalSize; pos++) {
			this.list[pos - 1] = this.list[pos];
		}
		this.logicalSize--;
		return removeElement;
	}

	@Override
	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		checkBoundsInclusive(index);	
		Object old = this.list[index];
		this.list[index] = element;
		return old;
	}
	
	/**
	 * 
	 * Frees up any unused space in the list by reducing the capacity of the list to 
	 * its size but never less than the DEFAULT_CAPACITY. This method takes advantage of
	 * the fact that the Java Garbage Collector will reclaim any memory that is no longer 
	 *  in use - we love the Garbage Collector!
	 */
	public void trimToSize() {
		Object[] trimArray = null;
		int trimSize = (this.logicalSize < BasicArrayList.DEFAULT_CAPACITY) ? BasicArrayList.DEFAULT_CAPACITY : this.logicalSize;
		if (this.list.length > BasicArrayList.DEFAULT_CAPACITY) {
			trimArray = new Object[trimSize];
			for (int index = 0; index < this.logicalSize; index++) {
				trimArray[index] = this.list[index];
			}
			this.list = trimArray;
		}
	}
	
	private void checkBoundsInclusive(int index) {
		if (index < 0 || index >= this.logicalSize) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void checkBoundsExclusive(int index) {
		if (index < 0 || index > this.logicalSize) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void resizeArray() {
		Object[] dest = new Object[this.list.length * 2];
		System.arraycopy(this.list, 0, dest, 0, this.list.length);
		this.list = dest;
	}
}
