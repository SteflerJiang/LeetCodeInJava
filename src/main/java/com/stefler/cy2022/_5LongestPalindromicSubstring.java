package com.stefler.cy2022;

public class _5LongestPalindromicSubstring {
    /**
     * 可以把空间复杂度降低，下次尝试一下
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

    public static void main(String[] args) {
        System.out.println(longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }

}
