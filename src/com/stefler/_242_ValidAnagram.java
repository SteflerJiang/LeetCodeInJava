/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 */


package com.stefler;

//import java.util.HashMap;
//import java.util.Map.Entry;


public class _242_ValidAnagram {
	
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
	    int[] count = new int[26];
	    for (char c : s.toCharArray()) {
	        count[c - 'a']++;
	    }
	    for (char c : t.toCharArray()) {
	        count[c - 'a']--;
	        if (count[c - 'a'] < 0) return false;
	    }
	    return true;
//		if(s.length() != t.length()) return false;
//        boolean res = true;
//        HashMap<Character, Integer> sh = new HashMap<>();
//        HashMap<Character, Integer> th = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			sh.put(c, sh.getOrDefault(c, 0) + 1);
//		}
//        for (int i = 0; i < t.length(); i++) {
//			char c = t.charAt(i);
//			th.put(c, th.getOrDefault(c, 0) + 1);
//		}
//        
//        if (sh.size() != th.size()) return false;
//        
//        for(Entry<Character, Integer> m : sh.entrySet())
//        {
//        	if(th.getOrDefault(m.getKey(), 0) != m.getValue()) {
//        		res = false;
//        		break;
//        	}
//        }
//        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("", ""));
	}

}
