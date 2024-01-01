package com.alan.leetcode.easy;

import com.alan.leetcode.util.ListNode;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {

		MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();

		// case1
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(3);
		ListNode node14 = new ListNode(4);
		ListNode node15 = new ListNode(5);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		System.out.println(solution.middleNode(node11).val); // 3

		// case2
		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(2);
		ListNode node23 = new ListNode(3);
		ListNode node24 = new ListNode(4);
		ListNode node25 = new ListNode(5);
		ListNode node26 = new ListNode(6);
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		node24.next = node25;
		node25.next = node26;
		System.out.println(solution.middleNode(node21).val); // 4

	}

	public ListNode middleNode(ListNode head) {

		ListNode slow, fast;

		// initialize fast & slow pointer to head
		slow = fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// if fast goes k steps , slow must go k/2
		return slow;

	}
}
