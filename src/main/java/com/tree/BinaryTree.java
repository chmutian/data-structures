package com.tree;

/**
 * 二叉树
 * @author mutian
 */
public class BinaryTree {
	
	private BTNode root;

	public void setRoot(BTNode root) {
		this.root = root;
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("node is empty");
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("node is empty");
		}
	}
	
	/**
	 * 后序遍历
	 */
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("node is empty");
		}
	}
	
	public static void main(String[] args) {
		BTNode node1 = new BTNode(1, "aa");
		BTNode node2 = new BTNode(2, "bb");
		BTNode node3 = new BTNode(3, "cc");
		BTNode node4 = new BTNode(4, "dd");
		BTNode node5 = new BTNode(5, "ee");
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(node1);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
//		binaryTree.preOrder();
//		binaryTree.infixOrder();
		binaryTree.postOrder();
		
		
		
		
	}
	

}
