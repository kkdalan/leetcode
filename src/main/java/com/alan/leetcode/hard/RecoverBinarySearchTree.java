package com.alan.leetcode.hard;

import com.alan.leetcode.util.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {

		RecoverBinarySearchTree sol = new RecoverBinarySearchTree();

//		Input: root = [1,3,null,null,2]
//		Output: [3,1,null,null,2]

		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode(3, node1, node2);
		TreeNode node4 = new TreeNode();
		TreeNode root = new TreeNode(1, node3, node4);
		sol.recoverTree(root);

		System.out.println(root);
	}

	public void recoverTree(TreeNode root) {

	}
}
