package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 * 
 * @author njoaquin.programador
 *
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> head;     // top of stack
    
    private int size;                // size of the stack
	
    /**
     * Initializes an empty stack.
     */
    public Stack() {
        head = null;
        size = 0;
    }
    
    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return size;
    }
    
	public void push(Item item) {
		Node<Item> oldHead = head;
		head = new Node<Item>(item);
		head.setNext(oldHead);
		size++;
	}
	
	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack undeflow");
		}
		Item item = head.getItem();
		head = head.getNext();
		size--;
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return head.getItem();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(head);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		
		private Node<Item> current;
		
		public ListIterator(Node<Item> head) {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.getItem();
			current = current.getNext();
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}