package com.mplescano.training.datastructure;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeNodeV2<T> {

	private T data;
	
	private boolean visited = false;
	
	private long key;
	
	private List<SimpleTreeNodeV2<T>> childrens = new ArrayList<SimpleTreeNodeV2<T>>();
	
	public SimpleTreeNodeV2() {
	}
	
	public SimpleTreeNodeV2(long key) {
		this.key = key;
	}
	
	public SimpleTreeNodeV2(long key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public SimpleTreeNodeV2(T data) {
		this.data = data;
	}

    public SimpleTreeNodeV2<T> addChild(long key, T child) {
        SimpleTreeNodeV2<T> childNode = new SimpleTreeNodeV2<T>(key, child);
        this.childrens.add(childNode);
        return childNode;
    }
	
    public SimpleTreeNodeV2<T> addChild(T child) {
        SimpleTreeNodeV2<T> childNode = new SimpleTreeNodeV2<T>(child);
        this.childrens.add(childNode);
        return childNode;
    }
    
    public void addChild(SimpleTreeNodeV2<T> child) {
        childrens.add(child);
    }
    
    public List<SimpleTreeNodeV2<T>> getChildren() {
        return childrens;
    }

	public T getData() {
		return data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "SimpleTreeNodeV2 [data=" + data + ", key=" + key + "]";
	}
    
	
}