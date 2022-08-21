package com.stefler.cy2022;

import java.util.Stack;

public class _33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int middle = nums.length / 2;
        return Math.max(middleFind(nums, 0, middle-1, target), middleFind(nums, middle, nums.length - 1, target));
    }

    public static int middleFind(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left] == target? left: -1;
        }
        if (nums[left] < nums[right]) {
            return erfen(nums, left, right, target);
        } else  {
            int middle = (left+right)/2;
            return Math.max(middleFind(nums, left, middle, target), middleFind(nums, middle+1, right, target));
        }
    }

    public static int erfen(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (left+right)/2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] < target) {
            return erfen(nums, middle + 1, right, target);
        } else {
            return erfen(nums, left, middle-1, target);

        }
    }

    public static void main(String[] args) {
        System.out.println(search(null, 0));
    }
}
