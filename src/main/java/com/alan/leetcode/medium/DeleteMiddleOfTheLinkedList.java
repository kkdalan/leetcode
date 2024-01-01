package com.alan.leetcode.medium;

import com.alan.leetcode.util.ListNode;

public class DeleteMiddleOfTheLinkedList {

	public static void main(String[] args) {

		DeleteMiddleOfTheLinkedList solution = new DeleteMiddleOfTheLinkedList();

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
		System.out.println(solution.deleteMiddle(node11)); // delete 3 => 1->2->4->5

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
		System.out.println(solution.deleteMiddle(node21)); // delete 4 => 1->2->3->5->6

		// case3
		ListNode node31 = new ListNode(1);
		System.out.println(solution.deleteMiddle(node31)); // delete 1 =>

	}

	public ListNode deleteMiddle(ListNode head) {

		if(head == null || head.next == null){
            return null;
        }
		
		ListNode slow, fast;
		slow = fast = head;

		// fast goes earlier
		fast = fast.next.next;
		
		// if fast goes k steps , slow must go k/2
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// delete middle node
		slow.next = slow.next.next;

		return head;

	}
}
