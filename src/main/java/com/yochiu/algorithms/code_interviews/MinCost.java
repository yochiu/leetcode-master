package com.yochiu.algorithms.code_interviews;

public class MinCost {

    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i]= costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        int len = costs.length - 1;
        return Math.min(Math.min(dp[len][0], dp[len][1]), dp[len][2]);
    }

}
