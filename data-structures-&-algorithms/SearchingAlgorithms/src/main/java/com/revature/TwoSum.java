package com.revature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {3, 7, 3, 2, 1};
		int target = 8;
		
		findTwoSumOptimized(nums, 8);
	}
	
	// O(n)
	public static int[] findTwoSumOptimized(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			// Use a hashmap to store all of the values and their indexes
			map.put(nums[i], i); // value, index
		}

		for (int i = 0; i < nums.length; i++) {

			int numToFind = target - nums[i];

			if (map.get(numToFind) != null && map.get(numToFind) != i) {

				return new int[] { i, map.get(numToFind) };
			}
		}
		return null;
	}
		
	// O(n)
	public static int[] twoSumCalebsSolution(int[] nums, int target) {
		
		HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
		
		// O(n)
        for(int i = 0; i < nums.length; i++){
        	
            Integer requiredNum = (Integer)(target - nums[i]);
            
            if(indexMap.containsKey(requiredNum)){
            	
                int toReturn[] = {indexMap.get(requiredNum), i};
                return toReturn;
            }

            indexMap.put(nums[i], i);
        }
        return null;

	}

	// O(n^2)
	public static int[] findTwoSumBruteForce(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				if (nums[j] + nums[i] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}
