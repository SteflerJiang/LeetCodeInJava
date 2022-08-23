package com.stefler.cy2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        get(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public static void get(List<List<Integer>> res, List<Integer> tmpList, int[] candidates, int index, int remain) {
        if (index >= candidates.length) {
            return;
        }
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(tmpList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            List<Integer> tmpList1 = new ArrayList<>(tmpList);
            tmpList1.add(candidates[i]);
            get(res, tmpList1, candidates, i, remain - candidates[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 10));
    }
}
