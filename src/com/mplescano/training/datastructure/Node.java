package com.mplescano.training.datastructure;

public class Node<Item> {

	private Item item = null;
	
	private Node<Item> next = null;

	public Node(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}

	public Node<Item> getNext() {
		return next;
	}

	public void setNext(Node<Item> next) {
		this.next = next;
	}
	
}
