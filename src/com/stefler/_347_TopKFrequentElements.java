/*
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Subscribe to see which companies asked this question
 * */


package com.stefler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _347_TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new LinkedList<Integer>();
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);

		}
		HashMap<Integer, LinkedList<Integer>> f = new HashMap<>();
		for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
			int key = m.getKey();
			int value = m.getValue();
			LinkedList<Integer> l = f.getOrDefault(value, new LinkedList<>());
			l.add(key);
			f.put(value, l);

		}
		for (int i = nums.length; i > 0 && k > 0; i--)
			if (f.containsKey(i)) {
				LinkedList<Integer> l = f.get(i);
				for (Integer in1 : l)
					if (k > 0) {
						res.add(in1);
						k--;
					} else
						break;
			}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1 };
		for (Integer in : topKFrequent(nums, 1)) {
			System.out.println(in);
		}
	}

}
