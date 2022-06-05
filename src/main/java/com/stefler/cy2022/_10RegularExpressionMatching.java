package com.stefler.cy2022;

public class _10RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (p1[j - 1] != '*') {
                    if (match(s1, i , p1, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                } else {
                    if (!match(s1, i , p1, j-1)) {
                        f[i][j] = f[i][j - 2];
                    } else {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];
                    }
                }
            }
        }

        return f[m][n];
    }

    private static boolean match(char[] s1, int i, char[] p1, int j) {
        if (i==0) return false;
        if (p1[j-1] == '.') return true;
        return s1[i-1] == p1[j-1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aac", "a*c"));
    }

}
