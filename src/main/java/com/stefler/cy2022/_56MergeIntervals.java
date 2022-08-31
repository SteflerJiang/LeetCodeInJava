package com.stefler.cy2022;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] ints : intervals) {
            boolean hit = false;
            for (Interval interval : list) {
                if (interval.merge(ints[0], ints[1])) {
                    hit = true;
                    break;
                }
            }
            if (!hit) {
                list.add(new Interval(ints[0], ints[1]));
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            res[i][0] = list.get(i).left;
            res[i][1] = list.get(i).right;
        }
        return res;
    }

    static class Interval {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }


        boolean merge(int newLeft, int newRight) {
            if (newLeft > right || newRight < left) {
                return false;
            }
            left = Math.min(newLeft, left);
            right = Math.max(newRight, right);
            return true;
        }
    }


    public static void main(String[] args) {
//        System.out.println(null);
    }
}
