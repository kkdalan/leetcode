package com.alan.leetcode.medium;

import java.util.Stack;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

//		System.out.println(sol.longestPalindrome("abka")); // "a"
		System.out.println(sol.longestPalindrome("aacabdkacaa")); // "aca"
		
	}

	public String longestPalindrome(String s) {

		int n = s.length();

		// define dp table
		// dp[i,j]: the longest palindrome substring of s(i+1,j-1)

		String[][] dp = new String[n][n];

		// base case
		for (int i = 0; i < n; i++) {
			dp[i][i] = String.valueOf(s.charAt(i));
		}

		// transform function
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					String sub = s.substring(i + 1, j);
					if (isPalindrome(sub)) {
						dp[i][j] = s.charAt(i) + sub + s.charAt(j);
					} else {
						dp[i][j] = String.valueOf(s.charAt(j));
					}

				} else {
					if (dp[i + 1][j].length() >= dp[i][j - 1].length()) {
						dp[i][j] = dp[i + 1][j];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		return dp[0][n - 1];
	}

	private boolean isPalindrome(String s) {
		Stack<Character> stack = new Stack<Character>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (n % 2 == 0) {
				if (i < n / 2) {
					stack.push(c);
				} else {
					char d = stack.pop();
					if (d != c) {
						return false;
					}
				}
			} else {
				if (i < n / 2) {
					stack.push(c);
				} else if (i > n / 2) {
					char d = stack.pop();
					if (d != c) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
