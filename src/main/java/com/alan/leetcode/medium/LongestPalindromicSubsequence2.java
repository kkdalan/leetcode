package com.alan.leetcode.medium;

public class LongestPalindromicSubsequence2 {

	public static void main(String[] args) {

		LongestPalindromicSubsequence2 sol = new LongestPalindromicSubsequence2();

		System.out.println(sol.longestPalindromeSubseq("babad")); // bab
		System.out.println(sol.longestPalindromeSubseq("cbbd")); // bb
	}

	public int longestPalindromeSubseq(String s) {

		int n = s.length();

		// define dp table
		// dp[i,j]: the longest palindrome substring of s(i+1,j-1)

		int[] dp = new int[n];

		// base case
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		// transform function
		for (int i = n - 2; i >= 0; i--) {

			int pre = 0;

			for (int j = i + 1; j < n; j++) {

				// dp[j]:上一輪(i+1)次的結果
				// 先存在temp，等這一輪計算過後，對下一輪就相當於dp(j-1)
				
				int temp = dp[j]; 

				if (s.charAt(i) == s.charAt(j)) {
					dp[j] = pre + 2; // pre: dp[i + 1][j - 1]
				} else {
					// dp[j]:上一輪(i+1)次的結果
					// dp[j - 1]:dp[j] 的左邊一格
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}

				pre = temp;
			}
		}

		return dp[n - 1];
	}

}
