package com.alan.leetcode.easy;

import com.alan.leetcode.util.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {

		LinkedListCycle solution = new LinkedListCycle();

		// case1
		ListNode node11 = new ListNode(3);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(0);
		ListNode node14 = new ListNode(-4);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node12;
		System.out.println(solution.hasCycle(node11)); // true

		// case2
		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(2);
		node21.next = node22;
		node22.next = node21;
		System.out.println(solution.hasCycle(node21)); // true

		// case3
		ListNode node31 = new ListNode(1);
		System.out.println(solution.hasCycle(node31)); // false

	}

	public boolean hasCycle(ListNode head) {

		ListNode slow, fast;

		// initialize fast & slow pointer to head
		slow = fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			// if slow and fast meet, there is a cysle
			if (fast == slow) {
				return true;
			}
		}

		return false;

	}
}
