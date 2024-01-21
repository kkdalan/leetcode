package com.alan.leetcode.medium;

public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray sol = new MaximumSubarray();

//		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//		Output: 6
		System.out.println(sol.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));

//		Input: nums = [1]
//		Output: 1
		System.out.println(sol.maxSubArray(new int[] { 1 }));
	}

	public int maxSubArray(int[] nums) {
		int n = nums.length;

		if (n == 0) {
			return 0;
		}

		// define dp table
		// dp[i]: the sum of subarray nums[ 0...i ]
		int[] dp = new int[n];
		dp[0] = nums[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}

		return res;
	}
}
