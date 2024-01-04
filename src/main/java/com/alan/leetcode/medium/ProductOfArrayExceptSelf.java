package com.alan.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();

		System.out.println(Arrays.toString(sol.productExceptSelf(new int[] { 1, 2, 3, 4 }))); // [24,12,8,6]
		System.out.println(Arrays.toString(sol.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }))); // [0,0,9,0,0]
	}

	public int[] productExceptSelf(int[] nums) {

		//[1, 2, 3, 4]
		
		// -, 1, 1, 1
		// -, -, 2, 2
		// -, -, -, 3
		// -, -, -, -
		
		// -, -, -, -
		// 2, -, -, -
		// 3, 3, -, - 
		// 4, 4, 4, -
		
		// res[]: 1, *1, *1*2, *1*2*3
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;

		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		
        //nums[]:      1      2     3       4
		// res[]:      1     *1,  *1*2,   *1*2*3
		// res[]: *2*3*4   *3*4    *4       1  (need)
		int product = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= product; 
			product *= nums[i];
		}

		return res;
	}
}
