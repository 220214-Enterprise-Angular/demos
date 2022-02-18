package com.revature.main;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int[] myArr = { 10, -2, 5, 12, 5 };
		
		System.out.println("====LINEAR SEARCH====");
		
		System.out.println(linearSearch(myArr, 5));
		System.out.println(linearSearch(myArr, 1000));
		
		System.out.println("====BINARY SEARCH====");
		int[] sortedArray = { -2, 5, 5, 10, 12 };
		
		System.out.println(binarySearch(sortedArray, 5));
		System.out.println(binarySearch(sortedArray, -2));
		System.out.println(binarySearch(sortedArray, 10));
		System.out.println(binarySearch(sortedArray, 12));
		System.out.println(binarySearch(sortedArray, 11));
		
		
		System.out.println("====UNSORTED ARRAY====");
		int[] unsortedArray = { 10, -2, 5, 3 };
		
		// The section of code here is O(n log n), because O(n log n) dominates O(log n)
		
		Arrays.sort(unsortedArray); // -2 3 5 10
		// O(n log n)
		
		System.out.println(binarySearch(unsortedArray, -2)); // O (log n)
	}
	
	// Return the index that the element is found on
	// O(n)
	public static int linearSearch(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}
		
		return -1; // if we didn't find anything
	}
	
	// O(log n)
	public static int binarySearch(int[] arr, int element) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] == element) { // if this is true, then it means you found the element
				return mid;
			} else if (arr[mid] > element) {
				right = mid - 1;
			} else if (arr[mid] < element) {
				left = mid + 1;
			}
		}
		
		return -1;
	}

}
