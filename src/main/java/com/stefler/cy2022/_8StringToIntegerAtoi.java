package com.stefler.cy2022;

public class _8StringToIntegerAtoi {

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != ' ') {
                break;
            }
        }
        if (i == chars.length) {
            return 0;
        }
        boolean isPositive = true;
        if (chars[i] == '-') {
            ++i;
            isPositive = false;
        } else if (chars[i] == '+') {
            ++i;
        }
        int res = 0;
        while (i < chars.length) {
            if (Character.isDigit(chars[i])) {
                int digit = chars[i] - '0';
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + Integer.parseInt(String.valueOf(chars[i]));
            } else {
                break;
            }
            ++i;
        }
        if (!isPositive) {
            res = res * -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }

}
