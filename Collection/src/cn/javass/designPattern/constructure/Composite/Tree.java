package cn.javass.designPattern.constructure.Composite;

public class Tree {
	TreeNode root=null;
	
	public Tree(String name){
		root=new TreeNode(name);
	}
	
	public static void main(String[] args) {
		Tree tree=new Tree("A");
		TreeNode nodeB=new TreeNode("B");
		TreeNode nodeC=new TreeNode("C");
		TreeNode nodeD=new TreeNode("D");
		TreeNode nodeE=new TreeNode("E");
		
		nodeE.setParent(nodeD);
		nodeD.setParent(nodeC);
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished");
	}
}
