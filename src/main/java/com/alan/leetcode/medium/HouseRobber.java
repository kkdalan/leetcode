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

		int dp_i_1 = 0;
		int dp_i_2 = 0;

		int dp_i = 0;

		for (int i = n - 1; i >= 0; i--) {
			dp_i = Math.max(
					// 不取錢，去下間房子
					dp_i_1,
					// 取錢，去下下間房子
					nums[i] + dp_i_2);
			
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}

		return dp_i;
	}

}
