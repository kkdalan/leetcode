package com.alan.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {

    ThreeSum solution = new ThreeSum();

    printThreeSum(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    printThreeSum(solution.threeSum(new int[] {1, 2, -2, -1}));
    printThreeSum(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    printThreeSum(solution.threeSum(new int[] {0}));
    printThreeSum(solution.threeSum(new int[] {0, 0}));

  }

  private static void printThreeSum(List<List<Integer>> results) {
    for (List<Integer> result : results) {
      System.out.print(Arrays.toString(result.toArray()) + ",");
    }
    System.out.println();
  }

  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    // -4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4
    Arrays.sort(nums);
    List<List<Integer>> results = new LinkedList<>(); // speed for modify

    for (int i = 0; i < n - 2; i++) {
      if (i==0||(i > 0 && nums[i] != nums[i - 1])) {
        int num1 = nums[i];

        int j = i + 1;
        int k = n - 1;

        while (j < k) {
          int num2 = nums[j];
          int num3 = nums[k];

          if (num1 + num2 + num3 < 0) {
            j++;
          } else if (num1 + num2 + num3 > 0) {
            k--;
          } else {
            results.add(Arrays.asList(num1, num2, num3));
            // avoid duplicate
            while (j < k && nums[j] == nums[j + 1]) j++;
            while (j < k && nums[k] == nums[k - 1]) k--;
            j++; k--;
          }
        }
      }
    }
    return results;
  }

}
