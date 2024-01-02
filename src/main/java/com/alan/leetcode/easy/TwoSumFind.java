package com.alan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumFind {

	private Map<Integer, Integer> freq = new HashMap<>();

	/**
	 * add a number into the data structure
	 * 
	 * @param number
	 */
	public void add(int number) {
		freq.put(number, freq.getOrDefault(number, 0) + 1);
	}

	/**
	 * find if there exist two numbers with sum equivalent to value
	 * 
	 * @param value
	 * @return
	 */
	public boolean find(int value) {

		for (int num1 : freq.keySet()) {
			int num2 = value - num1;
			if (num1 == num2 && freq.get(num1) > 1) {
				return true;
			} else if (num1 != num2 && freq.containsKey(num2)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		TwoSumFind sol = new TwoSumFind();
		sol.add(3);
		sol.add(3);
		sol.add(2);
		sol.add(5);

		System.out.println(sol.find(6)); // true
		System.out.println(sol.find(7)); // true

	}

}
