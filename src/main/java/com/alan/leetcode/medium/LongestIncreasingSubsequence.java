package com.alan.leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();

//		Input: nums = [10,9,2,5,3,7,101,18]
//		Output: 4
		System.out.println(sol.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

//		Input: nums = [0,1,0,3,2,3]
//		Output: 4
		System.out.println(sol.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));

//		Input: nums = [7,7,7,7,7,7,7]
//		Output: 1
		System.out.println(sol.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));

	}

	public int lengthOfLIS(int[] nums) {

		int n = nums.length;

		// define dp table
		// dp[i]: LIS with the last number nums[ 0...i ]
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		// compute dp table
		for (int i = 0; i < n; i++) {
			// compute dp[i]
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}

		return res;
	}

}
