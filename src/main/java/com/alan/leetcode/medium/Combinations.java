package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		Combinations sol = new Combinations();

		// Case 1
		List<List<Integer>> results = sol.combine(4, 2);

		System.out.println(results);
	}

	public List<List<Integer>> combine(int n, int k) {

		// create array [1...n]
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
		// collect subsets with k elements
		List<List<Integer>> results = new ArrayList<>();

		List<Integer> track = new ArrayList<>();

		backtrack(nums, 0, track, results, k);

		return results;
	}

	private void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> results, int k) {

		// add track into subsets when track size is k
		if (track.size() == k) {
			results.add(new ArrayList<>(track));
			return;
		}

		for (int i = start; i < nums.length; i++) {

			// add one element
			track.add(nums[i]);

			// backtrack
			backtrack(nums, i + 1, track, results, k);

			// remove last element
			track.remove(track.size() - 1);
		}
	}

}
