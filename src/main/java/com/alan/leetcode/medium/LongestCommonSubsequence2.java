package com.alan.leetcode.medium;

public class LongestCommonSubsequence2 {

	public static void main(String[] args) {

		LongestCommonSubsequence2 sol = new LongestCommonSubsequence2();

		System.out.println(sol.longestCommonSubsequence("ezupkr", "ubmrapg")); // 2
		System.out.println(sol.longestCommonSubsequence("abcde", "ace")); // 3
		System.out.println(sol.longestCommonSubsequence("abc", "abc")); // 3
		System.out.println(sol.longestCommonSubsequence("abc", "def")); // 0
	}

	public int longestCommonSubsequence(String text1, String text2) {

		int n1 = text1.length();
		int n2 = text2.length();

		// define dp table
		int[] dp = new int[n2 + 1];

		// dp[i,j]: LCS length of text1(0,i-1) & text2(0,j-1)

		// base case
		for (int i = 0; i < n2 + 1; i++) {
			dp[i] = 0;
		}

		// transform function
		for (int i = 1; i <= n1; i++) {
			int pre = 0;

			for (int j = 1; j <= n2; j++) {
				int temp = dp[j];

				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[j] = pre + 1;
				} else {
					dp[j] = Math.max(dp[j - 1], dp[j]);
				}

				pre = temp; //本來就是(i-1)輪的結果，且對下一輪來說就是dp[i-1][j-1]
			}
		}

		return dp[n2];
	}

}
