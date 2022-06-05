package com.stefler.cy2022;

public class _5LongestPalindromicSubstring {
    /**
     * 可以把空间复杂度降低，下次尝试一下
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] array = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            array[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                if (i == 1) {
                    array[j][j + i] = chars[j] == chars[j + i];
                } else {
                    array[j][j + i] = array[j + 1][j + i - 1] && chars[j] == chars[j + i];
                }
            }
        }
        int max = 1;
        String res = String.valueOf(chars[0]);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int max = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String left = findMax(s, i, i);
            String right = findMax(s, i, i + 1);
            if (left.length() > max) {
                res = left;
                max = left.length();
            }
            if (right.length() > max) {
                res = right;
                max = right.length();
            }
        }

        return res;
    }

    private static String findMax(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome1("aaaa"));
    }

}
