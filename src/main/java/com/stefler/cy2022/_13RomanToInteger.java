package com.stefler.cy2022;

public class _13RomanToInteger {

    public static int romanToInt(String num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int res = 0;
        for (int i = 0; i < values.length; ++i) {
            while (num.startsWith(symbols[i])) {
                res += values[i];
                num = num.replaceFirst(symbols[i], "");
            }
            if (num.length() <= 0) {
                return res;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

}
