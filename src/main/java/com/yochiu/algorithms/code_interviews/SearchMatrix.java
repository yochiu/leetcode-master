package com.yochiu.algorithms.code_interviews;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 *
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 */
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1, m = matrix[0].length - 1;
        int row = n, column = 0;
        while (row >= 0 && column <= m) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }

}
