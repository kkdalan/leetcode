package com.alan.leetcode.easy;

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
    System.out.println(solution.hasCycle(node11));

    // case2
    ListNode node21 = new ListNode(1);
    ListNode node22 = new ListNode(2);
    node21.next = node22;
    node22.next = node21;
    System.out.println(solution.hasCycle(node21));

    // case3
    ListNode node31 = new ListNode(1);
    System.out.println(solution.hasCycle(node31));

    // case4
    ListNode node41 = new ListNode(3);
    ListNode node42 = new ListNode(2);
    ListNode node43 = new ListNode(0);
    ListNode node44 = new ListNode(-4);
    node41.next = node42;
    node42.next = node43;
    node43.next = node44;
    node44.next = node43;
    System.out.println(solution.hasCycle(node41));

    // case5
    ListNode node51 = new ListNode(1);
    ListNode node52 = new ListNode(2);
    node51.next = node52;
    System.out.println(solution.hasCycle(node51));

  }

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head.next;
    ListNode fast = head.next.next;

    if (fast == null) {
      return false;
    }
    while (slow != fast) {
      if (fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
      if (slow == null || fast == null) {
        return false;
      }
    }
    return true;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}


