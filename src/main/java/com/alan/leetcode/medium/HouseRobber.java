package com.alan.leetcode.medium;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber sol = new HouseRobber();

//		Input: nums = [1,2,3,1]
//		Output: 4
		System.out.println(sol.rob(new int[] { 1, 2, 3, 1 }));

	}

	public int rob(int[] nums) {
		return dp(nums, 0);
	}

	// dp(nums, start): max rob value from start
	private int dp(int[] nums, int start) {
		if (start >= nums.length) {
			return 0;
		}

		int res = Math.max(
				// 不取錢，去下間房子
				dp(nums, start + 1),
				// 取錢，去下下間房子
				nums[start] + dp(nums, start + 2));

		return res;
	}

}
