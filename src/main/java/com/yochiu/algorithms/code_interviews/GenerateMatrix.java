package com.yochiu.algorithms.code_interviews;

/**
 * 给你一个正整数n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */

public class GenerateMatrix {


    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] array = generateMatrix.generateMatrix2(3);
        System.out.println("---");
    }

    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }


    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int num = 1;
        for (int i = 0; i < (n+1) /2; i++) {
            num = generateMatrix(i, n, array, num);
        }
        return array;
    }

    public int generateMatrix(int index, int n, int[][] array, int num) {

       for (int i = index; i < n - index; i++) {
           array[index][i] = num++;
       }

       if (n % 2 != 0 && index == (n+1)/2 - 1) {
           return num;
       }

       for (int i = index + 1; i < n- index -1; i++) {
           array[i][n- index - 1] = num++;
       }

       for (int i = n - index - 1; i>= index; i--) {
           array[n-index - 1][i] = num++;
       }

       for (int i = n - index - 2; i > index; i--){
           array[i][index] = num++;
       }

       return num;
    }

}
