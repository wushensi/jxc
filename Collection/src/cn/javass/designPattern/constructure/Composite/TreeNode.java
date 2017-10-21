package cn.javass.designPattern.constructure.Composite;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private String name;
	private TreeNode parent;
	private List<TreeNode> children=new ArrayList<TreeNode>();
	
	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public TreeNode(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void add(TreeNode node){
		children.add(node);
	}
	
	public void remove(TreeNode node){
		children.remove(node);
	}
	
	
}
