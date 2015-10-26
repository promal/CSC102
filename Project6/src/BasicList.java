public interface BasicList<E> {
	/**
	 * Adds the specified element ot the logical end of the list.
	 * @param element the element to add to the logical end of the list.
	 */
	void add(E element);
	
	/**
	 * Adds (inserts) the specified element at the specified index of the list.
	 * Note that it does not overwrite any existing data at that location.
	 * @param index The index to add (insert) the specified element.
	 * @param element The element to add (insert) to the specified position.
	 * @throws java.lang.IndexOutOfBoundsException when the index is negative or past the logical end.
	 */
	void add(int index, E element);
	
	/**
	 * Clears the list of its contents. The list should
	 * be in the same state it is after being constructed 
	 * with default constructor.
	 */
	void clear();
	
	/**
	 * Returns the number of elements in the list with O(1) performance. 
	 * @return the size of the list.
	 */
	int size();
	
	/**
	 * Returns a reference to the element at the specified index. 
	 * @param index the location of the element we want.
	 * @return the value of the specified reference.
	 */
	E get(int index);
	
	/**
	 * Using the provided element's equals method, this method determines if the list contains the specified element or not. 
	 * @param element The element to search for in the list. 
	 * @return true if the list contains an element logically equal to the specified element, otherwise false.
	 */
	boolean contains(E element);
	
	/**
	 * Using the provided element's equals method, this method returns the 
	 * index of the first element in the list that is equal 
	 * to the provided element, if any.
	 * @param element the element to find in the list.
	 * @return the location of the first matching element in the list.
	 * @throws java.util.NoSuchElementException - if the list does not contain the specified element.
	 */
	int indexOf(E element);
	
	/**
	 * Removes (and returns) the specified element from the list.
	 * @param index the location of the reference.
	 * @return the value that was removed.
	 * @throws java.lang.IndexOutOfBoundsException - Thown when the specified index is negative or past the logical end of the list.
	 */
	E remove(int index);
	
	/**
	 * Returns a reference to the element at the specified index.
	 * @param index the location of the reference.
	 * @param element the new data value to add at index.
	 * @return the old value that was replaced.
	 * @throws java.lang.IndexOutOfBoundsException - Thown when the specified index is negative or past the logical end of the list.
	 */
	E set(int index, E element);
}
