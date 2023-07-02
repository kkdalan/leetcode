package com.alan.leetcode.easy;

public class UglyNumber {

  public static void main(String[] args) {
    UglyNumber solution = new UglyNumber();
    System.out.println(solution.isUgly(6)); // true
    System.out.println(solution.isUgly(1)); // true
    System.out.println(solution.isUgly(14)); // false

  }

  /**
   * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
   */
  public boolean isUgly(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
      if (n % 2 == 0) {
        n = n / 2;
      }
      if (n % 3 == 0) {
        n = n / 3;
      }
      if (n % 5 == 0) {
        n = n / 5;
      }
    }
    return n == 1;
  }

}


