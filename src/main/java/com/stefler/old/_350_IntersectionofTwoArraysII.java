/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Subscribe to see which companies asked this question
 * */

package com.stefler.old;

import java.util.ArrayList;
import java.util.HashMap;

public class _350_IntersectionofTwoArraysII {

	public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> has1 = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums1) {
			has1.put(num, has1.getOrDefault(num, 0) + 1);
		}
        for (int num : nums2) {
			if (has1.get(num) != null && has1.get(num) > 0) {
				res.add(num);
				has1.put(num, has1.get(num) - 1);
			}
		}
        int[] rs = new int[res.size()];
        int j = 0;
        for (int i : res) {
			rs[j] = i;
			j++;
		}
        return rs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2, 1};
		for (int num : intersect(nums1, nums2)) {
			System.out.println(num);
		}
	}

}
