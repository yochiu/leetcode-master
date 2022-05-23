package com.yochiu.algorithms.code_interviews;

public class NumMatrix {

    private int[][] maxtrix;
    private int row;
    private int col;

    public NumMatrix(int[][] matrix) {
        this.maxtrix = matrix;
        this.row = maxtrix.length;
        this.col = matrix[0].length;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
       if (row1 < 0 || row1 >= row || row2 < 0 || row2 > row) {
           return 0;
       }
       if (col1 < 0 || col1 >= col || col2 < 0 || col2 >= col) {
           return 0;
       }
       if (row1 > row2 || col1 > col2) {
           return 0;
       }
       int sum = 0;
       for (int i = row1; i <= row2; i++) {
           for (int j = col1; j <= col2; j++) {
               sum += maxtrix[i][j];
           }
        }
       return sum;
    }
}
