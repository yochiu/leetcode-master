package com.yochiu.algorithms.code_interviews;


/**
 * 给定一个 n*n 的二维矩阵matrix表示一个图像
 * 请你将图像顺时针旋转90度
 * 你必须在原地旋转图像, 这意味着你需要直接修改输入的二维矩阵, 请不要 使用另一个矩阵来旋转图像
 *
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < (matrix.length - i - 1); j++) {
                int a = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];

                int b = matrix[n-i][n-j];
                matrix[n-i][n-j] = a;

                int c = matrix[n-j][i];
                matrix[n-j][i] = b;

                matrix[i][j] = c;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }



    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] a = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        rotate.rotate2(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}

