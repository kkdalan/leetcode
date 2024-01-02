package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {

		FourSum solution = new FourSum();

//		Input: nums = [1,0,-1,0,-2,2], target = 0
//		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		List<List<Integer>> result1 = solution.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
		System.out.println(result1);

//		Input: nums = [2,2,2,2,2], target = 8
//		Output: [[2,2,2,2]]
		List<List<Integer>> result2 = solution.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8);
		System.out.println(result2);

//		Input: nums = [1000000000,1000000000,1000000000,1000000000], target = -294967296
//		Output: []
		List<List<Integer>> result3 = solution.fourSum(new int[] { 1000000000,1000000000,1000000000,1000000000 }, -294967296);
		System.out.println(result3);
		
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return nSum(nums, 4, 0, target);
    }

	public List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
		
//		Arrays.sort(nums);

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
				long sub = target - other;
				
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

	public List<List<Integer>> twoSum(int[] nums, int start, long target) {

//		Arrays.sort(nums);

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
