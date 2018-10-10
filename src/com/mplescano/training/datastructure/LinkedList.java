package com.mplescano.training.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    
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

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(head);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> item) {
            current = item;
        }

        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.add("four");

        System.out.println("size of linkedList = " + linkedList.size());
        for (String s : linkedList) {
            System.out.println(s);
        }
    }
    
}
