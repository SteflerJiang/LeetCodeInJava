/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
 * */

package com.stefler.old;

public class _169_MajorityElement {
	public static int majorityElement(int[] nums) {
        int ma = nums[0];
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
			if (ma != nums[i])
			{
				if (freq <= 1) {
					ma = nums[i];
				}
				else {
					freq--;
				}
			}
			else {
				freq++;
			}
		}
        return ma;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(new int[]{8, 8, 7, 7, 7}));
	}

}
