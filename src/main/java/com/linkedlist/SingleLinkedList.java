package com.linkedlist;

import java.util.Stack;

/**
 * 单向链表
 * 
 * @author mutian
 *
 */
public class SingleLinkedList {
	//头结点,不存放具体的数据,初始化后内容不能修改
	private SNode head = new SNode(0, null);
	
	/**
	 * 添加节点
	 * @param node
	 */
	public void add(SNode node) {
		SNode temp = head;
		while (true) {
			if (temp.next == null) {
				temp.next = node;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 顺序添加节点
	 * @param node
	 */
	public void addByOrder(SNode node) {
		SNode temp = head;
		while (true) {
			if (temp.next == null) {
				temp.next = node;
				return;
			}
			// 判断序号
			if (temp.next.no > node.no) {
				// 新增节点小于当前节点
				node.next = temp.next;
				temp.next = node;
				return;
			}
			if (temp.next.no == node.no) {
				System.out.println("repeated no");
				return;
			}
			temp = temp.next;

		}
	}
	
	/**
	 * 修改节点数据
	 * @param node
	 */
	public void update(SNode node) {
		SNode temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("node not exist");;
				return;
			}
			if (temp.next.no == node.no) {
				temp.next.name = node.name;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 移除节点
	 * @param node
	 */
	public void remove(SNode node) {
		SNode temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("node not exist");;
				return;
			}
			if (temp.next.no == node.no) {
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
		if (head.next == null) {
			System.out.println("single linked list is empty");
			return;
		}
		SNode temp = head;
		while (temp.next != null) {
			System.out.println(temp.next);
			temp = temp.next;
		}
	}
	
	/**
	 * 求单链表的有效节点的个数
	 * @return
	 */
	public int getLength () {
		if (head.next == null) {
			return 0;
		}
		SNode temp = head;
		int count = 0;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	/**
	 * 求单链表的倒数第K个节点
	 * @return
	 */
	public SNode getNode (int k) {
		int length = getLength();
		if (length == 0 || k > length) {
			return null;
		}
		SNode temp = head.next;
		for (int i = 0; i < length - k; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * 单链表反转
	 * @param k
	 * @return
	 */
	public void reverse () {
		if (head.next == null) {
			return;
		}
		// 创建新的头结点
		SNode newHead = new SNode(0, null);;
		while (head.next != null) {
			SNode temp = newHead.next;
			
			newHead.next = head.next;
			head.next = head.next.next;
			newHead.next.next = temp;

		}
		head = newHead;
	}
	
	/**
	 * 反转打印
	 */
	public void printReverse () {
		if (head.next == null) {
			System.out.println("single linked list is empty");
			return;
		}
		// 创建新的链表
		Stack<SNode> stack = new Stack<SNode>();
		SNode temp = head;
		while (temp.next != null) {
			stack.add(temp.next);
			temp = temp.next;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		SNode node1 = new SNode(1, "a");
		SNode node2 = new SNode(2, "b");
		SNode node3 = new SNode(3, "c");
		SNode node4 = new SNode(4, "d");
		
		singleLinkedList.show();
		
//		singleLinkedList.add(node2);
//		singleLinkedList.add(node1);
//		singleLinkedList.add(node4);
//		singleLinkedList.add(node3);
		
		singleLinkedList.addByOrder(node2);
		singleLinkedList.addByOrder(node1);
		singleLinkedList.addByOrder(node4);
		singleLinkedList.addByOrder(node3);
		
//		SNode updateNode = new SNode(3, "ccc");
//		singleLinkedList.update(updateNode);
//		singleLinkedList.remove(node2);
		
		singleLinkedList.show();
//		System.out.println(singleLinkedList.getLength());
//		System.out.println(singleLinkedList.getNode(3));
//		singleLinkedList.reverse();
		System.out.println("====================");
//		singleLinkedList.show();
		singleLinkedList.printReverse();
		singleLinkedList.show();
		
	}
}
