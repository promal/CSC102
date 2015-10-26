/**
 * This interface is intended for educational purposes to better understand 
 * how to properly use an interface. Defines the basic operations for a list. 
 * The user of this interface has precise control over where in the list each element is inserted.
 * @author Alejandro Guzman
 * @version 07/11/2015
 */
public interface BasicList {
	/**
	 * Adds (inserts) the specified element at the specified index of 
	 * the list - note that it does not overwrite any existing data at 
	 * that location. This method does allow adding to the first index 
	 * beyond the end of the list. For example, if a list had a size of 10, 
	 * the index 9 is its logical end but this method allows added an 
	 * element at index 10.
	 * @param index The index to add the specified element.
	 * @param element The element to add to the specified position.
	 * @throws java.lang.IndexOutOfBoundsException when the specified index is out of range or negative.
	 */
	void add(int index, Object element);
	
	/**
	 * Adds the specified element to the logical end of the list.
	 * @param element The element to add to the logical end of the list.
	 */
	void add(Object element);
	
	/**
	 * Clears the list of its contents - the size of the list should be zero 
	 * and its capacity should be unaffected.
	 */
	void clear();
	
	/**
	 * Using the provided element's equals method, this method determines if 
	 * the list contains the specified element or not.
	 * @param element The element to search for in the list.
	 * @return true if the list contains an element logically equal to the specified 
	 * element, otherwise false.
	 */
	boolean contains(Object element);
	
	/**
	 * Returns a reference to the element at the specified index.
	 * @param index The index of the element you want to get.
	 * @return The element at the specified index.
	 * @throws java.lang.IndexOutOfBoundsException when the specified index is out of range or negative.
	 */
	Object get(int index);
	
	/**
	 * Using the provided element's equals method, this method returns the index of the first element in 
	 * the list that is equal to the provided element, if any.
	 * @param element The element to search for.
	 * @return The index of the first matching element in the list.
	 * @throws java.util.NoSuchElementException - if the list does not contain the specified element.
	 */
	int indexOf(Object element);
	
	/**
	 * Removes (and returns) the specified element from the list.
	 * @param index The index of the element you want to remove.
	 * @return The element that was removed from the list.
	 * @throws java.lang.IndexOutOfBoundsException - Thown when the specified index is negative or past the logical end of the list.
	 */
	Object remove(int index);
	
	/**
	 * Sets (replaces) the element at the specified index.
	 * @param index The index of the element whose you want to set (change).
	 * @param element the new element that replaces the old element.
	 * @return The old element (before you changed it) at the specified index.
	 * @throws java.lang.IndexOutOfBoundsException - Thown when the specified index is negative or past the logical end of the list.
	 */
	Object set(int index, Object element);
	
	/**
	 * The logical size of the list (the number of elements that have been added and not removed).
	 * @return The number of elements currently in the list.
	 */
	int size();
}
