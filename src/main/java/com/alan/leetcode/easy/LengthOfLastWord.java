package com.alan.leetcode.easy;

public class LengthOfLastWord {

  public static void main(String[] args) {
    LengthOfLastWord solution = new LengthOfLastWord();
    System.out.println(solution.lengthOfLastWord("Hello World"));
    System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
  }

  public int lengthOfLastWord(String s) {
    int n = s.length();
    int cnt = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (cnt > 0) {
        if (s.charAt(i) == ' ') {
          return cnt;
        } else {
          cnt++;
        }
      } else {
        if (s.charAt(i) != ' ') {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
