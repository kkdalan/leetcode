package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations sol = new Permutations();

		// Case 1
		List<List<Integer>> results = sol.permute(new int[] { 1, 2, 3 });

		System.out.println(results);
	}

	public List<List<Integer>> permute(int[] nums) {

		// collect permutations
		List<List<Integer>> results = new ArrayList<>();

		List<Integer> track = new ArrayList<>();

		backtrack(nums, track, results);

		return results;
	}

	private void backtrack(int[] nums, List<Integer> track, List<List<Integer>> results) {

		// add track into subsets when size is num's size
		if (track.size() == nums.length) {
			results.add(new ArrayList<>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			// skip when found duplicate number
			if (track.contains(nums[i])) {
				continue;
			}

			// add one element, but avoid add duplicate number
			track.add(nums[i]);

			// backtrack
			backtrack(nums, track, results);

			// remove last element
			track.remove(track.size() - 1);
		}
	}

}
