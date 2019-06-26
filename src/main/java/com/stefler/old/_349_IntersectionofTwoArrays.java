package com.stefler.old;

import java.util.HashMap;
import java.util.Map;

public class _349_IntersectionofTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Boolean> re1 = new HashMap<>();
		HashMap<Integer, Boolean> re2 = new HashMap<>();
		for (int i : nums1) {
			re1.put(i, true);
		}
		for (int i : nums2) {
			if (re1.get(i) != null) {
				re2.put(i, true);
			}
		}
		int[] re = new int[re2.size()];
		int i = 0;
		for (Map.Entry<Integer, Boolean> m : re2.entrySet()) {
			re[i++] = m.getKey();
		}
		return re;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] re = intersection(nums1, nums2);
		for (int i : re) {
			System.out.println(i);
		}

	}

}
