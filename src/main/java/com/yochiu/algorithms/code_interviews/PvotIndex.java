package com.yochiu.algorithms.code_interviews;

import java.util.Arrays;

public class PvotIndex {

    public int pivotIndex(int[] nums) {
        int sum  = Arrays.stream(nums).sum();
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum - nums[i] - preSum == preSum) {
                return i;
            }
            preSum += nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        PvotIndex pvotIndex = new PvotIndex();
        System.out.println(pvotIndex.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
