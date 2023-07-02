package com.alan.leetcode.easy;

public class HappyNumber {

  public static void main(String[] args) {
    HappyNumber solution = new HappyNumber();
    System.out.println(solution.isHappy(19));
    System.out.println(solution.isHappy(1));
    System.out.println(solution.isHappy(2));

  }

  public boolean isHappy(int n) {
    int slow = n;
    int fast = next(n);
    while (fast != 1 && fast != slow) {
      slow = next(slow);
      fast = next(next(fast));
    }
    return fast == 1;
  }

  private int next(int n) {
    int res = 0;
    while (n > 0) {
      int d = n % 10;
      res += d * d;
      n = n / 10;
    }
    return res;
  }

}


