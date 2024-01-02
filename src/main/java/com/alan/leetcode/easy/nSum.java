package com.alan.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nSum {

	public static void main(String[] args) {

		nSum solution = new nSum();

		System.out.println(Arrays.toString(solution.twoSumAsc(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(solution.twoSumAsc(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(solution.twoSumAsc(new int[] { 3, 3 }, 6)));
		System.out.println(Arrays.toString(solution.twoSumAsc(new int[] { 2, 3, 3 }, 6)));

		List<int[]> list = solution.twoSumTarget(new int[] { 1, 3, 1, 2, 2, 3 }, 4);
		System.out.println(list);

	}

	/**
	 * nums should be sorted ascending.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumAsc(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int sum = nums[low] + nums[high];

			if (sum < target) {
				low++;
			} else if (sum > target) {
				high--;
			} else {
				return new int[] { low, high };
			}
		}

		return new int[] { -1, -1 };
	}

	public List<int[]> twoSumTarget(int[] nums, int target) {

		Arrays.sort(nums);
		
		List<int[]> results = new ArrayList<>();

		int low = 0;
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
				results.add(new int[] { left, right });
				while (low < high && nums[low] == left) low++;
				while (low < high && nums[high] == right) high--;
			}
		}

		return results;
	}

}
