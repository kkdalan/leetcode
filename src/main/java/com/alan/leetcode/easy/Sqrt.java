package com.alan.leetcode.easy;

public class Sqrt {

  public static void main(String[] args) {
    Sqrt solution = new Sqrt();

//    System.out.println(solution.mySqrt(4));
//    System.out.println(solution.mySqrt(8));
    System.out.println(solution.mySqrt(9));
//    System.out.println(solution.mySqrt(10));
//    System.out.println(solution.mySqrt(16));

  }


//  public int mySqrt(int x) {
//    double left = 0;
//    double right = x;
//    double err = 0.01;
//    if (x < 2) {
//      return x;
//    }
//    while (left < right) {
//      double mid = (left + right) / 2;
//      if (Math.abs(mid * mid - x) < err) {
//        return (int) mid;
//      } else if (mid * mid > x) {
//        right = mid;
//      } else {
//        left = mid;
//      }
//    }
//    return (int) left;
//  }
  
  public int mySqrt(int x) {
    double err = 0.1;
    double k = 1;
    while (Math.abs(k * k - x) > err) {
      k = (k + x / k) / 2;
    }
    return (int) k;
  }
  
}
