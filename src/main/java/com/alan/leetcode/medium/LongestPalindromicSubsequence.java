package com.alan.leetcode.medium;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();

		System.out.println(sol.longestPalindromeSubseq("babad")); // bab
		System.out.println(sol.longestPalindromeSubseq("cbbd")); // bb
	}

	public int longestPalindromeSubseq(String s) {

		int n = s.length();

		// define dp table
		// dp[i,j]: the longest palindrome substring of s(i+1,j-1)

		int[][] dp = new int[n][n];

		// base case
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		// transform function
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[0][n - 1];
	}

}
