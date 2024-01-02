package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		ThreeSum solution = new ThreeSum();

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
		return threeSum(nums, 0);
	}
	
	public List<List<Integer>> threeSum(int[] nums, int target) {
		
		Arrays.sort(nums);

		List<List<Integer>> results = new ArrayList<>();
		
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			
			int num3 = nums[i];
			int twoSum = target - num3;
			
			// i + 1 avoid duplicate number
			List<List<Integer>> list = twoSum(nums, i + 1, twoSum);
			
			// add num3 into twoSum results
			for(List<Integer> l : list) {
				l.add(num3);
				results.add(l);
			}
			
			while (i < n - 1 && nums[i] == nums[i + 1]) i++;
		}
		
		return results;
	}

	public List<List<Integer>> twoSum(int[] nums, int start, int target) {

		Arrays.sort(nums);

		List<List<Integer>> results = new ArrayList<>();

		int low = start;
		int high = nums.length - 1;

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
