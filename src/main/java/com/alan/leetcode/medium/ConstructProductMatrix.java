package com.alan.leetcode.medium;

import java.util.Arrays;

public class ConstructProductMatrix {

	public static void main(String[] args) {

		ConstructProductMatrix sol = new ConstructProductMatrix();

		// [24,12]
		// [8, 6 ]
		int[][] grid = sol.constructProductMatrix(new int[][] { { 1, 2 }, { 3, 4 } });
		sol.display(grid);

		// [2 ]
		// [12345]
		// [24690]
		int[][] grid2 = sol.constructProductMatrix(new int[][] { { 12345 }, { 2 }, { 1 } });
		sol.display(grid2);

//		[ 3255 ,225 ,75    ]
//		[ 225  ,75  ,11178 ]
//		[ 75   ,1860,7800  ]
//		[ 7800 ,3255,1860  ]
//		[ 6285 ,675 ,225   ]
		int[][] grid3 = sol.constructProductMatrix(
				new int[][] { { 4, 3, 9 }, { 3, 9, 10 }, { 9, 7, 8 }, { 8, 4, 7 }, { 6, 1, 3 } });
		sol.display(grid3);

		// [ 345,6345]
		// [7050,4845]
		// [4560,2010]
		// [4845,1755]
		// [2010,8805]
		// [4845,690 ]
		// [2010,9690]
		// [6345,1215]
		// [4845,345 ]
		// [2010,4560]
		int[][] grid4 = sol.constructProductMatrix(new int[][] { { 10, 20 }, { 18, 16 }, { 17, 14 }, { 16, 9 },
				{ 14, 6 }, { 16, 5 }, { 14, 8 }, { 20, 13 }, { 16, 10 }, { 14, 17 } });
		sol.display(grid4);

	}

	private void display(int[][] grid) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int m = 0; m < grid.length; m++) {
			System.out.println(Arrays.toString(grid[m]));
		}
	}

	public int[][] constructProductMatrix(int[][] grid) {

		int mod = 12345;
		
		int m = grid.length;
		int n = grid[0].length;
		int sz = m * n;

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// Compute the product except self
		int[] res = new int[sz];
		res[0] = 1;
		for (int i = 1; i < sz; i++) {
			res[i] = res[i - 1] * (grid[(i - 1) / n][(i - 1) % n] % mod) % mod;
		}
		
		long product = 1;
		for (int j = sz - 1; j >= 0; j--) {
			res[j] *= product % mod;
			product = (product % mod) * (grid[j / n][j % n] % mod) % mod;

			// update grid
			grid[j / n][j % n] = res[j] % mod;
		}
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		return grid;
	}
}
