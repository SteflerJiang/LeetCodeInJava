package com.stefler.cy2022;

public class _7ReverseInteger {

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
