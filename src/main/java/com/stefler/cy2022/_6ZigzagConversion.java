package com.stefler.cy2022;

import java.util.Arrays;

public class _6ZigzagConversion {

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if (numRows <= 1 || s.length() <= 1 || s.length() >= numRows) {
            return s;
        }
        char[] res = new char[s.length()];
        int delta = 2 * numRows - 2;
        int length = s.length();
        int index = 0;
        int cnt1 = 0;
        while (true) {
            if (cnt1 * delta < length) {
                res[index++] = chars[cnt1 * delta];
                ++cnt1;
            } else {
                break;
            }

        }
        for (int i = 1; i < numRows - 1; i++) {
            int cnt = 0;
            while ((i + delta * cnt) < length) {
                res[index++] = chars[i + delta * cnt];
                if ((delta - i + delta * cnt) < length) {
                    res[index++] = chars[delta - i + delta * cnt];
                } else {
                    break;
                }
                ++cnt;
            }
        }
        int cnt2 = 0;
        while (true) {
            if ((numRows - 1 + delta * cnt2) < length) {
                res[index++] = chars[numRows - 1 + delta * cnt2];
                ++cnt2;
            } else {
                break;
            }
        }
        return String.valueOf(res);

    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

}
