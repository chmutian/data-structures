package com.linkedlist;

/**
 * 单向链表
 * 
 * @author mutian
 *
 */
public class CircleLinkedList {
	//头结点,不存放具体的数据,初始化后内容不能修改
	public CircleNode first = new CircleNode(-1);
	
	/**
	 * 添加节点
	 * @param node
	 */
	public void add(CircleNode node) {
		if (first.next == null) {
			first = node;
			node.next = first;
			return;
		}
		CircleNode temp = first;
		while (true) {
			if (temp.next == first) {
				temp.next = node;
				node.next = first;
				return;
			}
			temp = temp.next;
		}
	}
	
	
	/**
	 * 移除节点
	 * @param node
	 */
	public void remove(int no) {
		if (first.next == null) {
			System.out.println("node not exist");;
			return;
		}
		CircleNode temp = first;
		while (true) {
			if (temp.next.no == no) {
				if (temp.next.no == first.no) {
					first = temp.next.next;
				}
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 显示链表
	 */
	public void show() {
		if (first.next == null) {
			System.out.println("circle linked list is empty");
			return;
		}
		CircleNode temp = first;
		while (true) {
			System.out.println(temp);
			if (temp.next == first) {
				break;
			}
			temp = temp.next;
		}
	}
	
}
