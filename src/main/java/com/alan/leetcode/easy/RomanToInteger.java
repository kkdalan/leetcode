package com.alan.leetcode.easy;

/**
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Roman to
 * Integer. Memory Usage: 42 MB, less than 89.89% of Java online submissions for
 * Roman to Integer.
 * 
 * @author alan
 */
public class RomanToInteger {

	public static void main(String[] args) {

		RomanToInteger solution = new RomanToInteger();

		System.out.println(solution.romanToInt("III")); // 3
		System.out.println(solution.romanToInt("LVIII")); // 58
		System.out.println(solution.romanToInt("MCMXCIV")); // 1994

	}

	public int romanToInt(String s) {

		int[] nums = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I':
				nums[i] = 1;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'M':
				nums[i] = 1000;
				break;
			}
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] * (i < nums.length - 1 && nums[i] < nums[i + 1] ? -1 : 1);
		}
		return sum;

	}

}
