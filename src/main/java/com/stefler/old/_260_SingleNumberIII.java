/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * 
 * */

package com.stefler.old;

public class _260_SingleNumberIII {
	
	public static int[] singleNumber(int[] nums) {
		if (nums == null || nums.length < 2) return null;
		int re = 0;
		for (int i : nums) {
			re = re ^ i;
		}
		int n = re & ~(re-1);
		int x1 = 0;
		int x2 = 0;
		for (int i : nums) {
			if ((i & n) > 0) {
				x1 = x1 ^ i;
			} else {
				x2 = x2 ^i;
			}
		}
		return new int[] {x1, x2};
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] re = singleNumber(nums);
		for (int i : re) {
			System.out.println(i);
		}
	}

}
