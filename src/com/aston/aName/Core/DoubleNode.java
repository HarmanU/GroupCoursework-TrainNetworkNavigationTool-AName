package com.aston.aName.Core;

public class DoubleNode<T> {
	private DoubleNode<T> previous; // reference to the previous node
	private DoubleNode<T> next; // reference to the next node
	private T element; // the element stored in this node

	public DoubleNode() {
		next = null;
		element = null;
		previous = null;
	}

	public DoubleNode(T elem) {
		next = null;
		element = elem;
		previous = null;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setNext(DoubleNode<T> dnode) {
		next = dnode;
	}

	public void setPrevious(DoubleNode<T> dnode) {
		previous = dnode;

	}

	public T getElement() {
		return element;
	}

	public void setElement(T elem) {
		element = elem; 
	}
}
