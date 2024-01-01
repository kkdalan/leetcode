package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		Subsets sol = new Subsets();

		// Case 1
		List<List<Integer>> results = sol.subsets(new int[] { 1, 2, 3 });
		
		System.out.println(results);
	}

	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> results = new ArrayList<>();

		List<Integer> track = new ArrayList<>();

		backtrack(nums, 0, track, results);

		return results;
	}

	private void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> results) {
		
		// add track into subsets
		results.add(new ArrayList<>(track));

		for (int i = start; i < nums.length; i++) {

			// add one element
			track.add(nums[i]);

			// backtrack
			backtrack(nums, i + 1, track, results);

			// remove last element
			track.remove(track.size() - 1);
		}
	}

}
