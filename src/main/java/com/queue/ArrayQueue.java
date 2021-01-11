package com.queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 * @author mutian
 *
 */
public class ArrayQueue {
	
	private int head;
	private int tail;
	private int size;
	private Object[] arr;
	
	/**
	 * 初始化队列
	 * @param size
	 */
	public ArrayQueue(int size) {
		this.size = size;
		arr = new Object[size];
		head = tail = -1;
	}
	
	public boolean isFull() {
		return tail == size -1;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public void add(Object e) throws Exception {
		if (isFull()) {
			throw new RuntimeException("queue is full, can not add");
		}
		arr[++tail] = e;
	}
	
	public Object get() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty, can not get");
		}
		return arr[++head];
	}
	
	public void show(){
		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		for (int i = 0; i < size; i++) {
			System.out.printf("arr[%d]=%s \t", i, arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		Scanner scanner = new Scanner(System.in);
		char key = ' ';
		boolean flag = true;
		while (flag) {
			System.out.println("s(show): 显示对列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据");
			System.out.println("g(get): 取出数据");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.show();
				break;
			case 'e':
				scanner.close();
				flag = false;
				break;
			case 'a':
				char value = scanner.next().charAt(0);
				try {
					queue.add(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				};
				break;
			case 'g':
				try {
					Object obj = queue.get();
					System.out.println("get from queue, data = " + obj );
				} catch (Exception e) {
					System.out.println(e.getMessage());
				};
				break;
			default:
				break;
			}
		}
		System.out.println("exit");
	}

}


