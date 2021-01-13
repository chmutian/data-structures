package com.linkedlist;

/**
 * 环形链表节点
 * 
 * @author mutian
 *
 */
public class CircleNode {
	public Integer no;
	public CircleNode next;

	public CircleNode(Integer no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "CircleNode [no=" + no + "]";
	}

}
