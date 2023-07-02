package com.alan.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

  public static void main(String[] args) {

    PlusOne solution = new PlusOne();

    System.out.println(Arrays.toString(solution.plusOne(new int[] {1, 2, 3, 4})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {4, 3, 2, 1})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {9})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3})));

  }

  public int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    digits = new int[n + 1];
    digits[0] = 1;
    return digits;
  }

}
