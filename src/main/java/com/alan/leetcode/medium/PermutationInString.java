package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {

		PermutationInString sol = new PermutationInString();

//		System.out.println(sol.checkInclusion("ab", "eidbaooo")); // true
//		System.out.println(sol.checkInclusion("ab", "eidboaoo")); // false
		System.out.println(sol.checkInclusion("abcdxabcde", "abcdeabcdx")); // true

	}

	public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> window = new HashMap<>();

		Map<Character, Integer> need = new HashMap<>();
		for (char c : s1.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;

		while (right < s2.length()) {

			char c = s2.charAt(right);
			right++;

			if (need.getOrDefault(c, 0) > 0) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c) == need.get(c)) {
					valid++;
				}
			}

			while (right - left >= s1.length()) {

				if (valid == need.size()) {
					return true;
				}

				char d = s2.charAt(left);
				left++;

				if (need.getOrDefault(d, 0) > 0) {
					if (window.get(d) == need.get(d)) {
						valid--;
					}
					window.put(d, window.getOrDefault(d, 0) - 1);
				}
			}

		}

		return false;
	}
}
