package com.alan.leetcode.medium;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		LongestCommonSubsequence sol = new LongestCommonSubsequence();

		System.out.println(sol.longestCommonSubsequence("ezupkr", "ubmrapg")); // 2
		System.out.println(sol.longestCommonSubsequence("abcde", "ace")); // 3
		System.out.println(sol.longestCommonSubsequence("abc", "abc")); // 3
		System.out.println(sol.longestCommonSubsequence("abc", "def")); // 0
	}

	public int longestCommonSubsequence(String text1, String text2) {

		int n1 = text1.length();
		int n2 = text2.length();

		// define dp table
		int[][] dp = new int[n1 + 1][n2 + 1];

		// dp[i,j]: LCS length of text1(0,i-1) & text2(0,j-1)

		// base case
		for (int i = 0; i < n1 + 1; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j < n2 + 1; j++) {
			dp[0][j] = 0;
		}

		// transform function
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n1][n2];
	}

}
