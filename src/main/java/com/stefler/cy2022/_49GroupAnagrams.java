package com.stefler.cy2022;

import java.util.*;

public class _49GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.computeIfAbsent(sort(s), s1 -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }


    public static void main(String[] args) {
//        System.out.println(rotate(null));
    }
}
