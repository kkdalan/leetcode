package com.alan.leetcode.medium;

public class EditDistance {

	public static void main(String[] args) {

		EditDistance sol = new EditDistance();

		System.out.println(sol.minDistance("horse", "ros")); // 3
		System.out.println(sol.minDistance("intention", "execution")); // 5

	}

	public int minDistance(String word1, String word2) {

		int n1 = word1.length();
		int n2 = word2.length();

		// define dp table
		int[][] dp = new int[n1 + 1][n2 + 1];

		// dp[i][j] = word1(0,i-1) to word1(0,j-1) min distance

		// base case
		for (int i = 1; i < n1 + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j < n2 + 1; j++) {
			dp[0][j] = j;
		}

		// transform function
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; // Do nothing
				} else {
					dp[i][j] = min( // 3 cases
							dp[i - 1][j - 1] + 1, // Replace a character
							dp[i][j - 1] + 1, // Delete a character
							dp[i - 1][j] + 1); // Insert a character
				}
			}
		}

		return dp[n1][n2];
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
