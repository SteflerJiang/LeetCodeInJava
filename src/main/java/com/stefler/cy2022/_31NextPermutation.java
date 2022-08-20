package com.stefler.cy2022;

import java.util.*;

public class _31NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length <=1) return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length-1; i>0; i--) {
            int index = findMin(nums, i);
            if (index != -1) {
                if (!map.containsKey(index)) {
                    map.put(index, i);
                }

            }
        }
        if (map.isEmpty()) {
            sort(nums, 0, nums.length-1);
        } else {
            int max = map.keySet().stream().max(Integer::compareTo).get();
            switchPos(nums, map.get(max), max);
            sort(nums, max+1, nums.length-1);
        }

    }

    public static void switchPos(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void sort(int[] nums, int left, int right) {
        if (left == right) return;
        List<Integer> list = new ArrayList<>(right-left+1);
        for (int i = left; i <=right; i++) {
            list.add(nums[i]);
        }
        list.sort(Integer::compareTo);
        for (int i = left; i <=right; i++) {
            nums[i] = list.get(i-left);
        }
    }

    public static int findMin(int[] nums, int index) {
        for (int i = index-1; i>=0; i--) {
            if (nums[i] < nums[index]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
