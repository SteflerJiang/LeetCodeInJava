package com.stefler.cy2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = Integer.MAX_VALUE;
        int sum1 = 0;
        for (int i = 0; i < length-2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = target-(nums[i] + nums[L] + nums[R]);
                if (sum == 0) {
                    return target;
                }
                if (res > Math.abs(sum)) {
                    sum1 = nums[i] + nums[L] + nums[R];
                    res = Math.abs(sum);
                }
//                while (L < R && nums[L] == nums[L + 1]) ++L;
//                while (L < R && nums[R] == nums[R - 1]) --R;
                if (sum > 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return sum1;
    }


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55}, 3));
    }

}
