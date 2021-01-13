package com.linkedlist;

/**
 * 约瑟夫环
 * 
 * n 个人围成一圈，从第一个人开始报数,数到 m 的人出列，再由下一个人重新从 1 开始报数，数到 m 的人再出圈，依次类推，直到所有的人都出圈，请输出依次出圈人的编号。
 * 
 * @author mutian
 *
 */
public class JosephCircle {
	
	public static void main(String[] args) {
		
		CircleLinkedList circleLinkedList = new CircleLinkedList();
		
		int m = 3, n = 10;
		
		for (int i = 1; i <= n; i++) {
			CircleNode node = new CircleNode(i);
			circleLinkedList.add(node);
		}
		
		circleLinkedList.show();
		
//		circleLinkedList.remove(5);
//		circleLinkedList.remove(1);
//		circleLinkedList.show();
		System.out.println("====================");
		
 		CircleNode cur = circleLinkedList.first;
 		// 找到最后一个节点
 		for (int i = 0; i < n-1; i++) {
 			cur = cur.next;
 		}
		while (true) {
			if (cur == cur.next) {
				System.out.println("last no " + cur.no);
				break;
			}
			
			for (int i = 1; i < m; i++) {
				cur = cur.next;
			}
			
			System.out.println(cur.next.no);
			cur.next = cur.next.next;
		}
		
	}
	
}
