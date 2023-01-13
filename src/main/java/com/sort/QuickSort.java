package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 
 * 1.选定pivot中心轴。
 * 2.将大于pivot的数字放在pivot的右边
 * 3.将小于pivot的数字放在pivot的左边
 * 4.分别对左右子序列重复前三步操作
 * 
 * @author mutian
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 3, 7, 8, 5 };
		sort(arr, 0, arr.length -1);
		System.out.println("sort:" + Arrays.toString(arr));
	}

	/**
	 * 排序
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 */
	private static void sort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int left = l, right = r;
		int pivot = arr[left];
		
		while (left < right) {
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			if (left < right) {
				arr[left]= arr[right];
			}
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			if (left < right) {
				arr[right]= arr[left];
			}
			if (left >= right) {
				arr[left] = pivot;
			}
		}
		sort(arr, l, left-1);
		sort(arr, right+1, r);
	}

}
