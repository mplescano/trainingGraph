package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author mplescano
 *
 * @param <Item>
 */
public class CrunchifyLinkedList<Item> implements Iterable<Item> {
	
	private Node<Item> head;
	
	private int size;
	
	public CrunchifyLinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * the added element becomes the last in the tail
	 * 
	 * Appends the specified element to the end of this list
	 *  
	 * @param data
	 */
	public void add(Item data) {
		if (head == null) {
			head = new Node<Item>(data);
		}
		else {
			Node<Item> nodeTemp = new Node<Item>(data);
			Node<Item> nodeCurrent = head;
			while (nodeCurrent.getNext() != null) {
				nodeCurrent = nodeCurrent.getNext();
			}
			nodeCurrent.setNext(nodeTemp);
		}
		size++;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
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
        CrunchifyLinkedList<String> linkedList = new CrunchifyLinkedList<String>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.add("four");
        
        System.out.println("size of bag = " + linkedList.size());
        for (String s : linkedList) {
        	System.out.println(s);
        }
    }
}
