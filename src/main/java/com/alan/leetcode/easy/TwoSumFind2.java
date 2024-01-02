package com.alan.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumFind2 {

	private Set<Integer> sumPool = new HashSet<>();

	private List<Integer> numbers = new ArrayList<>();

	/**
	 * add a number into the data structure
	 * 
	 * @param number
	 */
	public void add(int number) {
		for (int i = 0; i < numbers.size(); i++) {
			sumPool.add(numbers.get(i) + number);
		}
		numbers.add(number);
	}

	/**
	 * find if there exist two numbers with sum equivalent to value
	 * 
	 * @param value
	 * @return
	 */
	public boolean find(int value) {
		return sumPool.contains(value);
	}

	public static void main(String[] args) {
		TwoSumFind2 sol = new TwoSumFind2();
		sol.add(3);
		sol.add(3);
		sol.add(2);
		sol.add(5);

		System.out.println(sol.find(6)); // true
		System.out.println(sol.find(7)); // true

	}

}
