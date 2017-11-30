package com.mplescano.training.datastructure;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {

	private DoubleLinkNode<Item> head;
	
	private DoubleLinkNode<Item> tail;
	
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Push an item at the first of the list
	 * @param item
	 */
	public void add(Item item) {
		if (head == null) {//tail is null too
			head = new DoubleLinkNode<Item>(item);
			tail = head;
			//head.setNext(tail);
			//head.setPrev(tail);
		}
		else {
			DoubleLinkNode<Item> oldHead = head;
			head = new DoubleLinkNode<Item>(item, oldHead, null);
			
			//head.setNext(oldHead);
			oldHead.setPrev(head);
			
			//head.setPrev(tail);
			//tail.setNext(head);
		}
		size++;
	}
	
	/**
	 * Push an item at the end of the list
	 * @param data
	 */
	public void push(Item item) {
		if (tail == null) {//head is null too
			tail = new DoubleLinkNode<Item>(item);
			head = tail;
		}
		else {
			DoubleLinkNode<Item> oldTail = tail;
			tail = new DoubleLinkNode<Item>(item, null, oldTail);
			
			oldTail.setNext(tail);
		}
		size++;
	}
	
	
	/**
	 * this method removes element from the start of the linked list
	 * @return
	 */
	public Item slice() {
		return null;
	}
	
	
	/**
	 * this method removes element from the end of the linked list
	 * @return
	 */
	public Item pop() {
		return null;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
