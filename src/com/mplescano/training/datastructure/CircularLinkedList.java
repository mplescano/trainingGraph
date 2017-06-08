package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> implements Iterable<Item> {
	
	private Node<Item> head;
	
	private Node<Item> tail;
	
	private int size;
	
	public CircularLinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * Add an item at the start of the circle
	 * @param data
	 */
	public void add(Item data) {
		if (head == null) {//tail is null too
			head = new Node<Item>(data);
			tail = head;
			tail.setNext(head);
		}
		else {
			Node<Item> oldHead = head;
			
			head = new Node<Item>(data);
			head.setNext(oldHead);
			tail.setNext(head);
		}
		size++;
	}
	
	public void add(Item data, int pos) {
		if (pos == 0) {
			add(data);
			return;
		}
		Node<Item> newNode = new Node<Item>(data);
		Node<Item> previous = tail;
		Node<Item> current = head;
		for (int i = 1; i < size; i++) {
			previous = previous.getNext();
			current = current.getNext();
			if (i == pos) {
				previous.setNext(newNode);
				newNode.setNext(current);
				size++;
				break;
			}
		}
	}
	
	/**
	 * Push an item at the end of the circle
	 * @param data
	 */
	public void push(Item data) {
		if (head == null) {
			head = new Node<Item>(data);
			head.setNext(head);
		}
		else {
			Node<Item> oldTail = tail;
			
			tail = new Node<Item>(data);
			oldTail.setNext(tail);
			tail.setNext(head);
		}
		size++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(head);
	}

	private class ListIterator<I> implements Iterator<I> {

		private Node<I> current;
		
		public ListIterator(Node<I> item) {
			current = item;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public I next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			I item = current.getItem();
			current = current.getNext();
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	
    /**
     * Unit tests the {@code Bag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	CircularLinkedList<String> linkedList = new CircularLinkedList<String>();
        linkedList.push("one");
        linkedList.push("two");
        linkedList.push("three");
        linkedList.add("four");
        
        System.out.println("size of CLL = " + linkedList.size());
        int i = 0;
        for (String s : linkedList) {
        	i++;
        	System.out.println(s);
        	if (i == 20) {
        		break;
        	}
        }
    }
}
