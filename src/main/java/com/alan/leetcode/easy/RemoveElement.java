package com.alan.leetcode.easy;

public class RemoveElement {

	public static void main(String[] args) {

		RemoveElement sol = new RemoveElement();
		// 2
		System.out.println(sol.removeElement(new int[] { 3, 2, 2, 3 }, 3));
		// 5
		System.out.println(sol.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));

	}

	public int removeElement(int[] nums, int val) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
			}
		}

		return nums.length;
	}
}
