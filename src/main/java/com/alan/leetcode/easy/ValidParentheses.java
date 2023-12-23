package com.alan.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {

		ValidParentheses solution = new ValidParentheses();

		System.out.println(solution.isValid("{[]}")); // true
		System.out.println(solution.isValid("()")); // true
		System.out.println(solution.isValid("()[]{}")); // true
		System.out.println(solution.isValid("(]")); // false

	}

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}

		return stack.isEmpty();
	}
}
