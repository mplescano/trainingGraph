package com.mplescano.training.searching;

import java.util.Iterator;

import com.mplescano.training.datastructure.SimpleTreeNodeV2;

public class DepthFirstTraversalGraph {

	private int size; // No. of vertices

	private SimpleTreeNodeV2<Long>[] adj;

	// Constructor
	DepthFirstTraversalGraph(int v) {
		size = v;
		adj = new SimpleTreeNodeV2[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new SimpleTreeNodeV2<Long>((long) i, Long.valueOf(i));
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		SimpleTreeNodeV2<Long> childNode = null;
		for (int i = 0; i < size; i++) {
			if (adj[i].getData() != null && adj[i].getData().compareTo(Long.valueOf(w)) == 0) {
				childNode = adj[i];
			}
		}

		adj[v].addChild(childNode); // Add w to v's list.
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS() {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		for (int i = 0; i < size; i++) {
			adj[i].setVisited(false);
		}

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < size; ++i)
			if (adj[i].isVisited() == false)
				DFSUtil(i);
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		for (int i = 0; i < size; i++) {
			adj[i].setVisited(false);
		}

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v);
	}

	// A function used by DFS
	void DFSUtil(int v) {
		// Mark the current node as visited and print it
		adj[v].setVisited(true);
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<SimpleTreeNodeV2<Long>> i = adj[v].getChildren().iterator();
		while (i.hasNext()) {
			long n = i.next().getKey();
			if (!adj[(int) n].isVisited())
				DFSUtil((int) n);
		}
	}

	public static void main(String args[]) {
		DepthFirstTraversalGraph graph = new DepthFirstTraversalGraph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		graph.DFS(2);
		
		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		graph.DFS();
	}
}
