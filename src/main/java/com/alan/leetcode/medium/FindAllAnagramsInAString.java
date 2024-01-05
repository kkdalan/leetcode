package com.alan.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

	public static void main(String[] args) {

		FindAllAnagramsInAString sol = new FindAllAnagramsInAString();

		List<Integer> res1 = sol.findAnagrams("cbaebabacd", "abc");
		System.out.println(res1); // [0,6]
		
		List<Integer> res2 = sol.findAnagrams("abab", "ab");
		System.out.println(res2); // [0,1,2]

	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		
		Map<Character, Integer> window = new HashMap<>();

		Map<Character, Integer> need = new HashMap<>();
		for (char c : p.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;

		while (right < s.length()) {

			char c = s.charAt(right);
			right++;

			if (need.getOrDefault(c, 0) > 0) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).intValue() == need.get(c).intValue()) {
					valid++;
				}
			}

			while (right - left >= p.length()) {

				if (valid == need.size()) {
					res.add(left);
				}

				char d = s.charAt(left);
				left++;

				if (need.getOrDefault(d, 0) > 0) {
					if (window.get(d).intValue() == need.get(d).intValue()) {
						valid--;
					}
					window.put(d, window.getOrDefault(d, 0) - 1);
				}
			}

		}

		return res;
	}
}
