/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

 */


package com.stefler.old;

import java.util.Iterator;
import java.util.LinkedList;

public class _318_MaximumProductofWordLengths {
//	 public int maxProduct(String[] words) {
//        int res = 0;
//        int size = words.length;
//        boolean[][] p = new boolean[size][26];
//        for (int i = 0; i < size; i++) {
//			boolean[] e = p[i];
//			for (char b : words[i].toCharArray()) {
//				e[b - 'a'] = true;
//			}
//		}
//        for (int i = 0; i < size - 1; i++) {
//        	LinkedList<Integer> l = new LinkedList<>();
//        	for (int j = 0; j < 26; j++) {
//        		if (p[i][j]) l.push(j);
//        	}
//        	
//        	for (int j = i + 1; j < size; j++) {
//        		boolean same = true;
//        		for (Integer integer : l) {
//					if (p[j][integer]) {
//						same = false;
//						break;
//					}
//				}
//        		if (same) {
//        			int r = words[i].length() * words[j].length();
//        			res = r > res ? r : res;
//        		}
//        	}
//        }
//        return res;
//    }
	
	
	public static int maxProduct(String[] words) {
		if (words == null || words.length == 0) return 0;
		int size = words.length;
		int[] values = new int[size];
		for (int i = 0; i < size; i++) {
			String word = words[i];
			int value = 0;
			for (char w : word.toCharArray()) {
				value |= 1 << (w - 'a');
			}
			values[i] = value;
		}
		int maxProduct = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if ((values[i] & values[j]) == 0 && words[i].length() * words[j].length() > maxProduct)
					maxProduct = words[i].length() * words[j].length();
			}
		}
		return maxProduct;
    }

	public static void main(String[] args) {
		String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		System.out.println(maxProduct(words));
	}

}
