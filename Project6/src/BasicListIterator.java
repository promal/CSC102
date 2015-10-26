public interface BasicListIterator<E> extends java.util.Iterator<E> {
	/**
	 * Returns true if the iterator has a previous element. This method does not change the state of the iterator. 
	 * Calling this method on a new BasicListIterator before any calls to next() will always return false.
	 * @return true if the iterator has a previous element, otherwise false.
	 */
	boolean hasPrevious();
	
	/**
	 * Returns the previous element and moves the iterator backward one position with O(1) performance. 
	 * @return The previous element. 
	 * @throws java.util.NoSuchElementException - if there is no previous element.
	 */
	E previous();
	
	/**
	 * Moves the iterator past the next element.
	 * @return the traversed element
	 */
	E next();
	
	/**
	 *	Tests if there is an element after the iterator position.
	 *	@return true if there is an element after the iterator position
	 */
	boolean hasNext();

	void remove();
}