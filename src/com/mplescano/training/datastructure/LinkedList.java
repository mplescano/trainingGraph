package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Node<Item>> {
    
    private Node<Item> head;
    
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.size = 0;
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
    
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.add("four");

        System.out.println("size of linkedList = " + linkedList.size());
        for (Node<String> s : linkedList) {
            System.out.println(s.getItem());
        }
    }
    
}
