/*
	Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	
	For example:
	
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	
	Follow up:
	Could you do it without any loop/recursion in O(1) runtime?
*/

package com.stefler.old;

public class _258_AddDigits {
	
	public int addDigits(int num) {
		if (num == 0) return 0;
		else if (num % 9 == 0) return 9;
		else return num - 9 * (num / 9);
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
