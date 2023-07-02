package com.alan.leetcode.easy;

public class RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {

    RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

    // case1
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(1);
    ListNode node3 = new ListNode(2);
    node1.next = node2;
    node2.next = node3;


    solution.deleteDuplicates(node1); // 1 -> 1 -> 1
    System.out.println(node1); // 1 -> 1

  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode curr = head;
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
    return head;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      this.val = x;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      ListNode node = this;
      while (node != null) {
        sb.append(node.val);
        node = node.next;
      }
      return sb.toString();
    }

  }
}
