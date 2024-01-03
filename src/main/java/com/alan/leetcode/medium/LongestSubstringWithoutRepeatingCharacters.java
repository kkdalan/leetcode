package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

		System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // 1

	}

	public int lengthOfLongestSubstring(String s) {

		int maxLen = 0;

		Map<Character, Integer> window = new HashMap<>();

		int left = 0, right = 0;

		while (right < s.length()) {

			char c = s.charAt(right);
			window.put(c, window.getOrDefault(c, 0) + 1);
			right++;

			while (window.get(c) > 1) {
				char d = s.charAt(left);
				left++;
				window.put(d, window.getOrDefault(d, 0) - 1);
			}

			maxLen = Math.max(maxLen, right - left);

		}

		return maxLen;
	}
}
