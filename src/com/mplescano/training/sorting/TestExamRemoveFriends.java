package com.mplescano.training.sorting;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestExamRemoveFriends {

	public static void main(String[] args) {
		
        //Scanner
        Scanner s = new Scanner(System.in);
        int nmbTestCases = Integer.parseInt(s.nextLine());                 // Reading input from STDIN
        int countTestCase = 0;
        TestCase[] testCases = new TestCase[nmbTestCases];
        
        while (countTestCase < nmbTestCases) {
        	processTestCase(s.nextLine(), s.nextLine(), countTestCase, testCases);
        	countTestCase++;
        }
        
        countTestCase = 0;
        while (countTestCase < nmbTestCases) {
        	resolveTestCase(testCases[countTestCase]);
        	countTestCase++;
        }
	}

	private static void resolveTestCase(TestCase testCase) {
		int countRemovableFriends = 0;
		int countTries = 0;
		while (countRemovableFriends < testCase.getNmbRemovableFriends() && countTries < testCase.getNmbFriends()) {
			Iterator<Node<Integer>> iterator = testCase.getLstFriends().iterator();
			Node<Integer> currentPopularityFriend = iterator.next();
			while (iterator.hasNext()) {
				Node<Integer> nextPopularityFriend = iterator.next();
				if (currentPopularityFriend.getItem().intValue() < nextPopularityFriend.getItem().intValue()) {
					testCase.getLstFriends().remove(currentPopularityFriend);
					countRemovableFriends++;
					break;
				}
				currentPopularityFriend = nextPopularityFriend;
			}
			countTries++;
		}
		
		if (testCase.getNmbRemovableFriends() - countRemovableFriends > 0) {
			int nmbRemainingRemovableFriends = testCase.getNmbRemovableFriends() - countRemovableFriends;
			int countRemainingRemovableFriends = 0; 
			do {
				testCase.getLstFriends().removeLast();
				countRemainingRemovableFriends++;
			}
			while(countRemainingRemovableFriends <= nmbRemainingRemovableFriends);
		}
		
		Iterator<Node<Integer>> iterator = testCase.getLstFriends().iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getItem() + " ");
		}
		System.out.println();
	}

	private static void processTestCase(String line, String line2,
			int countTestCase, TestCase[] testCases) {
		String[] arrSizes = line.split("[ ]");
		String[] arrFriends = line2.split("[ ]");

		if (arrFriends.length != Integer.parseInt(arrSizes[0])) {
			throw new IllegalArgumentException("arrFriends:" + arrFriends.length + " arrSizes:" + arrSizes[0]);
		}
		
		testCases[countTestCase] = new TestCase(Integer.parseInt(arrSizes[0]), Integer.parseInt(arrSizes[1]));
		
		for (String friend : arrFriends) {
			testCases[countTestCase].getLstFriends().add(Integer.valueOf(friend));
		}
	}

	static class TestCase {
		
		private int nmbFriends;
		
		private int nmbRemovableFriends;
		
		private LinkedList<Integer> lstFriends;

		public TestCase(int nmbFriends, int nmbRemovableFriends) {
			this.nmbFriends = nmbFriends;
			this.nmbRemovableFriends = nmbRemovableFriends;
			this.lstFriends = new LinkedList<>();
		}

		public int getNmbFriends() {
			return nmbFriends;
		}

		public int getNmbRemovableFriends() {
			return nmbRemovableFriends;
		}

		public LinkedList<Integer> getLstFriends() {
			return lstFriends;
		}
		
	}

	public static class LinkedList<Item> implements Iterable<Node<Item>> {
	    
	    private Node<Item> head;
	    
	    private int size;
	    
	    public LinkedList() {
	        this.head = null;
	    }
	    
	    public boolean isEmpty() {
	        return head == null;
	    }

	    public int size() {
	        return size;
	    }

	    public void add(Item item) {
	        if (head == null) {
	            head = new Node<Item>(item);
	        }
	        else {
	            Node<Item> tempNode = head;
	            while (tempNode.getNext() != null) {
	                tempNode = tempNode.getNext();
	            }
	            tempNode.setNext(new Node<Item>(item));
	        }
	        size++;        
	    }


		public void remove(Node<Item> nodeParam) {
	        Node<Item> prevTempNode = null;
	        Node<Item> tempNode = head;
	        if (tempNode == null) {
	        	return;
	        }
	        do {
	        	if (tempNode.equals(nodeParam)) {
	        		if (prevTempNode == null) {
	        			head = tempNode.getNext();
	        		}
	        		else {
	        			prevTempNode.setNext(tempNode.getNext());
	        		}
	    			tempNode.setNext(null);
	    			size--;
	        		break;
	        	}
	        	prevTempNode = tempNode;
	        	tempNode = tempNode.getNext();
	        }
	        while(tempNode != null);
		}
		
		public void removeLast() {
			Node<Item> prevTempNode = null;
	        Node<Item> tempNode = head;
	        if (tempNode == null) {
	        	return;
	        }
	        do {
	        	if (tempNode.getNext() == null) {
	        		if (prevTempNode == null) {
	        			head = null;
	        		}
	        		else {
	            		prevTempNode.setNext(null);
	        		}
	    			size--;
	        	}
	        	prevTempNode = tempNode;
	        	tempNode = tempNode.getNext();
	        }
	        while(tempNode != null);
		}
	    
	    @Override
	    public Iterator<Node<Item>> iterator() {
	        return new ListIterator(head, this);
	    }

	    private class ListIterator implements Iterator<Node<Item>> {

	    	private Node<Item> previous;
	    	
	    	private Node<Item> current;
	    	
	    	private LinkedList<Item> linkedList;

	        public ListIterator(Node<Item> nodeItem, LinkedList<Item> linkedList) {
	            this.current = nodeItem;
	            this.linkedList = linkedList;
			}

			public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public Node<Item> next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            Node<Item> returnItem = current;
	            previous = current;
	            current = current.getNext();
	            return returnItem;
	        }

	        @Override
	        public void remove() {
	    		Node<Item> newCurrent = current.getNext();
	        	if (previous != null) {
	        		previous.setNext(newCurrent);
	        	}
	        	current.setNext(null);
	    		current = newCurrent;
	    		if (previous == null) {
	    			linkedList.head = current;
	    		}
	    		linkedList.size--;
	        }

	    }
	}
	
	public static class Node<Item> {

		private Item item = null;
		
		private Node<Item> next = null;

		public Node(Item item) {
			this.item = item;
		}
		
		public Item getItem() {
			return item;
		}

		public Node<Item> getNext() {
			return next;
		}

		public void setNext(Node<Item> next) {
			this.next = next;
		}
	}
}
