package com.mplescano.training.datastructure;

import java.util.List;

public class TreeNode<T> {

	private T data;
	
	private TreeNode<T> parent;
	
	private List<TreeNode<T>> childrens;
	
	
	public TreeNode(T data) {
		this(data, null);
	}
	
	public TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}
	
    public void setParent(TreeNode<T> parent) {
        //parent.addChild(this);//necessary?
        this.parent = parent;
    }
	
    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.childrens.add(childNode);
        return childNode;
    }
    
    public void addChild(TreeNode<T> child) {
        child.parent = this;
        childrens.add(child);
    }
    
    public List<TreeNode<T>> getChildren() {
        return childrens;
    }
}
