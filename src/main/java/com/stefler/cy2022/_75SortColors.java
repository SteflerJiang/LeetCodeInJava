package com.stefler.cy2022;


public class _75SortColors {

public static void sortColors(int[] nums) {
    int cnt0 = 0, cnt1 = 0, cnt2 = 0;
    for (int num : nums) {
        if (num == 0) ++cnt0;
        else if (num == 1) ++cnt1;
        else ++cnt2;
    }

    int start = 0;
    for (int i = 0; i < cnt0; ++i) {
        nums[start++] = 0;
    }
    for (int i = 0; i < cnt1; ++i) {
        nums[start++] = 1;
    }
    for (int i = 0; i < cnt2; ++i) {
        nums[start++] = 2;
    }
}


    public static void main(String[] args) {
        sortColors(new int[]{0});
//        System.out.println(minDistance("aa", "bb"));
    }
}
