package com.stefler.cy2022;


import java.util.HashMap;
import java.util.Map;

public class _76MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        if (!contains(maps, mapt)) {
            return "";
        }
        int left = 0;
        int right = s.length() - 1;
        while (true) {
            char c = s.charAt(left);
            maps.put(c, maps.get(c) - 1);
            if (contains(maps, mapt)) {
                ++left;
            } else {
                maps.put(c, maps.get(c) + 1);
                break;
            }
        }
        while (true) {
            char c = s.charAt(right);
            maps.put(c, maps.get(c) - 1);
            if (contains(maps, mapt)) {
                --right;
            } else {
                maps.put(c, maps.get(c) + 1);
                break;
            }
        }

        int left1 = 0;
        int right1 = s.length() - 1;
        maps = new HashMap<>();
        mapt = new HashMap<>();
        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        while (true) {
            char c = s.charAt(right1);
            maps.put(c, maps.get(c) - 1);
            if (contains(maps, mapt)) {
                --right1;
            } else {
                maps.put(c, maps.get(c) + 1);
                break;
            }
        }
        while (true) {
            char c = s.charAt(left1);
            maps.put(c, maps.get(c) - 1);
            if (contains(maps, mapt)) {
                ++left1;
            } else {
                maps.put(c, maps.get(c) + 1);
                break;
            }
        }
        if ((right - left) < (right1 - left1)) {
            return s.substring(left, right + 1);
        }
        return s.substring(left1, right1 + 1);

    }

    static boolean contains(Map<Character, Integer> maps, Map<Character, Integer> mapt) {
        for (Map.Entry<Character, Integer> e : mapt.entrySet()) {
            if (maps.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
