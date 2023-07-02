package com.alan.leetcode.easy;

public class AddDigits {

  public static void main(String[] args) {
    AddDigits solution = new AddDigits();
    System.out.println(solution.addDigits(38));
    System.out.println(solution.addDigits(0));

  }

  /**
   * 38 --> 3 + 8 --> 11 , 11 --> 1 + 1 --> 2
   */
  public int addDigits(int num) {
    int res = next(num);
    if (res <= 9) {
      return res;
    }
    return addDigits(res);
  }

  private int next(int num) {
    int res = 0;
    while (num > 0) {
      int d = num % 10;
      res += d;
      num = num / 10;
    }
    return res;
  }

}


