package com.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存算法（HashMap + 双链表）
 * @author mutian
 *
 */
public class LRUHashMap {
	
	private int capacity;
	
	private Node head;
	private Node tail;
	
	private Map<String, Node> map;

	public LRUHashMap(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<String, Node>(capacity);
	}
	
	@Override
	public String toString() {
		return "LRUCache [capacity=" + capacity + ", head=" + head + ", tail=" + tail + ", map=" + map + "]";
	}

	public String get(String key) {
		Node node = this.map.get(key);
		if (node == null) {
			return null;
		} else {
			moveToHead(node);
			return node.value;
		}
	}
	
	public void put(String key, String value) {
		Node node = this.map.get(key);
		if (node == null) {
			node = new Node(key, value);
			if (map.size() == capacity) {
				map.remove(tail.key);
				removeTail();
			}
			addToHead(node);
			map.put(key, node);
		} else {
			node.value = value;
			moveToHead(node);
		}
		
	}

	/**
	 * 将当前节点移动到头节点
	 * @param node
	 */
	private void moveToHead(Node node) {
		if (node.prev == null) {
			return;
		}
		node.prev.next = node.next;
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		addToHead(node);
	}

	/**
	 * 添加到头节点
	 * @param node
	 */
	private void addToHead(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	/**
	 * 移除尾节点
	 */
	private void removeTail() {
		if (tail == null || head == tail) {
			return;
		}
		tail = tail.prev;
		tail.next = null;
	}
	
	public static void main(String[] args) {
		
		LRUHashMap map = new LRUHashMap(3);
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		System.out.println(map.get("2"));
		System.out.println(map);
	}

}

class Node {
	String key;
	String value;
	Node prev;
	Node next;
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
}
