package com.stefler.cy2022;

public class _4MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0) {
            return (findMiddle(nums1, 0, nums2, 0, (m + n + 1) / 2)
                    + findMiddle(nums1, 0, nums2, 0, (m + n + 2) / 2)) / 2;
        } else {
            return findMiddle(nums1, 0, nums2, 0, (m + n + 1) / 2);
        }
    }

    /**
     * 找到两个有序数组的第K大数字
     *
     * @param num1 数组1
     * @param i    数组1起始位置
     * @param num2 数组2
     * @param j    数组2起始位置
     * @param k    K大
     * @return 找到的数字
     */
    private static double findMiddle(int[] num1, int i, int[] num2, int j, int k) {
        int half = k / 2;
        if (i >= num1.length) {
            return num2[j + k - 1];
        }
        if (j >= num2.length) {
            return num1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(num1[i], num2[j]);
        }
        int num1MidValue = (i + half - 1) < num1.length ? num1[i + half - 1] : Integer.MAX_VALUE;
        int num2MidValue = (j + half - 1) < num2.length ? num2[j + half - 1] : Integer.MAX_VALUE;
        if (num1MidValue < num2MidValue) {
            return findMiddle(num1, i+half, num2, j, k-half);
        } else {
            return findMiddle(num1, i, num2, j + half, k - half);
        }
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int i = 0;
//        int j = 0;
//        int m = nums1.length;
//        int n = nums2.length;
//        int[] array = new int[m + n];
//        if (m == 0) {
//            array = nums2;
//        } else if (n == 0) {
//            array = nums1;
//        } else {
//            while (i < m && j < n) {
//                int a = nums1[i];
//                int b = nums2[j];
//                if (a < b) {
//                    array[i + j] = a;
//                    ++i;
//                } else {
//                    array[i + j] = b;
//                    ++j;
//                }
//                if (i == m) {
//                    for (int x = i + j; x < m + n; x++) {
//                        array[x] = nums2[j++];
//                    }
//                    break;
//                }
//                if (j == n) {
//                    for (int x = i + j; x < m + n; x++) {
//                        array[x] = nums1[i++];
//                    }
//                    break;
//                }
//            }
//        }
//        if (array.length % 2 == 0) {
//            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2.0;
//        } else {
//            return array[array.length / 2];
//        }
//    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}));
    }

}
