package com.stefler.cy2022;

public class _14LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder("");
        int start = 0;
        boolean flag = true;
        String first = strs[0];
        while (flag) {
            if (first.length() <= 0) {
                return "";
            }
            if (start >= first.length()) {
                break;
            }
            char c = first.charAt(start);
            int i= 1;
            for (i = 1; i < strs.length; ++i) {
                String str = strs[i];
                if (start >= str.length()) {
                    flag = false;
                    break;
                }
                if (c != str.charAt(start)) {
                    flag = false;
                    break;
                }
            }
            if (i == strs.length) {
                stringBuilder.append(c);
            }
            ++start;
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
