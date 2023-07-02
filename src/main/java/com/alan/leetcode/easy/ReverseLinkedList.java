package com.alan.leetcode.easy;

import java.util.Stack;

public class ReverseLinkedList {

  public static void main(String[] args) {
    
    Stack<Character> chars = new Stack<Character>();
    chars.clear();
    
    ReverseLinkedList solution = new ReverseLinkedList();
    // case1
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    System.out.println(node1 + " --> " + solution.reverseList(node1));

  }
 
  //      [head]
  //       prev  curr  
  //             temp  curr
  //         1 -> 2 -> 3 -> 4 -> null
  // null <- 1    2 -> 3 -> 4 -> null
  // null <- 1 <- 2    3 -> 4 -> null
  // null <- 1 <- 2 <- 3    4 -> null
  // null <- 1 <- 2 <- 3 <- 4    
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    
    ListNode prev = head;
    ListNode curr = head.next;
    prev.next = null;
    
    while (curr != null) {
      ListNode temp = curr;
      curr = curr.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }


  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
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


