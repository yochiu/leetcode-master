package com.yochiu.algorithms.code_interviews;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */
public class TrapSolution {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        for (int i = 0; i < left.length; i++) {
            left[i] = max;
            max = Math.max(height[i], max);
        }
        max = height[height.length - 1];
        for (int i = height.length - 1; i>=0; i--) {
            right[i] = max;
            max = Math.max(height[i], max);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                sum += min -height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrapSolution solution = new TrapSolution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
