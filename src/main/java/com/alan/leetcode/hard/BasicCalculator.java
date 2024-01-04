package com.alan.leetcode.hard;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {

		BasicCalculator sol = new BasicCalculator();
		System.out.println(sol.calculate("11")); // 11
		System.out.println(sol.calculate("1-12+3")); // -8
		System.out.println(sol.calculate("2-3*4+5")); // -5
		System.out.println(sol.calculate("1+(2+3)+4")); // 10
		System.out.println(sol.calculate("1+ (1+ (4 + 5+2)-3)+(6+8)")); // 24
	}

	public int calculate(String s) {

		Stack<Integer> stack = new Stack<Integer>();

		int len = s.length();
		int num = 0;
		char sign = '+';

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (isDigit(c)) {
				num = num * 10 + (c - '0');
			}
			if (c == '(') {
				int j = i;
				int cnt = 0;
				for (; i < len; i++) {
					if (s.charAt(i) == '(') cnt++;
					if (s.charAt(i) == ')') cnt--;
					if (cnt == 0) break;
				}
				int left = j + 1;
				int right = i;
				String sub = s.substring(left, right);
				num = calculate(sub);
			}
//			if (c == ')') {
//				break;
//			}
			if ((!isDigit(c) && c != ' ') || i == s.length() - 1) {
				switch (sign) {
				case '+':
					stack.push(num);
					break;
				case '-':
					stack.push(-num);
					break;
				case '*':
					stack.push(stack.pop() * num);
					break;
				case '/':
					stack.push(stack.pop() / num);
					break;
				}
				num = 0;
				sign = c;
			}
		}

		return sum(stack);
	}

	private int sum(Stack<Integer> stack) {
		int ans = 0;
		while (!stack.empty()) {
			ans += stack.pop();
		}
		return ans;
	}

	private boolean isDigit(char c) {
		char[] digits = "01234567889".toCharArray();
		for (char d : digits) {
			if (d == c) {
				return true;
			}
		}
		return false;
	}

}
