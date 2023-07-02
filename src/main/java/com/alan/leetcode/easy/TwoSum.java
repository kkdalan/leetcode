package com.alan.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {

    TwoSum solution = new TwoSum();

    System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(solution.twoSum(new int[] {3, 2, 4}, 6)));
    System.out.println(Arrays.toString(solution.twoSum(new int[] {3, 3}, 6)));
    System.out.println(Arrays.toString(solution.twoSum(new int[] {3, 2, 3}, 6)));

  }

  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      if (map.keySet().contains(num2)) {
        return new int[] {map.get(num2), i};
      }
      map.put(num1, i);
    }
    return null;
  }

}
