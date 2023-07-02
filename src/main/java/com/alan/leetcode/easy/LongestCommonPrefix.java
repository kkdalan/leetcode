package com.alan.leetcode.easy;

public class LongestCommonPrefix {

  public static void main(String[] args) {

    LongestCommonPrefix solution = new LongestCommonPrefix();
    System.out.println(solution.longestCommonPrefix(new String[] {"ab", "a"}));
    System.out.println(solution.longestCommonPrefix(new String[] {""}));
    System.out.println(solution.longestCommonPrefix(new String[] {"cir", "car"}));
    System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));

  }

  public String longestCommonPrefix(String[] strs) {

    StringBuilder prefix = new StringBuilder();

    int i = 0;
    while (i < strs[0].length()) {
      char c = strs[0].charAt(i);

      for (int k = 0; k < strs.length; k++) {
        String str = strs[k];
        if (i > str.length() - 1 || c != str.charAt(i)) {
          return prefix.toString();
        }
      }

      prefix.append(c);
      i++;
    }

    return prefix.toString();
  }

}
