package com.stefler.cy2022;


public class _72EditDistance {

    public static int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        if (i * j == 0) {
            return i + j;
        }
        int[][] d = new int[i + 1][j + 1];
        for (int m = 0; m <= i; m++) {
            d[m][0] = m;
        }
        for (int m = 0; m <= j; m++) {
            d[0][m] = m;
        }
        for (int m = 1; m <= i; ++m) {
            for (int n = 1; n <= j; ++n) {
                if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
                    d[m][n] = d[m - 1][n - 1];
                } else {
                    d[m][n] = Math.min(Math.min(
                                    d[m - 1][n], // delete
                                    d[m - 1][n - 1]), // update
                            d[m][n - 1]) + 1; // add
                }
            }
        }
        return d[i][j];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("aa", "bb"));
    }
}
