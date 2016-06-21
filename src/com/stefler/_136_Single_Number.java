/*
	Given an array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

package com.stefler;

public class _136_Single_Number {
	public static int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res = res ^ i;
		}
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
