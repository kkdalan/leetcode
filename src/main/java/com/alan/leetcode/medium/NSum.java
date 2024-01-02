package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {

	public static void main(String[] args) {

		NSum solution = new NSum();

//		Input: nums = [-1,0,1,2,-1,-4]
//		Output: [[-1,-1,2],[-1,0,1]]
		List<List<Integer>> result1 = solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println(result1);

//		Input: nums = [0,1,1]
//		Output: []
		List<List<Integer>> result2 = solution.threeSum(new int[] { 0, 1, 1 });
		System.out.println(result2);

//		Input: nums = [0,0,0]
//		Output: [[0,0,0]]
		List<List<Integer>> result3 = solution.threeSum(new int[] { 0, 0, 0 });
		System.out.println(result3);

	}

	public List<List<Integer>> threeSum(int[] nums) {
		return nSum(nums, 3, 0, 0);
	}
	
	public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
		
		Arrays.sort(nums);

		List<List<Integer>> results = new ArrayList<>();
		
		int len = nums.length;
		
		if(n < 2 || len < n) {
			return results;
		}
		
		if(n == 2) {
			return twoSum(nums, start, target);
			
		} else {
			
			for (int i = start; i < len; i++) {
				
				int other = nums[i];
				int sub = target - other;
				
				// i + 1 avoid duplicate number
				List<List<Integer>> list = nSum(nums, n - 1, i + 1, sub);
				
				// add other into n-1 Sum results
				for(List<Integer> l : list) {
					l.add(other);
					results.add(l);
				}
				
				while (i < len - 1 && nums[i] == nums[i + 1]) i++;
			}
			
		}
		return results;
	}

	public List<List<Integer>> twoSum(int[] nums, int start, int target) {

		Arrays.sort(nums);

		List<List<Integer>> results = new ArrayList<>();

		int len = nums.length;
		
		int low = start;
		int high = len - 1;

		while (low < high) {

			int left = nums[low];
			int right = nums[high];
			int sum = left + right;

			if (sum < target) {
				low++;
				while (low < high && nums[low] == left) low++;

			} else if (sum > target) {
				high--;
				while (low < high && nums[high] == right) high--;

			} else {
				results.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { left, right })));
				while (low < high && nums[low] == left) low++;
				while (low < high && nums[high] == right) high--;
			}
		}

		return results;
	}

}
