package com.mplescano.training.datastructure;

public class DoubleLinkNode<Item> {
	
	private Item item = null;
	
	private DoubleLinkNode<Item> next = null;

	private DoubleLinkNode<Item> prev = null;
	
	public DoubleLinkNode(Item item) {
		this.item = item;
	}

	public DoubleLinkNode<Item> getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkNode<Item> prev) {
		this.prev = prev;
	}
	
	public Item getItem() {
		return item;
	}

	public DoubleLinkNode<Item> getNext() {
		return next;
	}

	public void setNext(DoubleLinkNode<Item> next) {
		this.next = next;
	}
}