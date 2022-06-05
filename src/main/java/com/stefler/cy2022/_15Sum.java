package com.stefler.cy2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) {
                break;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) ++L;
                    while (L < R && nums[R] == nums[R - 1]) --R;
                    ++L;
                    --R;
                } else if (sum < 0) ++L;
                else --R;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

}
