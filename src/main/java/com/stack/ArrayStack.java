package com.stack;

import java.util.Scanner;

/**
 * 数组模拟队列
 * @author mutian
 *
 */
public class ArrayStack {
	
	private int top;
	private int size;
	private Object[] arr;
	
	/**
	 * 初始化队列
	 * @param size
	 */
	public ArrayStack(int size) {
		this.size = size;
		arr = new Object[size];
		top = -1;
	}
	
	public boolean isFull() {
		return top == size -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(Object e) throws Exception {
		if (isFull()) {
			throw new RuntimeException("stack is full, can not add");
		}
		arr[++top] = e;
	}
	
	public Object pop() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty, can not get");
		}
		return arr[top--];
	}
	
	public void show(){
		if (isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("arr[%d]=%s \t", i, arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayStack queue = new ArrayStack(3);
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
					queue.push(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				};
				break;
			case 'g':
				try {
					Object obj = queue.pop();
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


