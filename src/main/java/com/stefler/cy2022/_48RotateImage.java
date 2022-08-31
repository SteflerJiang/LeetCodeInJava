package com.stefler.cy2022;

public class _48RotateImage {

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length-i-1][j];
                matrix[length-i-1][j] = tmp;
            }
        }
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public static void main(String[] args) {
//        System.out.println(rotate(null));
    }
}
