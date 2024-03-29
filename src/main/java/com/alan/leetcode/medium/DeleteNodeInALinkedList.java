package com.alan.leetcode.medium;

import com.alan.leetcode.util.ListNode;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {

		DeleteNodeInALinkedList solution = new DeleteNodeInALinkedList();

		// case1
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		solution.deleteNode(node2);
		System.out.println(node1); // 4 -> (5) -> 1 -> 9

	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
