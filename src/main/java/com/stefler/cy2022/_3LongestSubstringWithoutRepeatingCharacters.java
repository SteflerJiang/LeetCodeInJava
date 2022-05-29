package com.stefler.cy2022;

import java.util.HashMap;
import java.util.Map;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            start = Integer.max(start, map.getOrDefault(c, -1) + 1);
            res = Integer.max(res, i - start + 1);
            map.put(c, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
    }

}
