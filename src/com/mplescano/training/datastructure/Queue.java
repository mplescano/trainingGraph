package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	
	private Node<Item> last;
	
	private int size;
	
	public Queue() {
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue overflow");
		}
		return first.getItem();
	}
	
	public void enqueue(Item item) {
		Node<Item> oldLast = last;
		last = new Node<Item>(item);
		last.setNext(null);
		if (isEmpty()) {
			first = last;
		}
		else {
			oldLast.setNext(last);
		}
		size++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue overflow");
		}
		Item item = first.getItem();
		first = first.getNext();
		size--;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {

		private Node<Item> current;
		
		public ListIterator(Node<Item> firstItem) {
			current = firstItem;
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

    /**
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("3");
        queue.enqueue("4final");
        
        System.out.println("Before to dequeue	:" + queue);
        queue.dequeue();
        
        System.out.println("(" + queue.size() + " left on queue)");
        System.out.println("to string:" + queue);
        
    }
	
}
