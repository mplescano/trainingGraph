package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * some kind of last-in-none-out.
 * 
 * it seems a linked list implementation.
 * 
 * A bag is a collection where removing items is not supported—its purpose is to
 * provide clients with the ability to collect items and then to iterate through
 * the collected items.
 * 
 * @author njoaquin.programador
 *
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

	private Node<Item> head;

	private int size;

	public Bag() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	/**
	 * the element added in the tail becomes the first in the tail
	 * 
	 * @param item
	 */
	public void add(Item item) {
		Node<Item> oldHead = head;
		head = new Node<Item>(item);
		head.setNext(oldHead);
		size++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(head);
	}

	private class ListIterator<Item> implements Iterator<Item> {

		private Node<Item> current;

		public ListIterator(Node<Item> item) {
			current = item;
		}

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
	 * Unit tests the {@code Bag} data type.
	 *
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		bag.add("one");
		bag.add("two");
		bag.add("three");
		bag.add("four");

		System.out.println("size of bag = " + bag.size());
		for (String s : bag) {
			System.out.println(s);
		}
	}
}
