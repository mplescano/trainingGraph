package com.mplescano.training.searching;

import java.util.ArrayList;
import java.util.List;

import com.mplescano.training.datastructure.BinaryNode;
import com.mplescano.training.datastructure.Queue;

public class BinaryTree {

	/**
	 * Given a binary tree, find its minimum depth. The minimum depth is the number of
	 * nodes along the shortest path from root node down to the nearest leaf node.
	 * 
	 * The idea is to traverse the given Binary Tree. For every node, check if it is a
	 * leaf node. If yes, then return 1. If not leaf node then if left subtree is NULL,
	 * then recur for right subtree. And if right subtree is NULL, then recur for left
	 * subtree. If both left and right subtrees are not NULL, then take the minimum of two
	 * heights.
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> int minimumDepth(BinaryNode<T> node) {

		// Corner case. Should never be hit unless the code is
		// called on root = NULL
		if (node == null) {
			return 0;
		}

		// Base case : Leaf Node. This accounts for height = 1
		if (node.getChildLeft() == null && node.getChildRight() == null) {
			return 1;
		}

		// If left subtree is null, recur for right subtree
		if (node.getChildLeft() == null) {
			return minimumDepth(node.getChildRight()) + 1;
		}

		if (node.getChildRight() == null) {
			return minimumDepth(node.getChildLeft()) + 1;
		}

		return Math.min(minimumDepth(node.getChildLeft()),
				minimumDepth(node.getChildRight())) + 1;
	}

	/**
	 * Equivalent of height
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> int maximumDepth(BinaryNode<T> node) {

		if (node == null) {
			return 0;
		}

		if (node.getChildLeft() == null && node.getChildRight() == null) {
			return 1;
		}

		if (node.getChildLeft() == null) {
			return maximumDepth(node.getChildRight()) + 1;
		}

		if (node.getChildRight() == null) {
			return maximumDepth(node.getChildLeft()) + 1;
		}

		return Math.max(maximumDepth(node.getChildLeft()),
				maximumDepth(node.getChildRight())) + 1;
	}
	
	public static <T extends Comparable<T>> int maximumDepthV2(BinaryNode<T> node, List<BinaryNode<T>> explored) {

		if (node == null) {
			return 0;
		}

		if (node.getChildLeft() == null && node.getChildRight() == null) {
			explored.add(node);
			return 1;
		}

		if (node.getChildLeft() == null) {
			explored.add(node);
			return maximumDepthV2(node.getChildRight(), explored) + 1;
		}

		if (node.getChildRight() == null) {
			return maximumDepthV2(node.getChildLeft(), explored) + 1;
		}

		List<BinaryNode<T>> exploredLeftDepth = new ArrayList<>();
		int leftDepth = maximumDepthV2(node.getChildLeft(), exploredLeftDepth);
		
		List<BinaryNode<T>> exploredRightDepth = new ArrayList<>();
		int rightDepth = maximumDepthV2(node.getChildRight(), exploredRightDepth);

		explored.add(node);
		if (leftDepth > rightDepth) {
			explored.addAll(exploredLeftDepth);
			return leftDepth + 1;
		}
		else {
			explored.addAll(exploredRightDepth);
			return rightDepth + 1;
		}
	}

	/**
	 * The above method minimumDepth may end up with complete traversal of Binary Tree even when the
	 * topmost leaf is close to root. A Better Solution is to do Level Order Traversal.
	 * While doing traversal, returns depth of the first encountered leaf node. Below is
	 * implementation of this solution.
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> int minimumDepthV2(BinaryNode<T> node) {
		if (node == null) {
			return 0;
		}
		
		Queue<BinaryNodeDepthHolder<T>> queue = new Queue<>();
		// Enqueue Root and initialize depth as 1
		queue.enqueue(new BinaryNodeDepthHolder<>(node, 1));
		
		// Do level order traversal
		while (!queue.isEmpty()) {
			
			// Remove the front queue item
			BinaryNodeDepthHolder<T> qi = queue.dequeue();
			
			// Get details of the remove item
			
			// If this is the first leaf node seen so far
			// then returns its depth as answer
			if (qi.node.getChildLeft() == null && qi.node.getChildRight() == null) {
				return qi.depth;
			}
			
			// If left subtree is not null, add it to queue
			if (qi.node.getChildLeft() != null) {
				queue.enqueue(new BinaryNodeDepthHolder<>(qi.node.getChildLeft(), qi.depth + 1));
			}
			
			// If right subtree is not null, add it to queue
			if (qi.node.getChildRight() != null) {
				queue.enqueue(new BinaryNodeDepthHolder<>(qi.node.getChildRight(), qi.depth + 1));
			}
		}
		
		return 0;
	}
	
	private static class BinaryNodeDepthHolder<T extends Comparable<T>> {
		
		BinaryNode<T> node;
		
		int depth;
		
		public BinaryNodeDepthHolder(BinaryNode<T> node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		BinaryNode<Integer> root = new BinaryNode<>(1);
		root.setChildLeft(new BinaryNode<Integer>(2));
		root.setChildRight(new BinaryNode<Integer>(3));
		root.getChildLeft().setChildLeft(new BinaryNode<Integer>(4));
		root.getChildLeft().setChildRight(new BinaryNode<Integer>(5));

		System.out.println(
				"The minimum depth of " + "binary tree is : " + minimumDepth(root));

		System.out.println(
				"The maximum depth of " + "binary tree is : " + maximumDepth(root));
		
		System.out.println(
				"The minimum depth V2 of " + "binary tree is : " + minimumDepthV2(root));
		
		List<BinaryNode<Integer>> explored = new ArrayList<>();
		System.out.println(
				"The maximum depth V2 of " + "binary tree is : " + maximumDepthV2(root, explored) + " and explored:" + explored);
	}
}
