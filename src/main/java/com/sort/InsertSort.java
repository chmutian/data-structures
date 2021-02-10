package com.sort;

import java.util.Arrays;

/**
   *  插入排序
 * 
   * 插入排序是指在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的，现将第n个数插到前面已经排好的序列中，然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。按照此法对所有元素进行插入，直到整个序列排为有序的过程，称为插入排序
 * 
 * @author mutian
 *
 */
public class InsertSort {
	
	public static void main(String[] args) {
		int[] arr = {1,5,6,3,7,8,5};
		sort(arr);
		System.out.println("sort:" + Arrays.toString(arr));
	}
	
	/**
	 * 排序
	 * @param original
	 */
	private static void sort(int[] arr) {
		boolean flag = false;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					flag = true;
				}
				if (flag) {
					flag = false;
				} else {
					break;
				}
			}
		}
	}

}
