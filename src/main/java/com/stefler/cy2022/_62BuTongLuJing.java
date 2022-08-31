package com.stefler.cy2022;


public class _62BuTongLuJing {

    public static int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }


    public static void main(String[] args) {
//        System.out.println(null);
    }
}
