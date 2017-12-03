package com.aston.aName.Core;
import java.util.Iterator;

public abstract class DoubleList<T> {
	protected DoubleNode<T> front; // first node of this doubly linked list
	protected DoubleNode<T> rear; // last node of this doubly linked list
	protected int count; // size of the list

	/** Constructor: Creates an empty list. */
	protected DoubleList() {
		rear = null;
		front = null;
		count = 0;
	}

	/** Removes and returns the last element in this list. */
	protected T removeLast() {
		if (isEmpty())
			throw new IllegalStateException("list empty in removeLast");

		T result = rear.getElement();
		rear = rear.getPrevious();
		count--;
		if (rear == null)
			front = null;
		else
			rear.setNext(null);

		return result;
	}

	/** Removes and returns the first element in this list. */
	protected T removeFirst() {
		if (isEmpty())
			throw new IllegalStateException("list empty in removeFirst");

		T result = front.getElement();
		front = front.getNext();
		count--;
		if (front == null)
			rear = null;
		else
			front.setPrevious(null);

		return result;
	}

	/** Removes the specified node. */
	protected void remove(DoubleNode<T> node) {
		if (node == null)
			throw new IllegalArgumentException("Null node ref. in remove");
		if (isEmpty())
			throw new IllegalStateException("list empty in remove");

		if (node == front)
			this.removeFirst();
		else if (node == rear)
			this.removeLast();
		else { // assume that the required node is the current node
			node.getNext().setPrevious(node.getPrevious());
			node.getPrevious().setNext(node.getNext());
			count--;
		}
	}

	/** adds the element at the head of the list */
	protected void addFirst(T element) {
		DoubleNode<T> node = new DoubleNode<T>(element);
		node.setNext(front); // link new node to rest of list
		front = node; // update front
		if (count == 0) // empty list
			rear = node; // update rear
		else
			// make old front node’s previous link point to new node
			front.getNext().setPrevious(node);
		count++;
	}

	/** adds the element at the end of the list */
	protected void addLast(T element) {
		DoubleNode<T> node = new DoubleNode<T>(element);
		node.setPrevious(rear);
		rear = node;
		if(front == null){
			front = node;
		}
		else{
			node.setNext(null);
		}	
		count++;
	}

	/** Adds the element to the list after the current node */
	protected void addAfter(DoubleNode<T> current, T element) {
		if (current == null)
			throw new IllegalArgumentException("null node ref. in addAfter");

		if (current == rear) {
			addLast(element);
		} else {
			DoubleNode<T> node = new DoubleNode<T>(element);
			node.setNext(current.getNext());
			node.setPrevious(current);
			current.getNext().setPrevious(node);
			current.setNext(node);
			count++;
		}
	}

	/** Returns first node containing the target, or null if not found */
	protected DoubleNode<T> find(T target) {
		DoubleNode<T> cursor = front;

		while (cursor != null) {
			if (target.equals(cursor.getElement())) {
				return cursor;
			} else {
				cursor = cursor.getNext();
			}
		}
		return null;
	}

	/** Returns true if the list contains the element and false otherwise */
	public boolean contains(T element) {
		return (find(element) != null);
	}

	/** Returns true if this list is empty and false otherwise. */
	public boolean isEmpty() {
		return (count == 0);
	}

	/** Returns the number of elements currently in this list. */
	public int size() {
		return count;
	}

	/** Sets the list to empty */
	public void clear() {
		front = null;
		rear = null;
		count = 0;
	}

	/** Returns an iterator for the elements in this list. */
	public Iterator<T> iterator() {
		return new DoubleIterator();
	}

	//inner class
	private class DoubleIterator implements Iterator<T> {
		private DoubleNode<T> cursor; // next node to be returned by the iterator
		private DoubleNode<T> node; // node returned by the last call to next

		public DoubleIterator() {
			cursor = front;
			node = null;
		}

		public boolean hasNext() {
			return (cursor != null);
		}

		public T next() {
			if (!hasNext())
				throw new IllegalStateException();
			node = cursor;
			T result = cursor.getElement();
			cursor = cursor.getNext();
			return result;
		}

		/** remove the current element in the iteration */
		public void remove() {
			if (node == null)
				throw new IllegalStateException("no current element to remove");

			if (node == rear) { // last element to be removed
				rear = rear.getPrevious();
				if (rear == null) // this list had 1 element and is now empty
					front = null;
				else
					rear.setNext(null);
			} else if (node == front) { // first element to be removed
				// list cannot have only 1 element (when front == rear) here
				// as that case was dealt with above
				front = front.getNext();
				front.setPrevious(null);
			} else { // internal element to be removed
				node.getNext().setPrevious(node.getPrevious());
				node.getPrevious().setNext(node.getNext());
			}
			count--;
			node = null; // ensure remove can only be called once per iteration
		}
	}

}



