package com.stefler.cy2022;

import java.util.Arrays;

public class _34FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    static int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left] == target ? left : -1;
            }
            if (left + 1 == right) {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }
                return -1;
            }
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }

    static int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left] == target ? left : -1;
            }
            if (left + 1 == right) {
                if (nums[right] == target) {
                    return right;
                }
                if (nums[left] == target) {
                    return left;
                }
                return -1;
            }
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
