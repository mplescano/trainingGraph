package com.mplescano.training.datastructure;

public class BinaryNode<Item extends Comparable<Item>> {
	
	private Item item = null;
	
	private BinaryNode<Item> childRight = null;

	private BinaryNode<Item> childLeft = null;

	public BinaryNode(Item item) {
		this.item = item;
	}

	public BinaryNode<Item> getChildLeft() {
		return childLeft;
	}

	public void setChildLeft(BinaryNode<Item> prev) {
		this.childLeft = prev;
	}
	
	public Item getItem() {
		return item;
	}

	public BinaryNode<Item> getChildRight() {
		return childRight;
	}

	public void setChildRight(BinaryNode<Item> next) {
		this.childRight = next;
	}

	public boolean hasChildrens() {
		return this.childRight != null || this.childLeft != null;
	}

	@Override
	public String toString() {
		return "BinaryNode [item=" + item + "]";
	}
}