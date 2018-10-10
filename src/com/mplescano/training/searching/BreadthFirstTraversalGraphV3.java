package com.mplescano.training.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.mplescano.training.datastructure.SimpleTreeNodeV2;

public class BreadthFirstTraversalGraphV3<T> {

	private SimpleTreeNodeV2<T>[] arrNodes;
	
	// Constructor
	BreadthFirstTraversalGraphV3(SimpleTreeNodeV2<T>[] arrNodes) {
		this.arrNodes = arrNodes;
	}

	ResultCompute<T> computeLevelAndParents(int indexPosSource) {
		LinkedList<SimpleTreeNodeV2<T>> queue = new LinkedList<>();
		List<SimpleTreeNodeV2<T>> explored = new ArrayList<>();
		queue.add(arrNodes[indexPosSource]);
		arrNodes[indexPosSource].setVisited(true);
		int level = 0;
		arrNodes[indexPosSource].setLevel(level);
		while (!queue.isEmpty()) {
			SimpleTreeNodeV2<T> currentNode = queue.poll();
			
			Iterator<SimpleTreeNodeV2<T>> iteratorChildrens = currentNode.getChildren().iterator();
			level++;
			while (iteratorChildrens.hasNext()) {
				SimpleTreeNodeV2<T> chilNode = iteratorChildrens.next();
				if (!chilNode.isVisited()) {
					chilNode.setVisited(true);
					chilNode.setLevel(level);
					if (chilNode.getKeyParent() < currentNode.getKey()) {
						chilNode.setKeyParent(currentNode.getKey());
					}
					queue.add(chilNode);
				}
			}
			explored.add(currentNode);
		}
		return new ResultCompute<>(false, explored);
	}
	
	static class ResultCompute<T> {
		private boolean result;
		private List<SimpleTreeNodeV2<T>> explored;
		private ResultCompute(boolean result, List<SimpleTreeNodeV2<T>> explored) {
			this.result = result;
			this.explored = Collections.unmodifiableList(explored);
		}
		public boolean isResult() {
			return result;
		}
		public List<SimpleTreeNodeV2<T>> getExplored() {
			return explored;
		}
	}
	
	// Driver method to
	public static void main(String args[]) {
		
		SimpleTreeNodeV2<String> station1 = new SimpleTreeNodeV2<>(0, "Westminster");
		SimpleTreeNodeV2<String> station2 = new SimpleTreeNodeV2<>(1, "Waterloo");
		station2.addChild(station1);
		SimpleTreeNodeV2<String> station3 = new SimpleTreeNodeV2<>(2, "Trafalgar Square");
		station3.addChild(station1);
		station3.addChild(station2);
		SimpleTreeNodeV2<String> station4 = new SimpleTreeNodeV2<>(3, "Canary Wharf");
		station4.addChild(station2);
		station4.addChild(station3);
		SimpleTreeNodeV2<String> station5 = new SimpleTreeNodeV2<>(4, "London Bridge");
		station5.addChild(station4);
		station5.addChild(station3);
		SimpleTreeNodeV2<String> station6 = new SimpleTreeNodeV2<>(5, "Tottenham Court Road");
		station6.addChild(station5);
		station6.addChild(station4);
		
		BreadthFirstTraversalGraphV3<String> gSearch1 = new BreadthFirstTraversalGraphV3<String>(new SimpleTreeNodeV2[] {station1, station2, station3, station4, station5, station6});
		ResultCompute<String> result1 = gSearch1.computeLevelAndParents(0);
		if (result1.isResult()) {
			System.out.println("Path Found!");
			System.out.println(result1.getExplored());
		}

		int numberVertices = 4;
		SimpleTreeNodeV2<Integer>[] arrStations = new SimpleTreeNodeV2[numberVertices];
		for (int countPos = 0; countPos < numberVertices; countPos++) {
			arrStations[countPos] = new SimpleTreeNodeV2<>((long) countPos, Integer.valueOf(countPos));
		}
		arrStations[0].addChild(arrStations[1]);
		arrStations[0].addChild(arrStations[2]);
		arrStations[1].addChild(arrStations[2]);
		arrStations[2].addChild(arrStations[0]);
		arrStations[2].addChild(arrStations[3]);
		arrStations[3].addChild(arrStations[3]);
		BreadthFirstTraversalGraphV3<Integer> gSearch2 = new BreadthFirstTraversalGraphV3<>(arrStations);
		ResultCompute<Integer> result2 = gSearch2.computeLevelAndParents(0);
		if (result2.isResult()) {
			System.out.println("Path Found!");
			System.out.println(result2.getExplored());
		}
		else {
			System.out.println("Path not Found!");
			System.out.println(result2.getExplored());
		}
	}
}
