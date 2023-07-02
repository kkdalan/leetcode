package com.alan.leetcode.easy;

public class ShuffleString {

  public static void main(String[] args) {
    ShuffleString solution = new ShuffleString();
    System.out.println(solution.restoreString("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}));
    System.out.println(solution.restoreString("abc", new int[] {0, 1, 2}));
  }

  public String restoreString(String s, int[] indices) {
    char[] results = new char[s.length()];
    for (int i = 0; i < indices.length; i++) {
      results[indices[i]] = s.charAt(i);
    }
    return String.valueOf(results);
  }
}
