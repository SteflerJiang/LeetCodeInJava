package com.stefler.cy2022;

import java.util.*;

public class _53MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    public static void main(String[] args) {
//        System.out.println(rotate(null));
    }
}
