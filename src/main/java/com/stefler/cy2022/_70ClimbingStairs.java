package com.stefler.cy2022;


public class _70ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; ++i) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }


    public static void main(String[] args) {
//        System.out.println(null);
    }
}
