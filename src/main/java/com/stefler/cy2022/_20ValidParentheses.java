package com.stefler.cy2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)){
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (!left.equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{"));
    }
}
