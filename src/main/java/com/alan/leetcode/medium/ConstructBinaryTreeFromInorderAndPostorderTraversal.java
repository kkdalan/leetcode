package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.alan.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static void main(String[] args) {

		ConstructBinaryTreeFromInorderAndPostorderTraversal sol = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Case 1

		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };

		// Output: [3,9,20,null,null,15,7]
		TreeNode ans = sol.buildTree(inorder, postorder);

		System.out.println(ans);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		return buildSubTree(inMap, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode buildSubTree(Map<Integer, Integer> inMap, int[] inorder, int inStart, int inEnd, int[] postorder,
			int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

//		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
//		int[] postorder = new int[] { 9, 15, 7, 20, 3 };

		TreeNode node = new TreeNode(postorder[postEnd]);
		int inRoot = inMap.get(node.val);
		int numsLeft = inEnd - inRoot;

		node.left = buildSubTree(inMap, inorder, inStart, inRoot - 1, postorder, postStart, postEnd - numsLeft - 1);

		node.right = buildSubTree(inMap, inorder, inRoot + 1, inEnd, postorder, postEnd - numsLeft, postEnd - 1);

		return node;
	}

}
