package com.alan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.alan.leetcode.util.TreeNode;

public class HouseRobberIII {

	public static void main(String[] args) {
		HouseRobberIII sol = new HouseRobberIII();

//		Input: root = [3,2,3,null,3,null,1]
//		Output: 7

		TreeNode root = new TreeNode(3);

		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(3);

		TreeNode node31 = new TreeNode();
		TreeNode node32 = new TreeNode(3);
		TreeNode node33 = new TreeNode();
		TreeNode node34 = new TreeNode(1);

		node21.left = node31;
		node21.right = node32;

		node22.left = node33;
		node22.right = node34;

		root.left = node21;
		root.right = node22;

		System.out.println(sol.rob(root));

	}

	private Map<TreeNode, Integer> memo = new HashMap<>();

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (memo.containsKey(root)) {
			return memo.get(root);
		}

		// 取錢，去下下間房子
		int rob_it = root.val 
				 + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
				 + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

		// 不取錢，去下間房子
		int not_rob = rob(root.left) + rob(root.right);

		int res = Math.max(rob_it, not_rob);
		memo.put(root, res);
		
		return res;
	}

}
