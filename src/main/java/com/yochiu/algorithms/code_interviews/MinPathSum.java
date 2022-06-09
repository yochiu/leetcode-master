package com.yochiu.algorithms.code_interviews;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][] array = new int[grid.length +1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                array[i+1][j+1] = Math.min(array[i+1][j], array[i][j+1]) + grid[i][j];
            }
        }

        return array[array.length - 1][array[0].length - 1];
    }
}
