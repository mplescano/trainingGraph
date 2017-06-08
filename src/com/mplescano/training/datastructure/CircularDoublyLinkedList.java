package com.mplescano.training.datastructure;

import java.util.Iterator;

public class CircularDoublyLinkedList<Item> implements Iterable<Item> {

	private DoubleLinkNode<Item> head;
	
	private DoubleLinkNode<Item> tail;
	
	private int size;

	public CircularDoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(Item item) {
		if (head == null) {//tail is null too
			head = new DoubleLinkNode<Item>(item);
			tail = head;
			head.setNext(tail);
			head.setPrev(tail);
		}
		else {
			DoubleLinkNode<Item> oldHead = head;
			head = new DoubleLinkNode<Item>(item);
			
			head.setNext(oldHead);
			oldHead.setPrev(head);
			
			head.setPrev(tail);
			tail.setNext(head);
		}
		size++;
	}
	
	/**
	 * Push an item at the end of the circle
	 * @param data
	 */
	public void push(Item item) {
		if (tail == null) {//head is null too
			tail = new DoubleLinkNode<Item>(item);
			head = tail;
			tail.setNext(head);
			tail.setPrev(head);
		}
		else {
			DoubleLinkNode<Item> oldTail = tail;
			tail = new DoubleLinkNode<Item>(item);
			
			tail.setNext(head);
			head.setPrev(tail);
			
			tail.setPrev(oldTail);
			oldTail.setNext(tail);
		}
		size++;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
