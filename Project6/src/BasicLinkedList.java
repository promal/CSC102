import java.util.Iterator;


public class BasicLinkedList<E> implements BasicList<E>, java.lang.Iterable<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	/**
	 * Construct an empty BasicLinkedList.
	 */
	public BasicLinkedList() {
		this.size = 0;
		this.first = this.last = null;
	}
	
	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>();
		newNode.data = element;
		if (this.first == null) {
			this.last = this.first = newNode;
		} else {
			this.last.next = newNode;
			newNode.prev = this.last;
			this.last = newNode;
		}
		this.size++;
	}

	
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > this.size) { throw new IndexOutOfBoundsException(); }
		if (this.size == index) {
			this.add(element);
		} else {
			Node<E> newNode = new Node<E>();
			newNode.data = element;
			addBefore(newNode, index);
			this.size++;
		}
	}

	@Override
	public void clear() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}	
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }
		Node<E> iterNode = this.first;
		for (int i = 0; i < index; i++) { iterNode = iterNode.next; }
		return iterNode.data;
	}
	
	@Override
	public boolean contains(E element) {
		boolean found = true;
		try {
			indexOf(element);
		} catch(java.util.NoSuchElementException e) {
			found = false;
		}
		return found;
	}

	@Override
	public int indexOf(E element) {
		int index;
		boolean found = false;
		Node<E> iterNode = this.first;
		for (index = 0; index < this.size && !found; index++) {
			if ((iterNode.data == null && element == null) || iterNode.data.equals(element)) { 
				found = true; 
				index--;
			}
			iterNode = iterNode.next;
		}
		if (!found) { throw new java.util.NoSuchElementException(); }
		return index;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }
		E data = null;
		if (index == this.size - 1) { 
			data = removeLast(); 
		} else if (index == 0) {
			data = removeFirst();
		} else {
			Node<E> iterNode = this.first;
			for (int i = 0; i < index; i++) { iterNode = iterNode.next; }
			data = iterNode.data;
			Node<E> previous = iterNode.prev;
			previous.next = iterNode.next;
			iterNode.next.prev = previous;
		}
		this.size--;
		return data;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException(); }
		E data = null;
		Node<E> iterNode = this.first;
		for (int i = 0; i < index; i++) { iterNode = iterNode.next; }
		data = iterNode.data;
		iterNode.data = element;
		return data;
	}
	

	/**
	 * Returns a reference to a unique instance of a private inner class implementing the BasicListIterator interface. 
	 * @return An instance of a private inner class implementing the BasicListIterator interface.
	 */
	public BasicListIterator<E> basicListIterator() {
		return new BasicIterator<E>();
	}
	
	/**
	 * Returns an iterator over the list of elements of type E. 
	 * @return An iterator over the list of elements. 
	 * Don't forget that BasicListIterator extends Iterator!
	 */
	@Override
	public Iterator<E> iterator() {
		return new BasicIterator<E>();
	}
	
	
	private class BasicIterator<E> implements BasicListIterator<E> {
		private Node<E> position;
		private Node<E> previous;
		
		public BasicIterator() {
			position = previous = null;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public E next() {
			if (!hasNext()) { throw new java.util.NoSuchElementException(); }
			previous = position; // will be used for removed
			
			if (position == null) {
				position = (Node<E>) first;
			} else {
				position = position.next;
			}
			
			return position.data;
		}
		
		@Override
		public boolean hasPrevious() {
			return position != null;
		}

		@Override
		public E previous() {
			if (!hasPrevious()) { throw new java.util.NoSuchElementException(); }
			E data = position.data;
			position = position.prev;
			return data;
		}

		@Override
		public boolean hasNext() {
			if (position == null) {
				return first != null; // special case if position is before first
			}
			return position.next != null; // check if there is a next element after the current position
		}

		
	}
	
	/**
	 * Private class Node used to create a chain of nodes
	 * with reference to the previous and next nodes, in addition
	 * to its values. This is just a helper class to BasicLinkedList
	 * to represent its internal representation.
	 * @author Alejandro Guzman 10/15/2015
	 */
	private static class Node<E> {
		public Node<E> next;
		public Node<E> prev;
		public E data;
		
		public Node() {
			
		}
	}
	
	/**
	 * Adding element at beginning or middle of the list.
	 * @param newNode the node to be added at the middle or first of the link.
	 * @param index the location to add the new reference.
	 */
	private void addBefore(Node<E> newNode, int index) {
		Node<E> iterNode = this.first;
		Node<E> iterPrev = null;
		
		for (int i = 0; i < index; i++) { 
			iterPrev = iterNode;
			iterNode = iterNode.next; 
		}
		
		if (iterPrev == null) {
			newNode.next = this.first;
			this.first.prev = newNode;	
			this.first = newNode;
		} else {
			iterNode.prev.next = newNode;
			newNode.prev = iterNode.prev;
			newNode.next = iterNode;
			iterNode.prev = newNode;
		}
	}
	
	/**
	 * Removes the last element in the list.
	 */
	private E removeLast() {
		E data = this.last.data;
		this.last = this.last.prev;
		if (last == null) {
			this.first = null;
		} else {
			this.last.next = null;
		}
		return data;
	}
	
	/**
	 * Removes the first element in the list.
	 */
	private E removeFirst() {
		E data = this.first.data;
		this.first = this.first.next;
		this.first.prev = null;
		return data;
	}
}
