package com.stefler.cy2022;


import java.util.ArrayList;
import java.util.List;

public class _78Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        next(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static void next(int index, int[] nums, List<Integer> current, List<List<Integer>> res) {
        if (index < nums.length) {
            int i = nums[index];
            ++index;
            next(index, nums, new ArrayList<>(current), res);
            List<Integer> currentTmp = new ArrayList<>(current);
            currentTmp.add(i);
            next(index, nums, currentTmp, res);
        } else {
            res.add(current);
        }
    }


    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
