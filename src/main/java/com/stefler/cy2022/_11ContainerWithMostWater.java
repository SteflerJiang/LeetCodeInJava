package com.stefler.cy2022;

public class _11ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int left = 0;
        int right = n-1;
        int max = (right - left) * Integer.min(height[left], height[right]);
        while (left < right) {
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
            max = Integer.max(max, (right - left) * Integer.min(height[left], height[right]));
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2}));
    }

}
