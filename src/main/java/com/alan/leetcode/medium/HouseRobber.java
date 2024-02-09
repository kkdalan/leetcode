package com.alan.leetcode.medium;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber sol = new HouseRobber();

//		Input: nums = [1,2,3,1]
//		Output: 4
		System.out.println(sol.rob(new int[] { 1, 2, 3, 1 }));

	}

	public int rob(int[] nums) {
		
		int n = nums.length;
		int[] dp = new int[n + 2];
		dp[n] = 0;
		dp[n + 1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.max(
					// 不取錢，去下間房子
					dp[i + 1],
					// 取錢，去下下間房子
					nums[i] + dp[i + 2]);
		}

		return dp[0];
	}

}
