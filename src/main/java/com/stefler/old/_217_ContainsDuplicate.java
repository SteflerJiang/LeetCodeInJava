/*
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Subscribe to see which companies asked this question
 * */

package com.stefler.old;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
    	Set<Integer> s = new HashSet<>();
    	for (int num : nums) {
			if (!s.add(num)) return true;
		}
    	return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
