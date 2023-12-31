package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.alan.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {

		ConstructBinaryTreeFromPreorderAndInorderTraversal sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Case 1

		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		// Output: [3,9,20,null,null,15,7]
		TreeNode ans = sol.buildTree(preorder, inorder);

		System.out.println(ans);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		return buildSubTree(inMap, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildSubTree(Map<Integer, Integer> inMap, int[] preorder, int preStart, int preEnd, int[] inorder,
			int inStart, int inEnd) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

//		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
//		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode node = new TreeNode(preorder[preStart]);
		int inRoot = inMap.get(node.val);
		int numsLeft = inRoot - inStart;

		node.left = buildSubTree(inMap, preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);

		node.right = buildSubTree(inMap, preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);

		return node;
	}

}
