package com.stefler.cy2022;


import java.util.HashMap;
import java.util.Map;

public class _76MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapt = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> maps = new HashMap<>();
        int resl = 0, resr = Integer.MAX_VALUE;
        int l = 0, r = t.length()-1;
        int length = s.length();
        char[] chars = s.toCharArray();
        while (r < length) {
            char c = chars[r];
            maps.put(c, maps.getOrDefault(c, 0) + 1);
            if (contains(maps, mapt)) {
                if (r - l < resr - resl) {
                    resr = r;
                    resl = l;
                }
                while (true) {
                    char cl = chars[l];
                    ++l;
                    maps.put(cl, maps.get(cl) - 1);
                    if (contains(maps, mapt)) {
                        if (r - l < resr - resl) {
                            resr = r;
                            resl = l;
                        }
                    } else {
                        break;
                    }
                }
            }
            ++r;
        }
        if (resr == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(resl, resr + 1);
        }
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
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
