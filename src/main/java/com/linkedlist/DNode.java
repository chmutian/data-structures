package com.linkedlist;

/**
 * 单链表节点
 * @author mutian
 *
 */
public class DNode {
	public Integer no;
	public String name;
	public DNode next;

	public DNode(Integer no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
}
