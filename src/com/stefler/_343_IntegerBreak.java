/*
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * */

package com.stefler;

public class _343_IntegerBreak {

	public static int integerBreak(int n) {
		return integerBreak(n, true);
    }
	
	public static int integerBreak(int n, boolean isFirst) {
		if (n < 4)
		{
			if (isFirst)
				return n-1 > 0 ? n-1 : 1;
			else
				return n > 0 ? n : 1;
		}
		if (n % 3 == 1)
			return 4 * integerBreak(n - 4, false);
		return 3 * integerBreak(n - 3, false);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i < 11; i++) {
			System.out.println(i + " " + integerBreak(i));
		}
	}

}
