package com.revature;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. 
 * 
 * If target exists,
 * then return its index. Otherwise, return -1.
 */
public class BinarySearch {
	
	// [ -1, 0, 3, 5, 9, 12]
	// Input: nums = [ -1, 0, 3, 5, 9, 12]     target = 9
	// Output: 4 (index of 9)
	
	// Input: nums = [-1,0,3,5,9,12] target = 2;
	// output: -1 (the target number doensn't exist) 
	
	
	// O(n) - linear time complexity
	public static int bruteForceSearch(int[] nums, int target) {
		
		for (int i=0; i<nums.length; i++) {
			
			System.out.println(".");
			
			// if the element at the index of is equal to the target, return i!
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	// Goal: how can we search in O(log n)  time 
	public static int binarySearch(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length -1; // because a list with 5 integers is zero indexed (last is 4)
		int mid;
		
		while (left <= right) {
			
			System.out.println("."); // I'm using this to measure the steps taken
			
			// establish the index in the middle of the array
			mid = left + (right - left) / 2; // this prevents any overflow
			
			// check if the element at the mid point is == to the target
			if (nums[mid] == target) {
				return mid;
			}
			
			// is the target number less than the element at the mid point?
			if (target < nums[mid]) {
				// if so, discard the entire right side and make the right-most pointer 
				// equal to the mid - 1.
				right = mid - 1;
				
			} else {
				left = mid + 1;
			}
		}
		
		// [ -1, 0, 2, 3, 4, 5, 7, 9, 12]  
		return -1;
	}
	public static void main(String[] args) {
		
		int[] nums = {-1, 0, 3, 5, 9, 12};
		
		System.out.println(binarySearch(nums, 9));

			
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
