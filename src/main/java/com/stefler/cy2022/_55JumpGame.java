package com.stefler.cy2022;

public class _55JumpGame {

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; ++i) {
            int num = nums[i];
            if (i<=max) {
                max = Math.max(max, i+num);
            }
            if (max >= length-1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[] {0,2,3}));
    }
}
