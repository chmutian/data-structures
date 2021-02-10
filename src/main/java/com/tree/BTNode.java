package com.tree;

/**
 * 二叉树节点
 * @author mutian
 *
 */
public class BTNode {
	public Integer no;
	public String name;
	public BTNode left;
	public BTNode right;

	public BTNode(Integer no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
	
	/**
	 * 前序遍历
	 * 先输出父节点，再遍历左子树和右子树
	 */
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	/**
	 * 中序遍历
	 * 先遍历左子树，再输出父节点，再遍历右子树
	 */
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	/**
	 * 后序遍历
	 * 先遍历左子树，再遍历右子树，再输出父节点
	 */
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
}
