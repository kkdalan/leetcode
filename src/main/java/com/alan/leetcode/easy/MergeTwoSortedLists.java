package com.alan.leetcode.easy;

public class MergeTwoSortedLists {

  public static void main(String[] args) {

    MergeTwoSortedLists solution = new MergeTwoSortedLists();

    ListNode node11 = new ListNode(1);
    ListNode node12 = new ListNode(2);
    ListNode node13 = new ListNode(4);
    node11.next = node12;
    node12.next = node13;

    ListNode node21 = new ListNode(1);
    ListNode node22 = new ListNode(3);
    ListNode node23 = new ListNode(4);
    node21.next = node22;
    node22.next = node23;
    System.out.println(solution.mergeTwoLists(node11, node21));

  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode root = new ListNode(0);
    ListNode curr = root;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr.next = list1;
        list1 = list1.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
      }
      curr = curr.next;
    }

    if (list1 != null) {
      curr.next = list1;
    }
    if (list2 != null) {
      curr.next = list2;
    }

    return root.next;
  }


  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
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


