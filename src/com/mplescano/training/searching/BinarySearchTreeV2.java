package com.mplescano.training.searching;

import com.mplescano.training.datastructure.BinaryNodeV2;

public class BinarySearchTreeV2<T extends Comparable<T>> {

	public BinaryNodeV2<T> root;

	public BinarySearchTreeV2() {
		this.root = null;
	}

	public BinaryNodeV2<T> find(T id) {
		BinaryNodeV2<T> current = root;
		while (current != null) {
			if (current.getItem().compareTo(id) == 0) {
				return current;
			} else if (current.getItem().compareTo(id) > 0) {
				current = current.getChildLeft();
			} else {
				current = current.getChildRight();
			}
		}
		return null;
	}
	
	

	/*public boolean delete(T id) {
		BinaryNode<T> nodeId = find(id);
		if (nodeId == null) {
			return false;
		}
		
		BinaryNode<T> parent = nodeId.getParent();
		if (!nodeId.hasChildrens()) {
			if (nodeId == root) {
				root = null;
			}
			
			if (nodeId.isLeftChild()) {
				parent.setChildLeft(null);
			}
			else {
				parent.setChildRight(null);
			}
		}
		else if (nodeId.getChildRight() == null) {
			if (nodeId == root) {
				root = nodeId.getChildLeft();
			}
			else if (nodeId.isLeftChild()) {
				parent.setChildLeft(nodeId.getChildLeft());
			}
			else {
				parent.setChildRight(nodeId.getChildLeft());
			}
		}
		else if (nodeId.getChildLeft() == null) {
			
		}
	}*/

}
