package com.mplescano.training.datastructure;

public class BinaryNodeH<Item extends Comparable<Item>> extends BinaryNode<Item> {

	private int height;
	
	public BinaryNodeH(Item item, int height) {
		super(item);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public BinaryNodeH<Item> getChildLeft() {
		return (BinaryNodeH<Item>) super.getChildLeft();
	}

	public void setChildLeft(BinaryNodeH<Item> prev) {
		this.setChildLeft(prev);
	}
	
	public BinaryNodeH<Item> getChildRight() {
		return (BinaryNodeH<Item>) super.getChildRight();
	}

	public void setChildRight(BinaryNodeH<Item> next) {
		this.setChildRight(next);
	}
}
