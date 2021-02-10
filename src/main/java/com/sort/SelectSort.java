package com.sort;

import java.util.Arrays;

/**
   *  选择排序
 * 
   * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * 
 * @author mutian
 *
 */
public class SelectSort {
	
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
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					min = j;
				}
			}
			if (i != min) {
				swap(arr, i, min);
			}
		}
	}
	
	/**
	 * @param arr 原数组
	 * @param i 需要交换的下标
	 * @param j 最小值的下标
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
