package com.mplescano.training.datastructure;

public class BinaryNodeV2<Item extends Comparable<Item>> {
	
	private Item item = null;
	
	private BinaryNodeV2<Item> parent = null;
	
	private BinaryNodeV2<Item> childRight = null;

	private BinaryNodeV2<Item> childLeft = null;
	
	public BinaryNodeV2(Item item) {
		this(item, null);
	}
	
	public BinaryNodeV2(Item item, BinaryNodeV2<Item> parent) {
		this.item = item;
		this.parent = parent;
	}

	public BinaryNodeV2<Item> getChildLeft() {
		return childLeft;
	}

	public void setChildLeft(BinaryNodeV2<Item> prev) {
		this.childLeft = prev;
	}
	
	public Item getItem() {
		return item;
	}

	public BinaryNodeV2<Item> getChildRight() {
		return childRight;
	}

	public void setChildRight(BinaryNodeV2<Item> next) {
		this.childRight = next;
	}

	public BinaryNodeV2<Item> getParent() {
		return parent;
	}

	public void setParent(BinaryNodeV2<Item> parent) {
		this.parent = parent;
	}
	
	public boolean hasChildrens() {
		return this.childRight != null || this.childLeft != null;
	}
	
	public boolean isLeftChild() {
		if (parent != null) {
			return item.compareTo(parent.getItem()) < 0;
		}
		return false;
	}
}