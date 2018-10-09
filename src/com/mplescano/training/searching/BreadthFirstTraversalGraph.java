package com.mplescano.training.searching;

import java.util.Iterator;
import java.util.LinkedList;

import com.mplescano.training.datastructure.SimpleTreeNodeV2;

public class BreadthFirstTraversalGraph {

	private int size; // No. of vertices

	private SimpleTreeNodeV2<Long>[] adj;

	// Constructor
	BreadthFirstTraversalGraph(int numberVertices) {
		size = numberVertices;
		adj = new SimpleTreeNodeV2[numberVertices];
		for (int countPos = 0; countPos < numberVertices; countPos++) {
			adj[countPos] = new SimpleTreeNodeV2<>((long) countPos, Long.valueOf(countPos));
		}
	}

	// Function to add an edge into the graph
	void addEdge(int parentPos, int childValue) {
		SimpleTreeNodeV2<Long> childNode = null;
		for (int countPos = 0; countPos < size; countPos++) {
			if (adj[countPos].getData() != null && adj[countPos].getData().compareTo(Long.valueOf(childValue)) == 0) {
				childNode = adj[countPos];
			}
		}

		adj[parentPos].addChild(childNode); // Add w to v's list.
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		for (int i = 0; i < size; i++) {
			adj[i].setVisited(false);
		}

		// Create a queue for BFS
		LinkedList<SimpleTreeNodeV2<Long>> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		adj[s].setVisited(true);
		queue.add(adj[s]);

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			SimpleTreeNodeV2<Long> node = queue.poll();
			System.out.print(node.getKey() + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<SimpleTreeNodeV2<Long>> iteratorChildrens = adj[(int) node.getKey()].getChildren().iterator();
			while (iteratorChildrens.hasNext()) {
				long childKey = iteratorChildrens.next().getKey();
				if (!adj[(int) childKey].isVisited()) {
					adj[(int) childKey].setVisited(true);
					queue.add(adj[(int) childKey]);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {
		BreadthFirstTraversalGraph g = new BreadthFirstTraversalGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}
}
