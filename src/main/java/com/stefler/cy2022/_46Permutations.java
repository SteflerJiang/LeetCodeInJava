package com.stefler.cy2022;

import java.util.ArrayList;
import java.util.List;

public class _46Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> remain = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            remain.add(i);
        }
        calc(res, nums, remain, new ArrayList<>());
        return res;
    }

    public static void calc(List<List<Integer>> res, int[] nums, List<Integer> remain, List<Integer> now) {
        if (remain.isEmpty()) {
            res.add(now);
            return;
        }
        for (int i = 0; i < remain.size(); i++) {
            List<Integer> tmpRemain = new ArrayList<>(remain);
            int index = tmpRemain.remove(i);
            List<Integer> tmpNow = new ArrayList<>(now);
            tmpNow.add(nums[index]);
            calc(res, nums, tmpRemain, tmpNow);
        }
    }


    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
