package com.mplescano.training.datastructure;

import java.util.List;

public class SimpleTreeNode<T> {

	private T data;
	
	private List<SimpleTreeNode<T>> childrens;
	
	
	public SimpleTreeNode(T data) {
		this.data = data;
	}
	
    public SimpleTreeNode<T> addChild(T child) {
        SimpleTreeNode<T> childNode = new SimpleTreeNode<T>(child);
        this.childrens.add(childNode);
        return childNode;
    }
    
    public void addChild(SimpleTreeNode<T> child) {
        childrens.add(child);
    }
    
    public List<SimpleTreeNode<T>> getChildren() {
        return childrens;
    }

	public T getData() {
		return data;
	}
    
}