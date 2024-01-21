package com.alan.leetcode.medium;

public class MaximumSubarray2 {

	public static void main(String[] args) {
		MaximumSubarray2 sol = new MaximumSubarray2();

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
		int[] dp = new int[2];
		dp[0] = nums[0];
		dp[1] = 0;

		int res = dp[0];

		for (int i = 1; i < n; i++) {
			dp[1] = Math.max(nums[i], dp[0] + nums[i]);
			dp[0] = dp[1];
			res = Math.max(res, dp[1]);
		}

		return res;
	}
}
