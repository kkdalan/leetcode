package com.alan.leetcode.easy;

import com.alan.leetcode.util.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {

		RemoveLinkedListElements solution = new RemoveLinkedListElements();

		// case1
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(6);
		ListNode node14 = new ListNode(3);
		ListNode node15 = new ListNode(4);
		ListNode node16 = new ListNode(5);
		ListNode node17 = new ListNode(6);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;

		// delete 6 => 1->2->3->4->5
		System.out.println(solution.removeElements(node11, 6));

		// case2
		ListNode node21 = new ListNode(7);
		ListNode node22 = new ListNode(7);
		ListNode node23 = new ListNode(7);
		ListNode node24 = new ListNode(7);
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;

		// delete 7 =>
		System.out.println(solution.removeElements(node21, 7));

	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode track, root;

		root = new ListNode(-1, head);
		track = root;

		while (track != null && track.next != null) {
			if (track.next.val == val) {
				track.next = track.next.next;
			} else {
				track = track.next;
			}
		}

		return root.next;
	}
}
