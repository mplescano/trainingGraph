package com.mplescano.training.searching;

import com.mplescano.training.datastructure.BinaryNode;

public class BinarySearchTreeV1<T extends Comparable<T>> {

	public BinaryNode<T> root;

	public BinarySearchTreeV1(BinaryNode<T> root) {
		this.root = root;
	}

	public BinaryNode<T> find(T target) {
		BinaryNode<T> current = root;
		while (current != null) {
			if (current.getItem().compareTo(target) == 0) {
				return current;
			} else if (current.getItem().compareTo(target) > 0) {
				current = current.getChildLeft();
			} else {
				current = current.getChildRight();
			}
		}
		return null;
	}
	
	public static <T extends Comparable<T>> BinaryNode<T> lookup(BinaryNode<T> current, T target) {
		if (current == null) {
			return null;
		}
		else {
			if (current.getItem().compareTo(target) == 0) {
				return current;
			}
			else {
				if (current.getItem().compareTo(target) > 0) {
					return lookup(current.getChildLeft(), target);
				}
				else /*if (current.getItem().compareTo(target) < 0)*/ {
					return lookup(current.getChildRight(), target);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> BinaryNode<T> insert(BinaryNode<T> current, T data) {
		if (current == null) {
			return new BinaryNode<T>(data);
		}
		else {
			if (current.getItem().compareTo(data) >= 0) {
				current.setChildLeft(insert(current.getChildLeft(), data));
			}
			else {
				current.setChildRight(insert(current.getChildRight(), data));
			}
		}
		return current;
	}
	
	public static <T extends Comparable<Integer>> boolean isBST(BinaryNode<Integer> current) {
		return isBST(current, Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE));
	}

	public static <T extends Comparable<T>> boolean isBST(BinaryNode<T> current, T min, T max) {
		if (current == null) {
			return true;
		}
		if (current.getItem().compareTo(min) <= 0 || current.getItem().compareTo(max) >= 0) {
			return false;
		}
		
		return isBST(current.getChildLeft(), min, current.getItem()) && isBST(current.getChildRight(), current.getItem(), max);
	}
	
    /* Driver program to test above functions */
    public static void main(String args[])
    {

    	//String[] arrNumber = rawNumber.split(" ");
    	
    	/*BinaryNode<Integer> root = new BinaryNode<Integer>(4);
        root.setChildLeft(new BinaryNode<Integer>(2));
        root.setChildRight(new BinaryNode<Integer>(5));
        root.getChildLeft().setChildLeft(new BinaryNode<Integer>(1));
        root.getChildLeft().setChildRight(new BinaryNode<Integer>(3));*/
    	//BinarySearchTreeV1<Integer> tree = new BinarySearchTreeV1<Integer>(root);
 
    	BinaryNode<Integer> root = new BinaryNode<Integer>(3);
        root.setChildLeft(new BinaryNode<Integer>(2));
        root.setChildRight(new BinaryNode<Integer>(5));
        root.getChildLeft().setChildLeft(new BinaryNode<Integer>(1));
        root.getChildLeft().setChildRight(new BinaryNode<Integer>(4));
    	
        if (isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

}
