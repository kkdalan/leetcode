package com.alan.leetcode.medium;

public class HouseRobberII {

	public static void main(String[] args) {
		HouseRobberII sol = new HouseRobberII();

//		Input: nums = [2,3,2]
//		Output: 3
		System.out.println(sol.rob(new int[] { 2, 3, 2 }));

	}

	public int rob(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}
		
		return Math.max(
				// 拿第一間，不拿最後一間
				rob(nums, 0, n - 2),
				// 不拿第一間，拿最後一間
				rob(nums, 1, n - 1));
	}

	public int rob(int[] nums, int start, int end) {
		int dp_i_1 = 0;
		int dp_i_2 = 0;

		int dp_i = 0;

		for (int i = end; i >= start; i--) {
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
