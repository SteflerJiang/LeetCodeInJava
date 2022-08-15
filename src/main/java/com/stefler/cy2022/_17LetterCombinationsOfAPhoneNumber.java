package com.stefler.cy2022;

import java.util.*;

public class _17LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> set = new ArrayList<>();

        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        int cnt = 1;
        List<Integer> chushu = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (char char1 : chars) {
            characters.add(char1);
        }
        for (int i = 0; i < characters.size(); i++) {
            chushu.add(cnt);
            cnt = cnt * (map.get(characters.get(characters.size() - i - 1)).length);
        }
        Collections.reverse(chushu);

        for (int i = 0; i < cnt; i++) {
            int current = i;
            StringBuilder sb = new StringBuilder(3);
            for (int num = 0; num < chars.length; ++num) {
                sb.append(map.get(chars[num])[current / chushu.get(num)]);
                current = current % chushu.get(num);
            }
            set.add(sb.toString());
        }
        return set;
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("22"));
    }

}
