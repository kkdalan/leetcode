package com.alan.leetcode.hard;

public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int[] maxi = new int[] {Integer.MIN_VALUE} ; // Using an array to store the max value
		findMaxPathSum(root, maxi);
		return maxi[0];
	}

	private int findMaxPathSum(TreeNode node, int[] maxi) {
		if (node == null)
			return 0;
		int left = Math.max(0, findMaxPathSum(node.left, maxi));
		int right = Math.max(0, findMaxPathSum(node.right, maxi));
		maxi[0] = Math.max(maxi[0], left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void main(String[] args) {

		BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Case 1
//		TreeNode node11 = new TreeNode(2);
//		TreeNode node12 = new TreeNode(3);
//		TreeNode root1 = new TreeNode(1, node11, node12);
//		System.out.println(sol.maxPathSum(root1)); // 6

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Case 2

		TreeNode node21 = new TreeNode(15);
		TreeNode node22 = new TreeNode(7);

		TreeNode node23 = new TreeNode(9);
		TreeNode node24 = new TreeNode(20, node21, node22);

		TreeNode root2 = new TreeNode(-10, node23, node24);
		System.out.println(sol.maxPathSum(root2)); // 42
	}

}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
