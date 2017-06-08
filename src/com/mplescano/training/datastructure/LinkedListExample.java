package com.mplescano.training.datastructure;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("one");
		linkedList.add("two");
		linkedList.add("three");
		linkedList.add("four");
		
		linkedList.addFirst("First Insert");
		linkedList.addLast("At Last Insert");
		
		for (String item : linkedList) {
			System.out.println("item: " + item);
		}
	}

}
