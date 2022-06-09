package com.yochiu.algorithms.code_interviews;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left  < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                int[] res = new int[]{nums[left], nums[right]};
                return res;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
