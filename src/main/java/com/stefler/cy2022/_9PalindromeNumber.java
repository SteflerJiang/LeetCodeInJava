package com.stefler.cy2022;

public class _9PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
    }

}
