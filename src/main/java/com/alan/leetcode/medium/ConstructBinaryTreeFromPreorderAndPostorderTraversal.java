package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.alan.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

	
	//FIXME
	public static void main(String[] args) {

		ConstructBinaryTreeFromPreorderAndPostorderTraversal sol = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Case 1

		int[] preorder = new int[] { 1,2,4,5,3,6,7 };
		int[] postorder = new int[] { 4,5,2,6,7,3,1 };

	    // Output: [1,2,3,4,5,6,7]
		TreeNode ans = sol.constructFromPrePost(preorder, postorder);

		System.out.println(ans);
	}

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

		Map<Integer, Integer> postMap = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			postMap.put(postorder[i], i);
		}

		return buildSubTree(postMap, preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode buildSubTree(Map<Integer, Integer> postMap, int[] preorder, int preStart, int preEnd, int[] postorder,
			int postStart, int postEnd) {

		if (preStart > preEnd || postStart > postEnd) {
			return null;
		}
		
//		int[] preorder = new int[] { 1,2,4,5,3,6,7 };
//		int[] postorder = new int[] { 4,5,2,6,7,3,1 };

//		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
//		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		
		TreeNode node = new TreeNode(preorder[preStart]); 
		int postRoot = postMap.get(node.val); 
		int numsLeft = postRoot - postStart; 

		node.left = buildSubTree(postMap, preorder, preStart + 1, preStart + numsLeft, postorder, postStart, postEnd - numsLeft - 1);

		node.right = buildSubTree(postMap, preorder, preStart + numsLeft + 1, preEnd, postorder, postEnd - numsLeft, postEnd - 1);

		return node;
	}

}
