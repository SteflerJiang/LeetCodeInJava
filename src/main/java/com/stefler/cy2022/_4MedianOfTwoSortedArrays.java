package com.stefler.cy2022;

public class _4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] array = new int[m + n];
        if (m == 0) {
            array = nums2;
        } else if (n == 0) {
            array = nums1;
        } else {
            while (i < m && j < n) {
                int a = nums1[i];
                int b = nums2[j];
                if (a < b) {
                    array[i + j] = a;
                    ++i;
                } else {
                    array[i + j] = b;
                    ++j;
                }
                if (i == m) {
                    for (int x = i + j; x < m + n; x++) {
                        array[x] = nums2[j++];
                    }
                    break;
                }
                if (j == n) {
                    for (int x = i + j; x < m + n; x++) {
                        array[x] = nums1[i++];
                    }
                    break;
                }
            }
        }
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2.0;
        } else {
            return array[array.length / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{3}));
    }

}
